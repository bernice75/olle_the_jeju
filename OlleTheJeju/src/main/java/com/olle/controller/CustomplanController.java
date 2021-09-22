package com.olle.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.olle.biz.customplan.CustomBiz;
import com.olle.biz.etc.DateBiz;
import com.olle.biz.etc.HashBiz;
import com.olle.biz.etc.ImgBiz;
import com.olle.biz.member.MemberBiz;
import com.olle.dto.customplan.CustomDto;
import com.olle.dto.etc.DateDto;
import com.olle.dto.etc.HashtagDto;
import com.olle.dto.etc.ImgDto;
import com.olle.dto.member.MemberDto;
import com.olle.dto.pagination.Paging;

@Controller
public class CustomplanController {
	
	@Autowired
	private CustomBiz cusbiz;

	@Autowired
	private HashBiz hashbiz;

	@Autowired
	private DateBiz datebiz;
	
	@Autowired
	private ImgBiz imgBiz;
	
	@RequestMapping(value = "customplan_main.do", method = RequestMethod.GET)
	public String customplan_main(Model model, String search, @RequestParam(value="page", defaultValue="1") int page) {
		System.out.println("search : " + search);
		if(search == null||search == "") {
			search = "전체";
		}
		
		Paging pg = new Paging();
		pg.setPage(page);
		pg.setBeginPage(page);
      	pg.setTotalCount(cusbiz.getAllCount(search));
      	
      	model.addAttribute("paging", pg);
      	
      	//------------------페이지 관련 --------------------------

		//글 받아오기
		List<CustomDto> plan = cusbiz.selectList(search, page);
		System.out.println("넘어온 게시물 개수 : " + plan.size());
		model.addAttribute("planList", plan);
		
		//나만의 일정 게시판에 대한 이미지 가져오기 - 각 게시물당 하나의 이미지만
		List<ImgDto> imgList = imgBiz.selectList(3);
		List<ImgDto> nameList = new ArrayList<ImgDto>();
		
		for(ImgDto idx : imgList) {
			for(CustomDto pidx : plan) {
				if(pidx.getPlan_num() == idx.getTable_num()) {
					if(idx.getGroup_num() == 3) {
						nameList.add(idx);
					}
				}
			}
		}
		
		System.out.println("게시물과 매칭된 이미지 개수 : " + nameList.size());
		
		model.addAttribute("imgList", nameList);
		
		//나만의 일정 게시판에 대한 해시태그 받아오기
		List<HashtagDto> hashList = hashbiz.selectList(3);
		
		model.addAttribute("hashList", hashList);
		
		return "page_customplan/customplan";
	}
	
	@RequestMapping(value = "customplan_detail.do", method = RequestMethod.GET)
	public String customplan_detail(Model model,int plan_num,HttpServletRequest req) throws ParseException {
		
		//======관광지 정보 받아오기
		JSONParser trip_parser = new JSONParser();
		JSONArray trip = new JSONArray();
		
		try {
			Reader trip_reader = new FileReader(req.getSession().getServletContext().getRealPath("/") + "/resources/json/trip.json");
			JSONObject trip_obj = (JSONObject)trip_parser.parse(trip_reader);
			
			trip = (JSONArray)trip_obj.get("trip");
			
			model.addAttribute("trip", trip);
		} catch(IOException e) {
			e.printStackTrace();
		}
		//======관광지 정보 받아오기 끝
		
		//나만의 일정 디테일 페이지 값 가져오기
		model.addAttribute("CustomDto", cusbiz.selectOne(plan_num));
		
		//나만의 일정 이미지 가져오기
		model.addAttribute("ImgDto", imgBiz.selectDetailList(plan_num));
		
		//이미지 경로
		String path = req.getSession().getServletContext().getRealPath("/") + "/resources/plan/";
		model.addAttribute("path",path);
		
		//나만의 일정 지도 부분 가져오기
		model.addAttribute("DateDto", datebiz.selectList(plan_num));
		
		//나만의 일정 해쉬태그 가져오기
		model.addAttribute("HashDto", hashbiz.selectOne(plan_num));
		
		return "page_customplan/customplan_detail";
	}
	
