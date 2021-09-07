package com.olle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	
	@RequestMapping(value = "admin_main.do", method = RequestMethod.GET)
	public String admin_main() {
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
