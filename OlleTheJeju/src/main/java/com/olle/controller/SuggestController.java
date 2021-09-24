package com.olle.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
import com.olle.dto.pagination.Paging;
import com.olle.dto.suggest.SuggestDto;

@Controller
public class SuggestController {
	
	private static final Logger logger = LoggerFactory.getLogger(SuggestController.class);
	
	@Autowired
	private SuggestBiz sb;
	
	@RequestMapping(value = "suggest_main.do", method = RequestMethod.GET)
	public String suggest_main(Model model, @RequestParam(value="kategorie", defaultValue="전체")String kategorie, @RequestParam(value="page",defaultValue = "1")int page, String user_id) {
		logger.info("SUGGEST_MAIN");
		System.out.println("page: "+page);
		
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
	
	@RequestMapping(value = "suggest_main_search.do", method = RequestMethod.GET)
	public String suggest_main(Model model, @RequestParam(value="page",defaultValue = "1")int page, String user_id, String search) {
		logger.info("SUGGEST_MAIN");
		System.out.println("page: "+page);
		
		Paging pg = new Paging();
		pg.setPage(page);
		pg.setBeginPage(page);
		pg.setTotalCount(sb.getAllCount_s(search));
		
		List<SuggestDto> res = null;
		if(user_id==null||user_id=="") {
			System.out.println("ID값이 없습니다");
			res = sb.selectList_s(search, page);
		}else {
			System.out.println("USER_ID : "+user_id);
			res = sb.DibList(sb.selectList_s(search, page), user_id);
		}
		model.addAttribute("paging", pg);
		model.addAttribute("dto", res);
		
		return "page_suggest/suggest_main";
	}
	
	@RequestMapping(value = "suggest_detail.do", method = RequestMethod.GET)
	public String suggest_detail(Model model, int sug_num, HttpServletResponse response) throws org.json.simple.parser.ParseException {
		logger.info("SUGGEST_DETAIL");
		
		SuggestDto dto = sb.selectOne(sug_num);
		String nDate = sb.DateFormat(dto.getSug_regdate());

		model.addAttribute("regdate", nDate);
		model.addAttribute("dto", dto);
		return "page_suggest/suggest_detail";
	}
	
	@RequestMapping(value="suggest_detail_ajax.do", method=RequestMethod.GET)
	public void detail_ajax(int sug_num, HttpServletResponse response) throws IOException, ParseException {
		logger.info("SUGGEST_AJAX");
		
		SuggestDto dto = sb.selectOne(sug_num);
		String test = dto.getSug_addr();
		String[] astr= null;
		String[] daylist = null;
		astr = test.split("일수");
		JSONParser parser = new JSONParser();
	    JSONArray tarr = new JSONArray(); 
	  
		for(int i=0; i<astr.length; i++ ) {
			System.out.println(i+"일차: "+astr[i]);
			JSONObject total = new JSONObject();
			String day = astr[i];
			daylist = day.split("자르기");
			JSONArray jarr = new JSONArray();
			
			for(int j=0; j<daylist.length; j++) {
				System.out.println(j+"번째"+daylist[j]);
				JSONObject json = (JSONObject)parser.parse(daylist[j]);
				jarr.add(json);
			}
			
			total.put("day", jarr );
			System.out.println(total);
			tarr.add(total);
		}
				
		System.out.println(tarr);
		response.getWriter().print(tarr);
	}
	
	@RequestMapping(value = "suggest_insert.do", method = RequestMethod.GET)
	public String suggest_insert(Model model, HttpServletRequest req) {
		logger.info("SUGGEST_INSERT");
		
		return "page_suggest/suggest_insert";
	}
	
	@RequestMapping(value="suggest_insert_db.do", method=RequestMethod.GET)
	public String suggest_insert_db(SuggestDto dto, String[] sug_addr_arr) {
		logger.info("SUGGEST_INSERT_DB");
		String sug_addr="";
		
		for(int i=0; i<sug_addr_arr.length; i++) {
			sug_addr += sug_addr_arr[i];
		}
		
		dto.setSug_addr(sug_addr);
		
		System.out.println("주소: "+dto.getSug_addr());
		
		int res = sb.insert(dto);
		
		if(res>0){
			return "redirect:suggest_main.do?kategorie=전체&page=1";
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
	public String suggest_udpate_db(SuggestDto dto,String[] sug_addr_arr) {
		logger.info("SUGGEST_UPDATE_DB");
		String sug_addr="";
		
		for(int i=0; i<sug_addr_arr.length; i++) {
			sug_addr += sug_addr_arr[i];
		}
		
		dto.setSug_addr(sug_addr);
		System.out.println(dto);
		int res = sb.update(dto);
		
		if(res>0) {
			return "redirect:suggest_main.do?kategorie="+dto.getSug_kategorie()+"&page=1";
		}else {
			return "redirect:suggest_update.do?sug_num="+dto.getSug_num();
		}
		
	}
	
	@RequestMapping(value="/suggest_update_like.do", method=RequestMethod.GET)
	@ResponseBody
	public Map suggest_update_like(int sug_num) {
		sb.likeUpdate(sug_num);
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