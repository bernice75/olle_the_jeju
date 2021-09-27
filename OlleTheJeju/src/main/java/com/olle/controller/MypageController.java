package com.olle.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.olle.biz.admin.ChatBiz;
import com.olle.biz.customplan.CustomBiz;
import com.olle.biz.etc.DateBiz;
import com.olle.biz.etc.HashBiz;
import com.olle.biz.etc.ImgBiz;
import com.olle.biz.mypage.MypageBiz;
import com.olle.dto.customplan.CustomDto;
import com.olle.dto.etc.ChatMessage;
import com.olle.dto.etc.HashtagDto;
import com.olle.dto.etc.ImgDto;
import com.olle.dto.member.MemberDto;
import com.olle.dto.pagination.Paging;

@Controller
public class MypageController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	HttpSession session;
	
	@Autowired
	private MypageBiz biz;
	
	@Autowired
	private CustomBiz cusbiz;

	@Autowired
	private ImgBiz imgBiz;
	
	@Autowired
	private ChatBiz chatBiz;
	
	//회원정보 조회 - 작업완료 
	@RequestMapping(value = "mypage_main.do", method = RequestMethod.GET)
	public String mypage_main(Model model, String user_id) {
		logger.info("mypage_main");
		
		model.addAttribute("dto", biz.mypageInfo(user_id));
		return "page_mypage/mypage";
	}
	
	//회원정보 수정 - 작업완료
	@RequestMapping(value="userUpdate.do", method=RequestMethod.POST)
	@ResponseBody
	public int userUpdate(HttpSession session, MemberDto dto) { 
		logger.info("userUpdate");
		
		int res = 0;
		dto.setUser_id((String)session.getAttribute("user_id"));
		
		try {
			res = biz.userUpdate(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	//회원정보 수정 (프로필 이미지 등록 및 변경) - 작업완료
	@RequestMapping(value="profileUpdate.do", method=RequestMethod.POST)
	public void profileUpdate(HttpServletRequest req
							  , @RequestParam("mypage_form") String user_id
							  , @RequestParam("poster") MultipartFile profileimg
							  , HttpServletResponse response) throws IOException {
		
		logger.info("profileimg");
		
		//4. 이미지 관련 저장
		String path = req.getSession().getServletContext().getRealPath("/") + "/resources/mypage";
		
		//db에 저장할 이름
		String fileName = profileimg.getOriginalFilename();
		String safeFile = path + "/" + fileName;
		
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
		
		try {
			profileimg.transferTo(new File(safeFile));
            
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		int resImg = 0;
		    
        //MemberDto 파일명 테이블 저장
		MemberDto dto = new MemberDto();
	  	dto.setUser_img(fileName);
	  	dto.setUser_id(user_id);
	  	biz.profileUpdate(dto);
	  	resImg++;
       
        if(resImg == 1) {
			System.out.println("프로필 이미지 저장 완료");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter pw = response.getWriter();
			pw.println("<script>alert('프로필 이미지가 등록되었습니다.'); location.href='mypage_main.do?user_id="+user_id+"';</script>");
			pw.flush();
        } else {
			System.out.println("프로필 이미지 저장에 실패했습니다.");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter pw = response.getWriter();
			pw.println("<script>alert('프로필 이미지 등록을 실패했습니다.'); location.href='history.back()';</script>");
			pw.flush();
        }
	
	}
	
	//회원 강제 탈퇴 - 보류중 / 작업해야함
	@RequestMapping(value="", method= RequestMethod.POST)
	public int mypageLeave(String user_id, int user_warning, Model model) {
		logger.info("myapgeLeave");
	 
		int res = 0;
	 
		return 0; 
	}
	
	//회원 자진 탈퇴 (삭제) - 작업완료 
	@RequestMapping(value="deleteUser.do", method= RequestMethod.POST)
	@ResponseBody
	public int deleteUser(String user_id, String user_pw, Model model, HttpServletResponse resp) throws IOException {
		logger.info("deleteUser");
		int res = 0;
		//비밀번호 체크
		boolean result = biz.checkPw(user_id, user_pw);
		
		//비밀번호가 맞으면 리턴
		if(result) {
			res = biz.deleteUser(user_id, user_pw);
		}
		return res;
	}
	
	//내가쓴 게시글 조회 - 작업완료
	@RequestMapping(value = "mypage_plan.do", method = RequestMethod.GET)
	public String myWriteList(Model model, String plan_writer, @RequestParam(value="page", defaultValue="1") int page) {
		System.out.println("search : " + plan_writer);
		if(plan_writer == null||plan_writer == "") {
			plan_writer = "전체";
		}
		
		Paging pg = new Paging();
		pg.setPage(page);
		pg.setBeginPage(page);
      	pg.setTotalCount(cusbiz.getAllCount(plan_writer));
      	
      	model.addAttribute("paging", pg);
      	
      	//------------------페이지 관련 --------------------------
		
		//글받아오기
		List<CustomDto> plan = biz.myWriteList(plan_writer, page);
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
		//해시태그 조회
				CustomDto dto = new CustomDto();
				int plan_num = 0;
				List<HashtagDto> hash = new ArrayList<HashtagDto>();
				for(int i = 0; i < plan.size(); i++) {
					dto.setPlan_num(plan.get(i).getPlan_num());
					plan_num = dto.getPlan_num();
					hash.add(i, biz.hashList(plan_num));
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
		
		return "page_mypage/mypage_plan";
	}
		
	
	//문의하기 (채팅 기능)
	@RequestMapping(value = "mypage_inquire.do", method = RequestMethod.GET)
	public String mypage_inquire(@RequestParam("user_id") String user_id, Model model) {
		
		//해당 유저에 대한 메세지 목록 가져오기
		List<ChatMessage> dto_list = chatBiz.selectList(user_id);
		if(dto_list.size() > 0) {
			model.addAttribute("message_list", dto_list);
		} else {
			model.addAttribute("message_list", null);
		}
		
		return "page_mypage/mypage_inquire";
	}
	
	//신고 확인 기능 - 수정해야함
	@RequestMapping(value = "mypage_warn.do", method = RequestMethod.GET)
	public String mypage_warn(String user_id, Model model) {
		logger.info("mypage_main");

		model.addAttribute("dto", biz.mypageWarn(user_id));
		
		return "page_mypage/mypage_warn";
	}
}
