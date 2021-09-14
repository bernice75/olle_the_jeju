package com.olle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olle.biz.member.MemberBiz;
import com.olle.dto.member.MemberDto;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

	@Autowired
	private MemberBiz memberBiz;
	
	//회원가입
	@RequestMapping(value="userInsert.do", method=RequestMethod.POST)
	@ResponseBody
	public String userInsert(String user_id, String user_pw, String user_name, int user_age, String user_addr,
			String user_addrdetail, String user_phone, String user_email, String user_member, String user_nick) {
		
		MemberDto dto = new MemberDto();
		dto.setUser_id(user_id);
		dto.setUser_pw(user_pw);
		dto.setUser_name(user_name);
		dto.setUser_age(user_age);
		dto.setUser_addr(user_addr);
		dto.setUser_addrdetail(user_addrdetail);
		dto.setUser_phone(user_phone);
		dto.setUser_email(user_email);
		dto.setUser_member(user_member);
		dto.setUser_nick(user_nick);
		
		memberBiz.userInsert(dto);	// 회원 정보를 저장
		
		return "loginForm.do";
	}
	
	//로그인
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	@ResponseBody
	public String login(String user_id, String user_pw, HttpServletRequest request) throws IOException {
		String res = memberBiz.login(user_id, user_pw);
		HttpSession session = request.getSession();

		if(res == null || res == "") {
			session.setAttribute("loginChk", false);
		} else {
			session.setAttribute("loginChk", true);
	        session.setAttribute("user_id", user_id);
		}
		
		return res;
	}
	
	//로그아웃
	@RequestMapping(value = "logout.do", method = RequestMethod.POST)
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:home.do";
	}
	
	//아이디 중복체크
	@RequestMapping(value="idChk.do", method=RequestMethod.POST)
	@ResponseBody
	public int idChk(String user_id) {
		int res = 0;
		
		res = memberBiz.idChk(user_id);
		
		if(res > 0) {
			System.out.println("controller - 존재");
		} else {
			System.out.println("controller - 미존재");
		}
		
		return res;
	}
	
	//닉네임 중복체크
	@RequestMapping(value="nickChk.do", method=RequestMethod.POST)
	@ResponseBody
	public int nickChk(String user_nick) {
		int res = 0;
		res = memberBiz.nickChk(user_nick);
		
		if(res > 0) {
			System.out.println("controller - 존재");
		} else {
			System.out.println("controller - 미존재");
		}
		
		return res;
	}
}
