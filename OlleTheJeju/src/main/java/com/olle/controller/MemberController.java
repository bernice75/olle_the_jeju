package com.olle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olle.biz.member.MemberBiz;
import com.olle.dto.member.MemberDto;

import java.io.IOException;
import java.lang.reflect.Member;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberBiz memberBiz;
	
	/**
	 * @param dto
	 * @return
	 * 회원 정보를 저장한다.
	 */
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
