package com.olle.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.olle.biz.mypage.MypageBiz;
import com.olle.biz.mypage.MypageBizImple;
import com.olle.dto.member.MemberDto;

@Controller
public class MypageController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MypageBiz biz;
	
	//회원정보 조회
	@RequestMapping(value = "mypage_main.do", method = RequestMethod.GET)
	public String mypage_main(HttpSession session, Model model, String user_id) {
		logger.info("mypage_main");
		user_id = "LSJTEST";
		model.addAttribute("dto", biz.mypageInfo(user_id));
		return "page_mypage/mypage";
	}
	
	//회원정보 수정
	/*@RequestMapping(value="info_update.do", method=RequestMethod.GET)
	public String mypage_update(HttpSession session, Model model, MemberDto userUpdate) {
		logger.info("info_update");
		
		int res = biz.mypageInfoUpdate(userUpdate);
		
		if(res>0) {
			return "redirect:mypage_plan.do";
		}else {
			return "redirect:mypage_main.do?user_id="+userUpdate.getUser_id();
		}
	}*/
	@RequestMapping(value="info_update.do", method=RequestMethod.GET)
	public String update(MemberDto dto){
		logger.info("updateUser");
		
		biz.mypageInfoUpdate(dto);
		System.out.println("회원정보 수정 성공");
		
		return "redirect:mypage_plan.do";
	}
	
	
	/* 다시 수정해야함
	 * //회원정보 수정 비밀번호 체크
	@RequestMapping(value="info_update.do", method=RequestMethod.GET)
	public String mypage_updateChk(@ModelAttribute MemberDto dto, Model model) {
		boolean result = biz.checkPw(dto.getUser_id(), dto.getUser_pw());
		
		if(result) {
			biz.mypageInfoUpdate(dto);
			//비밀번호 일치 하다면 수정 처리, 리턴으로 페이지 이동은 없는것으로
			return "";
		}else {
			MemberDto dto2 = biz.mypageInfo(dto.getUser_id());
			model.addAttribute("dto", dto);
			model.addAttribute("message", "비밀번호 불일치");
			//비밀번호 불일치시 메시지창 띄우고 페이지 이동 없음	
			return "";
		}
	}*/
	
	//회원 강제 탈퇴
	
	//회원 자진 탈퇴 (삭제)
	@RequestMapping(value="mypageDelete.do", method=RequestMethod.GET)
	public String mypageDelete(String user_id, String user_pw, MemberDto dto, HttpSession session, RedirectAttributes rttr) {
		logger.info("mypageDelete");
		//세션에 있는 member를 가져와 member 변수에 넣어준다
		MemberDto member = (MemberDto)session.getAttribute("member");
		
		//세션에 있는 비밀번호
		String sessionPass = member.getUser_pw();
		
		//dto로 들어오는 비밀번호
		String dtoPass = dto.getUser_pw();
		
		//세션에 있는 비밀번호와 비교
		if(!(sessionPass.equals(dtoPass))){
			rttr.addFlashAttribute("msg", false);
			return "redirect: home.do";
		}
		biz.mypageDelete(user_id, user_pw);
		session.invalidate();
		return "redirect: home.do";
	}
	
	//내가쓴 게시글 조회
	@RequestMapping(value = "mypage_plan.do", method = RequestMethod.GET)
	public String mypage_plan() {
		return "page_mypage/mypage_plan";
	}
	
	//내가 찜한 게시글 조회
	
	//문의하기 (채팅 기능)
	@RequestMapping(value = "mypage_inquire.do", method = RequestMethod.GET)
	public String mypage_inquire() {
		return "page_mypage/mypage_inquire";
	}
	
	//신고 확인 기능
	@RequestMapping(value = "mypage_warn.do", method = RequestMethod.GET)
	public String mypage_warn() {
		return "page_mypage/mypage_warn";
	}
}