	@RequestMapping(value = "customplan_insert.do", method = RequestMethod.POST)
	public void customplan_insert(HttpServletRequest req
			, @RequestParam("img_1") MultipartFile img_1
			, @RequestParam("img_2") MultipartFile img_2
			, @RequestParam("img_3") MultipartFile img_3
			, HttpServletResponse response) throws IOException {
		//1. plan 관련 저장
		String plan_title = req.getParameter("plan_title");
		String plan_content = req.getParameter("plan_content");
		String plan_writer = req.getParameter("plan_writer");
		String plan_tendency = req.getParameter("tend_content");
		
		//글 번호 따오기
		int plan_num = cusbiz.maxNum();
		plan_num = plan_num + 1;
		
		CustomDto plan = new CustomDto();
		plan.setPlan_num(plan_num);
		plan.setPlan_title(plan_title);
		plan.setPlan_content(plan_content);
		plan.setPlan_writer(plan_writer);
		plan.setPlan_tendency(plan_tendency);
		plan.setPlan_term("1박2일");

		//글 관련 저장
		int res = cusbiz.insert(plan);

		if(res > 0) {
			System.out.println("기본 글 정보 저장을 완료했습니다.");
			//2. 해시태그 관련 저장
			String hash = req.getParameter("hash_content");
			HashtagDto hashDto = new HashtagDto();
			hashDto.setHash_num(hashbiz.maxNum() + 1);
			hashDto.setBoard_num(3);
			hashDto.setTable_num(plan_num);
			hashDto.setHash_content(hash);
			System.out.println("게시판 번호: " + hashDto.getBoard_num() + ", 게시물번호: " + hashDto.getTable_num() + ", 태그내용: " + hashDto.getHash_content());
			int hashRes = hashbiz.insert(hashDto);
			
			if(hashRes > 0) {
				System.out.println("해시태그 저장 완료");
			}

			//3. 지도 관련 저장
			String[] lst_title = req.getParameterValues("lst_title");
			String[] lst_addr =  req.getParameterValues("lst_addr");
			String[] lst_phone = req.getParameterValues("lst_phone");
			String[] lst_lat = req.getParameterValues("lst_lat");
			String[] lst_lon = req.getParameterValues("lst_lon");
			
			int mapRes = 0;
			for(int i = 0; i < lst_title.length; i++) {
				DateDto date = new DateDto();
				for(int j = 0; j <= i; j++) {
					date.setDate_num(datebiz.maxNum() + 1);
					date.setBoard_num(3);
					date.setTable_num(plan_num);
					date.setGroup_num(i+1);
					date.setDate_lat(Double.parseDouble(lst_lat[j]));
					date.setDate_lon(Double.parseDouble(lst_lon[j]));
					date.setDate_name(lst_title[j]);
					date.setDate_addr(lst_addr[j]);
					date.setDate_phone(lst_phone[j]);
					
					int lstRes = datebiz.insert(date);
					if(lstRes > 0) {
						mapRes++;
					}
				}
			}
			
			if(mapRes > 0) {
				System.out.println("지도 관련 저장 완료");
			}
			//4. 이미지 관련 저장
			String path = req.getSession().getServletContext().getRealPath("/") + "/resources/plan";
			
			
			
			//db에 저장할 이름
			String fileName_1 = img_1.getOriginalFilename();
			String fileName_2 = img_2.getOriginalFilename();
			String fileName_3 = img_3.getOriginalFilename();
			
			List<String> imgName = new ArrayList<String>();
			imgName.add(fileName_1);
			imgName.add(fileName_2);
			imgName.add(fileName_3);

			//폴더에 이미지 파일 저장 -------------------------------------------------------
			InputStream input = null;
			OutputStream out = null;

			input = img_1.getInputStream();
			File store = new File(path);
			System.out.println(path);
			if(!store.exists()) {
	            try {
	               //디렉토리 생성
	            	store.mkdirs();
	               System.out.println("디렉토리 생성 성공");
	            } catch (Exception e) {
	               System.out.println("디렉토리 생성 실패");
	               e.printStackTrace();
	            }
	        }
			//img_1 파일에 대한 처리---------------------------------
			File newFile = new File(path + "/" + fileName_1);
			//해당 경로 안에 해당하는 파일이 존재하는지 여부
	        if(!newFile.exists()) {
	           //새로 생성
	           newFile.createNewFile();
	        }

	        out = new FileOutputStream(newFile);

	        int read = 0;
	        byte[] b = new byte[(int)img_1.getSize()];

	        while((read = input.read(b)) != -1) {
	           //파일 저장
	           out.write(b, 0, read);
	        }
	        //img_1 파일에 대한 처리 마감 ----------------------------

	        //img_2 처리 시작 --------------------------------
	        newFile = new File(path + "/" + fileName_2);
	        if(!newFile.exists()) {
	           //새로 생성
	           newFile.createNewFile();
	        }

	        out = new FileOutputStream(newFile);

	        read = 0;
	        b = new byte[(int)img_2.getSize()];

	        while((read = input.read(b)) != -1) {
	           //파일 저장
	           out.write(b, 0, read);
	        }
	        //img_2 파일에 대한 처리 마감 ----------------------------
			//img_3 처리 시작 ----------------------------
	         newFile = new File(path + "/" + fileName_3);
	         if(!newFile.exists()) {
	            //새로 생성
	            newFile.createNewFile();
	         }

	         out = new FileOutputStream(newFile);

	         read = 0;
	         b = new byte[(int)img_3.getSize()];

	         while((read = input.read(b)) != -1) {
	            //파일 저장
	            out.write(b, 0, read);
	         }
	         //폴더에 이미지 파일 저장 끝 -------------------------------------------------------
	         
	         int resImg = 0;
	         
	         //이미지 파일명 테이블 저장
	         for(int i = 0; i < imgName.size(); i++) {
	        	 ImgDto img = new ImgDto();
	        	 img.setGroup_num(i+1);
	        	 img.setImg_title(imgName.get(i));
	        	 img.setTable_num(plan_num);
	        	 imgBiz.cusInsert(img);
	        	 resImg++;
	         }
	         
	         if(resImg == 3) {
				System.out.println("이미지 3장 모두 저장 완료");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter pw = response.getWriter();
				pw.println("<script>alert('글이 등록되었습니다.'); location.href='customplan_main.do';</script>");
				pw.flush();
	         }

		} else {
			System.out.println("글 저장에 실패했습니다.");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter pw = response.getWriter();
			pw.println("<script>alert('글이 등록을 실패했습니다.'); location.href='history.back()';</script>");
			pw.flush();
		}
	}
	
	//지도 관련 제이슨으로 받아서 처리하는 메서드
	@RequestMapping(value = "customplan_insert.do", method = RequestMethod.GET)
	public String customplan_Tmap(Model model, HttpServletRequest req) throws ParseException {
		JSONParser trip_parser = new JSONParser();
		JSONArray trip = new JSONArray();
		
		try {
			Reader trip_reader = new FileReader(req.getSession().getServletContext().getRealPath("/") + "/resources/json/trip.json");
			JSONObject trip_obj = (JSONObject)trip_parser.parse(trip_reader);
			
			trip = (JSONArray)trip_obj.get("trip");
			
			model.addAttribute("trip", trip);
		} catch(IOException e) {
			e.printStackTrace();
		}
		//-----------------------------------------관광지 관련 데이터 끝
		return "page_customplan/customplan_insert";
	}
	
	
	
	
	
}