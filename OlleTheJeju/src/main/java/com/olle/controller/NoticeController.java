package com.olle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olle.biz.notice.NoticeBiz;
import com.olle.dto.faq.FaqDto;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeBiz biz;
	
	@RequestMapping(value = "notice_main.do", method = RequestMethod.GET)
	public String notice(Model model) {
		List<FaqDto> list = biz.faqList();
		
		if(list.size() > 0) {
			model.addAttribute("faqList", list);
		} else {
			model.addAttribute("faqList", null);
		}
		
		return "page_notice/notice";
	}
	
	@RequestMapping(value = "notice_insertForm.do", method = RequestMethod.GET)
	public String notice_insertForm() {
		return "page_notice/notice_insert";
	}
	
	@RequestMapping(value = "notice_insert.do", method = RequestMethod.POST)
	@ResponseBody
	public int notice_insert(int faq_kat, String faq_title, String faq_content) {
		FaqDto dto = new FaqDto();
		dto.setFaq_kat(faq_kat);
		dto.setFaq_title(faq_title);
		dto.setFaq_content(faq_content);
		
		int res = biz.insert(dto);
		return res;
	}
	
	@RequestMapping(value = "notice_update.do", method = RequestMethod.POST)
	@ResponseBody
	public String notice_update(HttpServletRequest req) {
		String result = "";
		int faq_num = Integer.parseInt(req.getParameter("faq_num"));
		String faq_title = req.getParameter("faq_title");
		String faq_content = req.getParameter("faq_content");
		
		FaqDto dto = new FaqDto();
		dto.setFaq_num(faq_num);
		dto.setFaq_title(faq_title);
		dto.setFaq_content(faq_content);
		
		int res = biz.update(dto);
		
		if(res > 0) {
			result="true";
		} else {
			result="false";
		}
		
		return result;
	}
	
	@RequestMapping(value = "notice_delete.do", method = RequestMethod.POST)
	@ResponseBody
	public String notice_delete(int faq_num) {
		String result = "";
		
		int res = biz.delete(faq_num);
		
		if(res > 0) {
			result="true";
		} else {
			result="false";
		}
		
		return result;
	}
}