package com.olle.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	@RequestMapping(value="info_update.do", method=RequestMethod.GET)
	public String mypage_update(Model model, MemberDto userUpdate) {
		logger.info("info_update");
		
		int res = biz.mypageInfoUpdate(userUpdate);
		
		if(res>0) {
			return "redirect:mypage_plan.do?user_id="+userUpdate.getUser_id();
		}else {
			return "redirect:mypage_main.do?user_id="+userUpdate.getUser_id();
		}
	}
	
	//회원 강제 탈퇴
	
	//회원 자진 탈퇴 (삭제)
	
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
