package com.olle.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.olle.biz.member.MemberBiz;
import com.olle.dto.member.MemberDto;

@Controller
public class AdminController {
	
	@Autowired
	private MemberBiz memberBiz;
	
	@RequestMapping(value = "admin_main.do", method = RequestMethod.GET)
	public String admin_main(Model model) {
		List<MemberDto> user_list = new ArrayList<MemberDto>();
		user_list = memberBiz.userList();
		
		model.addAttribute("userList", user_list);
		
		return "page_admin/admin";
	}
	
	@RequestMapping(value = "admin_plan.do", method = RequestMethod.GET)
	public String admin_plan() {
		return "page_admin/admin_plan";
	}
	
	@RequestMapping(value = "admin_inquire.do", method = RequestMethod.GET)
	public String mypage_inquire() {
		return "page_admin/admin_inquire";
	}
	
	@RequestMapping(value = "admin_warn.do", method = RequestMethod.GET)
	public String mypage_warn() {
		return "page_admin/admin_warn";
	}
	
	@RequestMapping(value = "adminboardpopup.do", method = RequestMethod.GET)
	public String adminboardpopup() {
		return "page_admin/adminboardpopup";
	}
}
