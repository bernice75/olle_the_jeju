package com.olle.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.olle.biz.member.MemberBiz;
import com.olle.dto.member.MemberDto;

@Controller
public class CustomplanController {
	
	private Logger logger = LoggerFactory.getLogger(CustomplanController.class);
	HttpSession session;
	MemberDto dto;
	
	@RequestMapping(value = "customplan_main.do", method = RequestMethod.GET)
	public String customplan_main() {
		return "page_customplan/customplan";
	}
	
	@RequestMapping(value = "customplan_detail.do", method = RequestMethod.GET)
	public String customplan_detail() {
		return "page_customplan/customplan_detail";
	}
	
	@RequestMapping(value = "customplan_insert.do", method = RequestMethod.GET)
	public String customplan_insert() {
		return "page_customplan/customplan_insert";
	}
	
}
