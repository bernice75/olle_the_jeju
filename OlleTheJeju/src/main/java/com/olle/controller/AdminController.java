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
import org.springframework.web.bind.annotation.RequestParam;

import com.olle.biz.admin.ChatBiz;
import com.olle.biz.admin.ReportBiz;
import com.olle.biz.customplan.CustomBiz;
import com.olle.biz.member.MemberBiz;
import com.olle.dto.admin.ReportDto;
import com.olle.dto.customplan.CustomDto;
import com.olle.dto.etc.ChatMessage;
import com.olle.dto.member.MemberDto;
import com.olle.dto.pagination.Paging;

@Controller
public class AdminController {
	
	@Autowired
	private MemberBiz memberBiz;
	
	@Autowired
	private ReportBiz repBiz;
	
	@Autowired
	private CustomBiz cusBiz;
	
	@Autowired
	private ChatBiz chatBiz;
	
	@RequestMapping(value = "admin_main.do", method = RequestMethod.GET)
	public String admin_main(Model model) {
		List<MemberDto> user_list = new ArrayList<MemberDto>();
		user_list = memberBiz.userList();
		
		model.addAttribute("userList", user_list);
		
		return "page_admin/admin";
	}
	
	@RequestMapping(value = "admin_plan.do", method = RequestMethod.GET)
	public String admin_plan(Model model, String search, @RequestParam(value="page", defaultValue="1") int page) {
		if(search == null||search == "") {
			search = "전체";
		}
		//일반 게시물
		Paging pg = new Paging();
		pg.setPage(page);
		pg.setBeginPage(page);
      	pg.setTotalCount(cusBiz.getAllCount(search));
      	model.addAttribute("paging", pg);
      	
      	List<CustomDto> plan = cusBiz.selectList(search, page);
      	model.addAttribute("planList", plan);
      	
      	//신고된 게시물
      	Paging pg2 = new Paging();
      	pg2.setPage(page);
      	pg2.setBeginPage(page);
      	pg2.setTotalCount(cusBiz.countAllHide(search));
      	model.addAttribute("paging2", pg2);
      	
      	List<CustomDto> plan2 = cusBiz.selectHide(search, page);
      	model.addAttribute("planList2", plan2);
      	
		return "page_admin/admin_plan";
	}
	
	@RequestMapping(value = "admin_inquire.do", method = RequestMethod.GET)
	public String mypage_inquire(Model model) {
		//채팅 목록이 있는지 가져오기(조건은 from_user가 사용자일 것, 그리고 중복을 제외해야 함)
		//이렇게 하면 중복을 제외한 room_id 종류가 모두 가져와질 것임
		List<String> room_list = chatBiz.selectRoom();
		/* 잘 가져와지는 것이 확인되어 주석처리. 혹시 안 되면 다시 살려서 확인해볼 것
		System.out.println("존재하는 방개수 : " + room_list.size());
		for(int i = 0; i < room_list.size(); i++) {
			System.out.println(room_list.get(i));
		}
		*/
		model.addAttribute("room_id", room_list);
		
		//특정 room_id를 통해 해당 room의 가장 최신 메세지 가져오기
		List<ChatMessage> message_list = new ArrayList<ChatMessage>();
		
		for(int i = 0; i < room_list.size(); i++) {
			message_list.add(i, chatBiz.newMessage(room_list.get(i)));
		}
		
		model.addAttribute("message_content", message_list);
		/* 잘 가져와지는 것이 확인되어 주석처리. 혹시 안 되면 다시 살려서 확인해볼 것
		System.out.println("메세지들이 잘 담겼는가? : " + message_list.size());
		*/
		
		//특정 방에 대한 메세지 목록 가져오기
		List<List<ChatMessage>> dto_list = new ArrayList<List<ChatMessage>>();
		for(int i = 0; i < room_list.size(); i++) {
			List<ChatMessage> dto = new ArrayList<ChatMessage>();
			dto_list.add(i, chatBiz.selectList(room_list.get(i)));
		}
		model.addAttribute("message_list", dto_list);
		/*
		for(int i = 0; i < dto_list.size(); i++) {
			for(int j = 0; j < dto_list.get(i).size(); j++) {
				System.out.println(dto_list.get(i).get(j).getMessage_content());
			}
		}
		*/
		
		return "page_admin/admin_inquire";
	}
	
	@RequestMapping(value = "admin_warn.do", method = RequestMethod.GET)
	public String admin_warn(Model model) {
		List<ReportDto> rep = repBiz.selectList();
		model.addAttribute("report", rep);
		
		List<CustomDto> cusList = new ArrayList<CustomDto>();
		
		for(int i = 0; i < rep.size(); i++) {
			int plan_num = rep.get(i).getPlan_num();
			CustomDto cus = cusBiz.selectOne(plan_num);
			cusList.add(i, cus);
		}
		model.addAttribute("cusList", cusList);
		
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
