package com.olle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SuggestController {
	
	@RequestMapping(value = "suggest_main.do", method = RequestMethod.GET)
	public String suggest_main() {
		return "page_suggest/suggest_main";
	}
	
	@RequestMapping(value = "suggest_detail.do", method = RequestMethod.GET)
	public String suggest_detail() {
		return "page_suggest/suggest_detail";
	}
	
	@RequestMapping(value = "suggest_insert.do", method = RequestMethod.GET)
	public String suggest_insert() {
		return "page_suggest/suggest_insert";
	}
	
}
