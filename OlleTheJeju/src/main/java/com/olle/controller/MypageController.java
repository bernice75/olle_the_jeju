package com.olle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MypageController {
	//회원정보 조회
	@RequestMapping(value = "mypage_main.do", method = RequestMethod.GET)
	public String mypage_main() {
		return "page_mypage/mypage";
	}
	
	//회원정보 수정
	
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
