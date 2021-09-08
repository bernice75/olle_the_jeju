package com.olle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	@RequestMapping(value = "member_list.do", method = RequestMethod.GET)
	public String member_list() {
		return "page_/";
	}
	
}
