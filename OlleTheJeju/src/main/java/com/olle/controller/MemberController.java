package com.olle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olle.biz.member.MemberBiz;
import com.olle.dto.member.MemberDto;

import java.util.List;

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
	@RequestMapping(value="userInsert.do")
	@ResponseBody
	public String userInsert(MemberDto dto) {
		
		System.out.println("dto");
		System.out.println(dto);		
		
		memberBiz.userInsert(dto);	// 회원 정보를 저장한다.
		
		return "home.do";
	}
	
}
