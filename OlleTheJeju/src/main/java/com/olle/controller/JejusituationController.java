package com.olle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.olle.biz.jejusituation.JejuBiz;
import com.olle.dto.jejusituation.Criteria;
import com.olle.dto.jejusituation.PageingInfo;

@Controller
public class JejusituationController {
	@Autowired
	private JejuBiz biz;
	
	@RequestMapping(value = "jejusituation_main.do", method = RequestMethod.GET)
	public String jejusituation_main() {
		return "page_jejusituation/jejusituation";
	}
	
	@RequestMapping(value = "/jejusituation_rest.do", method = RequestMethod.GET)
	public String jejusituation_detail(@RequestParam(defaultValue="1") int page, Criteria cri, Model model) {
		cri.setPageNum(page);
		cri.setAmount(6);
		model.addAttribute("list", biz.selectList(cri));
		model.addAttribute("pageMaker", new PageingInfo(cri, biz.countTotal()));
		
		return "page_jejusituation/jejusituation_rest";
	}
	
	@RequestMapping(value="/jejusituation_rest_detail.do")
	public String jejusituation_rest_detail() {
		return "page_jejusituation/jejusituation_rest_detail";
	}
	@RequestMapping(value="/jejusituation_rest_detail2.do")
	public String jejusituation_rest_detail2() {
		return "page_jejusituation/jejusituation_rest_detail2";
	}
	@RequestMapping(value="/jejusituation_rest_create.do")
	public String jejusituation_rest_create() {
		return "page_jejusituation/jejusituation_rest_create";
	}
}
