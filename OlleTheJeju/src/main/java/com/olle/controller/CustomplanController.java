package com.olle.controller;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.olle.biz.admin.ReportBiz;
import com.olle.biz.customplan.CustomBiz;
import com.olle.biz.etc.DateBiz;
import com.olle.biz.etc.DibBiz;
import com.olle.biz.etc.HashBiz;
import com.olle.biz.etc.ImgBiz;
import com.olle.biz.mypage.MypageBiz;
import com.olle.dto.admin.ReportDto;
import com.olle.dto.customplan.CustomDto;
import com.olle.dto.etc.DateDto;
import com.olle.dto.etc.DibDto;
import com.olle.dto.etc.HashtagDto;
import com.olle.dto.etc.ImgDto;
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
	
	@Autowired
	private MypageBiz mbiz;
	
	@Autowired
	private DibBiz dBiz;
	
	@Autowired
	private ReportBiz repbiz;
	
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
		
		//해시태그 조회
		CustomDto dto = new CustomDto();
		int plan_num = 0;
		List<HashtagDto> hash = new ArrayList<HashtagDto>();
		for(int i = 0; i < plan.size(); i++) {
			dto.setPlan_num(plan.get(i).getPlan_num());
			plan_num = dto.getPlan_num();
			hash.add(i, mbiz.hashList(plan_num));
		}
		//해시태그 형식은 해시1, 해시2 이런 방식이므로 대표 1개의 해시태그만 끊어오려면 split을 사용
		List<HashtagDto> hashList = new ArrayList<HashtagDto>();
		for(int i = 0; i < hash.size(); i++) {
			HashtagDto hashTag = new HashtagDto();
			hashTag.setHash_num(hash.get(i).getHash_num());
			hashTag.setBoard_num(hash.get(i).getBoard_num());
			hashTag.setTable_num(hash.get(i).getTable_num());
			hashTag.setHash_content(hash.get(i).getHash_content().split(",")[0]);
			hashList.add(i, hashTag);
		}
		
		model.addAttribute("hashList", hashList);
		
		return "page_customplan/customplan";
	}
	
	@RequestMapping(value = "customplan_detail.do", method = RequestMethod.GET)
	public String customplan_detail(int plan_num, Model model, HttpServletRequest req) throws ParseException {
		
		plan_num = Integer.parseInt(req.getParameter("plan_num"));
		
		cusbiz.updateView(plan_num);
		
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
		
		//찜 개수 가져오기
		model.addAttribute("dib", dBiz.countDib(plan_num));
		
		return "page_customplan/customplan_detail";
	}
	
	@RequestMapping(value="customplan_push.do", method = RequestMethod.POST)
	@ResponseBody
	public String customplan_push(int plan_num) {
		String result = "";
		int res = cusbiz.updatePush(plan_num);
		if(res > 0) {
			result = "true";
		} else {
			result = "false";
		}
		return result;
	}
	
	@RequestMapping(value="dib_insert.do", method = RequestMethod.POST)
	@ResponseBody
	public String dib_insert(String user_id, int plan_num) {
		String result = "";
		
		//우선 해당 유저가, 해당 글을 찜한게 있는지 확인
		DibDto chk = new DibDto();
		chk.setTable_num(plan_num);
		chk.setUser_id(user_id);
		int dibChk = dBiz.dibChk(chk);
		
		if(dibChk > 0) {
			//찜 목록에 있다는 의미
			result = "already";
		} else {
			//찜 목록에 없다는 의미
			DibDto dib = new DibDto();
			int dib_num = dBiz.maxNum();
			dib.setDib_num(dib_num + 1);
			dib.setBoard_num(3);
			dib.setTable_num(plan_num);
			dib.setUser_id(user_id);
			
			int res = dBiz.insert(dib);
			
			if(res > 0) {
				result = "true";
			} else {
				result = "false";
			}
		}
		
		return result;
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
		String plan_term = req.getParameter("plan_term");
		
		//글 번호 따오기
		int plan_num = cusbiz.maxNum();
		plan_num = plan_num + 1;
		
		CustomDto plan = new CustomDto();
		plan.setPlan_num(plan_num);
		plan.setPlan_title(plan_title);
		plan.setPlan_content(plan_content);
		plan.setPlan_writer(plan_writer);
		plan.setPlan_tendency(plan_tendency);
		plan.setPlan_term(plan_term);

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
				date.setDate_num(datebiz.maxNum() + 1);
				date.setBoard_num(3);
				date.setTable_num(plan_num);
				date.setGroup_num(i+1);
				date.setDate_lat(Double.parseDouble(lst_lat[i]));
				date.setDate_lon(Double.parseDouble(lst_lon[i]));
				date.setDate_name(lst_title[i]);
				date.setDate_addr(lst_addr[i]);
				date.setDate_phone(lst_phone[i]);
				
				int lstRes = datebiz.insert(date);
				if(lstRes > 0) {
					mapRes++;
				}
			}
			
			if(mapRes > 0) {
				System.out.println("지도 관련 저장 완료");
			}
			
			//4. 이미지 관련 저장
			List<MultipartFile> imgList = new ArrayList<MultipartFile>();
			imgList.add(img_1);
			imgList.add(img_2);
			imgList.add(img_3);
			
			String path = req.getSession().getServletContext().getRealPath("/") + "/resources/plan";
			
			File store = new File(path);
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
			//경로에 이미지 저장
			for(MultipartFile mf : imgList) {
				String fileName = mf.getOriginalFilename();
				String safeFile = path + "/" + fileName;

				try {
	                mf.transferTo(new File(safeFile));
	                
	            } catch (IllegalStateException e) {
	                e.printStackTrace();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }

			}
	         
	         int resImg = 0;
	         
	         //이미지 파일명 테이블 저장
	         for(int i = 0; i < imgList.size(); i++) {
	        	 String name = imgList.get(i).getOriginalFilename();
	        	 
	        	 ImgDto img = new ImgDto();
	        	 img.setGroup_num(i+1);
	        	 img.setImg_title(name);
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
	@RequestMapping(value = "customplan_insertForm.do", method = RequestMethod.GET)
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
	
	//나만의 일정 삭제
	@RequestMapping(value="customplan_delete.do")
	public String customplan_delete(int plan_num,HttpServletResponse response) throws IOException {
		
		System.out.println("나만의 일정 삭제 시작");
		
		int hashRes = hashbiz.delete(plan_num);
		int dateRes = datebiz.delete(plan_num);
		int imgRes = imgBiz.delete(plan_num);
		int cusRes = cusbiz.delete(plan_num);
		
		System.out.println("나만의 일정 값 가져옴");
		if(hashRes>0 && dateRes>0 && imgRes>0 && cusRes>0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter(); 
			writer.println("<script>alert('글 삭제 완료');"
					+ "location.href='customplan_main.do';</script>"); 
			writer.close();
			return null;
			
		}else {
			return "redirect:customplan_detail.do?plan_num="+plan_num;
		}
	}
	
	@RequestMapping(value="customplan_updateform.do", method=RequestMethod.GET)
	public String customplan_updateform(Model model, int plan_num, HttpServletRequest req) throws ParseException {
		
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
		
		//나만의 일정 지도 부분 가져오기
		model.addAttribute("DateDto", datebiz.selectList(plan_num));
		
		//나만의 일정 해쉬태그 가져오기
		model.addAttribute("HashDto", hashbiz.selectOne(plan_num));
		
		return "page_customplan/customplan_update";
	}
	
	//나만의 일정 업데이트
	@RequestMapping(value="customplan_update.do", method = RequestMethod.POST)
	public void customplan_update(HttpServletRequest req,HttpServletResponse res) throws IOException {
		int result = 0;
		
		//글정보 업데이트
		CustomDto cusdto = new CustomDto();
		int plan_num = Integer.parseInt(req.getParameter("plan_num"));
		String plan_title = req.getParameter("plan_title");
		String plan_content = req.getParameter("plan_content");
		String plan_tendency = req.getParameter("tend_content");
		String plan_term = req.getParameter("plan_term");
		
		cusdto.setPlan_title(plan_title);
		cusdto.setPlan_content(plan_content);
		cusdto.setPlan_num(plan_num);
		cusdto.setPlan_tendency(plan_tendency);
		cusdto.setPlan_term(plan_term);
		
		int cusRes = cusbiz.cusUpdate(cusdto);
		
		if(cusRes > 0) {
			result++;
		}
		
		//해시태그 정보 업데이트
		int hash_num = Integer.parseInt(req.getParameter("hash_num"));
		String hash = req.getParameter("hash_content");
		HashtagDto hashDto = new HashtagDto();
		hashDto.setHash_num(hash_num);
		hashDto.setBoard_num(3);
		hashDto.setTable_num(plan_num);
		hashDto.setHash_content(hash);
		System.out.println("게시판 번호: " + hashDto.getBoard_num() + ", 게시물번호: " + hashDto.getTable_num() + ", 태그내용: " + hashDto.getHash_content());
		
		int Hashres = hashbiz.update(hashDto);
		
		if(Hashres > 0) {
			result++;
		}
		
		//코스정보 업데이트
		int dateCount = datebiz.count(plan_num);
		
		if(dateCount > 0) {
			int dateRes = datebiz.delete(plan_num);
			
			if(dateRes > 0) {
				//3. 지도 관련 저장
				String[] lst_title = req.getParameterValues("lst_title");
				String[] lst_addr =  req.getParameterValues("lst_addr");
				String[] lst_phone = req.getParameterValues("lst_phone");
				String[] lst_lat = req.getParameterValues("lst_lat");
				String[] lst_lon = req.getParameterValues("lst_lon");
				
				int mapRes = 0;
				
				for(int i = 0; i < lst_title.length; i++) {
					DateDto date = new DateDto();
					date.setDate_num(datebiz.maxNum() + 1);
					date.setBoard_num(3);
					date.setTable_num(plan_num);
					date.setGroup_num(i+1);
					date.setDate_lat(Double.parseDouble(lst_lat[i]));
					date.setDate_lon(Double.parseDouble(lst_lon[i]));
					date.setDate_name(lst_title[i]);
					date.setDate_addr(lst_addr[i]);
					date.setDate_phone(lst_phone[i]);
					
					int lstRes = datebiz.insert(date);
					
					if(lstRes > 0) {
						mapRes++;
					}
				}
				
				if(mapRes > 0) {
					System.out.println("지도 관련 저장 완료");
					result++;
				}
			}
		} else {
			//3. 지도 관련 저장
			String[] lst_title = req.getParameterValues("lst_title");
			String[] lst_addr =  req.getParameterValues("lst_addr");
			String[] lst_phone = req.getParameterValues("lst_phone");
			String[] lst_lat = req.getParameterValues("lst_lat");
			String[] lst_lon = req.getParameterValues("lst_lon");
			
			int mapRes = 0;
			
			for(int i = 0; i < lst_title.length; i++) {
				DateDto date = new DateDto();
				date.setDate_num(datebiz.maxNum() + 1);
				date.setBoard_num(3);
				date.setTable_num(plan_num);
				date.setGroup_num(i+1);
				date.setDate_lat(Double.parseDouble(lst_lat[i]));
				date.setDate_lon(Double.parseDouble(lst_lon[i]));
				date.setDate_name(lst_title[i]);
				date.setDate_addr(lst_addr[i]);
				date.setDate_phone(lst_phone[i]);
				
				int lstRes = datebiz.insert(date);
				
				if(lstRes > 0) {
					mapRes++;
				}
			}
			
			if(mapRes > 0) {
				System.out.println("지도 관련 저장 완료");
				result++;
			}
		}
		
		if(result == 3) {
			res.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script>alert('성공적으로 수정했습니다.');"
					+ "location.href='customplan_detail.do?plan_num=" + plan_num + "';</script>");
			writer.close();
		}
	}
	
	//신고하기
	@RequestMapping(value="reportInsert.do", method=RequestMethod.POST)
	@ResponseBody
	public String reportInsert(String user_id, int plan_num, HttpServletRequest req) {
		String result="";
		
		//해당유저가 해당글을 신고한게 있는지 확인
		ReportDto chk = new ReportDto();
		chk.setPlan_num(plan_num);
		chk.setUser_id(user_id);
		int repChk = repbiz.repChk(chk);
		
		if(repChk>0) {
			//신고된 목록이 있는것 확인
			result = "already";
		}else {
			String rep_user = req.getParameter("rep_user"); 
			String rep_reson =req.getParameter("report_reson");
			
			ReportDto dto = new ReportDto();
			int repNum = repbiz.maxNum();
			dto.setPlan_num(plan_num);
			dto.setRep_num(repNum + 1);
			dto.setRep_reson(rep_reson);
			dto.setRep_user(rep_user);
			dto.setUser_id(user_id);
			
			int res = repbiz.reportInsert(dto);
			
			if(res>0) {
				//신고 후 해당 게시물 비공개처리
				int hideRes = cusbiz.update_hide(plan_num);
				result = "true";
			}else {
				result = "false";
			}	
		}	
		return result;
	}
}