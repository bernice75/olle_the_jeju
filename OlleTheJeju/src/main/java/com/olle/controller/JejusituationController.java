package com.olle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JejusituationController {
	
	@RequestMapping(value = "jejusituation_main.do", method = RequestMethod.GET)
	public String jejusituation_main() {
		return "page_jejusituation/jejusituation";
	}
	
	@RequestMapping(value = "jejusituation_rest.do", method = RequestMethod.GET)
	public String jejusituation_detail() {
		return "page_jejusituation/jejusituation_rest";
	}
}
