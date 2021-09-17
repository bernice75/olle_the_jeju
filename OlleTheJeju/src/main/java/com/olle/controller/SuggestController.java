package com.olle.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olle.biz.suggest.SuggestBiz;
import com.olle.dto.suggest.SuggestDto;
import com.olle.dto.trip.Paging;

@Controller
public class SuggestController {
	
	private static final Logger logger = LoggerFactory.getLogger(SuggestController.class);
	
	@Autowired
	private SuggestBiz sb;
	
	@RequestMapping(value = "suggest_main.do", method = RequestMethod.GET)
	public String suggest_main(Model model, @RequestParam("kategorie")String kategorie, int page, String user_id) {
		logger.info("SUGGEST_MAIN");
		System.out.println("page: "+page);
		
		if(kategorie==null||kategorie=="") {
			kategorie="전체";
		}
		
		Paging pg = new Paging();
		pg.setPage(page);
		pg.setBeginPage(page);
		pg.setTotalCount(sb.getAllCount(kategorie));
		List<SuggestDto> res = null;
		if(user_id==null||user_id=="") {
			System.out.println("ID값이 없습니다");
			res = sb.selectList(kategorie, page);
		}else {
			System.out.println("USER_ID : "+user_id);
			res = sb.DibList(sb.selectList(kategorie, page), user_id);
		}
		model.addAttribute("paging", pg);
		model.addAttribute("dto", res);
		
		return "page_suggest/suggest_main";
	}
	
	@RequestMapping(value = "suggest_detail.do", method = RequestMethod.GET)
	public String suggest_detail(Model model, int sug_num) {
		logger.info("SUGGEST_DETAIL");
		
		SuggestDto dto = sb.selectOne(sug_num);
		String nDate = sb.DateFormat(dto.getSug_regdate());
		model.addAttribute("regdate", nDate);
		model.addAttribute("dto", dto);
		return "page_suggest/suggest_detail";
	}
	
	@RequestMapping(value = "suggest_insert.do", method = RequestMethod.GET)
	public String suggest_insert() {
		logger.info("SUGGEST_INSERT");
		
		return "page_suggest/suggest_insert";
	}
	
	@RequestMapping(value="suggest_insert_db.do", method=RequestMethod.GET)
	public String suggest_insert_db(SuggestDto dto) {
		logger.info("SUGGEST_INSERT_DB");
		
		int res = sb.insert(dto);
		
		if(res>0){
			return "redirect:suggest_main.do?kategorie="+dto.getSug_kategorie()+"&page=1";
		}else {
			return "redirect:suggest_insert.do";
		}
		
	}
	
	@RequestMapping(value="suggest_update.do", method=RequestMethod.GET)
	public String suggest_update(Model model,int sug_num) {
		logger.info("SUGGEST_UPDATE");
		
		SuggestDto dto = sb.selectOne(sug_num);
		
		model.addAttribute("dto", dto);
		
		return "page_suggest/suggest_update";
	}
	
	@RequestMapping(value="suggest_update_db.do", method=RequestMethod.GET)
	public String suggest_udpate_db(SuggestDto dto) {
		logger.info("SUGGEST_UPDATE_DB");
		
		int res = sb.update(dto);
		if(res>0) {
			return "redirect:suggest_main.do?kategorie="+dto.getSug_kategorie()+"&page=1";
		}else {
			return "redirect:suggest_update.do?sug_num="+dto.getSug_num();
		}
		
	}
	
	@RequestMapping(value="/suggest_update_like.do", method=RequestMethod.GET)
	@ResponseBody
	public Map trip_update_like(int trip_num) {
		sb.likeUpdate(trip_num);
		Map map = new HashMap();
		map.put("에러나서","넣는값");
		return map;
	}
	
	@RequestMapping(value="suggest_delete.do", method=RequestMethod.GET)
	public String suggest_delete(int sug_num) {
		logger.info("SUGGEST_DELETE");
		
		int res = sb.delete(sug_num);
		if(res>0) {
			return "redirect:suggest_main.do?kategorie=전체&page=1";
		}else {
			return "redirect:suggest_detail.do?sug_num="+sug_num;
		}
		
		
	}
	
	@RequestMapping(value="suggest_dibs.do", method=RequestMethod.POST)
	@ResponseBody
	public int suggest_dibs(String sug_num, String user_id){
		logger.info("SUGGEST_DIBS");
		int num = Integer.parseInt(sug_num);
		int res = sb.insertDibs(num, user_id);
		System.out.println(res);
		return res;
	}
	
	
	
	
	
	
	
	
}



















