package com.olle.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.olle.biz.admin.ReportBiz;
import com.olle.biz.customplan.CustomBiz;
import com.olle.biz.member.MemberBiz;
import com.olle.dto.admin.ReportDto;
import com.olle.dto.member.MemberDto;

@Controller
public class AdminController {
	
	@Autowired
	private MemberBiz memberBiz;
	
	@Autowired
	private ReportBiz repBiz;
	
	@Autowired
	private CustomBiz cusBiz;
	
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
	public String admin_warn(Model model) {
		List<ReportDto> rep = repBiz.selectList();
		model.addAttribute("report", rep);
		
		return "page_admin/admin_warn";
	}
	@RequestMapping(value = "rep_delete.do", method = RequestMethod.GET)
	public void rep_delete(int rep_num, int plan_num, HttpServletResponse res) throws IOException {
		int delete_res = repBiz.delete(rep_num);
		
		if(delete_res > 0) {
			cusBiz.update_hide(plan_num);
			
			res.setContentType("text/html; charset=UTF-8");
			PrintWriter out = res.getWriter();
			out.println("<script>alert('정상적으로 처리되었습니다.'); location.href='admin_warn.do';</script>");
			out.flush();
		} else {
			res.setContentType("text/html; charset=UTF-8");
			PrintWriter out = res.getWriter();
			out.println("<script>alert('처리에 실패했습니다.'); location.href='admin_warn.do';</script>");
			out.flush();
		}
	}
	
	@RequestMapping(value = "rep_warn.do", method = RequestMethod.GET)
	public void warn_update(String user_id, HttpServletResponse res) throws IOException {
		int update_res = memberBiz.warn_update(user_id);
		
		if(update_res > 0) {
			res.setContentType("text/html; charset=UTF-8");
			PrintWriter out = res.getWriter();
			out.println("<script>alert('해당 유저를 경고처리했습니다.'); location.href='admin_warn.do';</script>");
			out.flush();
		}
	}
	
	@RequestMapping(value = "adminboardpopup.do", method = RequestMethod.GET)
	public String adminboardpopup() {
		return "page_admin/adminboardpopup";
	}
}
