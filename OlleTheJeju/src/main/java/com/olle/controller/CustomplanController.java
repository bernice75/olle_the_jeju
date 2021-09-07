package com.olle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomplanController {
	
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
