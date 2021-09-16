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
import org.springframework.web.bind.annotation.ResponseBody;

import com.olle.biz.trip.TripBiz;
import com.olle.dto.trip.Paging;
import com.olle.dto.trip.TripDto;

@Controller
public class TripController {
	
	private static final Logger logger = LoggerFactory.getLogger(TripController.class);
	
	@Autowired
	private TripBiz tb;
	
	@RequestMapping(value = "/trip_main.do", method = RequestMethod.GET)
	public String trip_main(Model model, String kategorie, int page) {
		logger.info("TRIP_MAIN");
		System.out.println("page: "+page);
		
		if(kategorie==null||kategorie=="") {
			kategorie="명소";
		}
		System.out.println("카테고리: "+kategorie);
		Paging pg = new Paging();
		pg.setPage(page);
		pg.setBeginPage(page);
		pg.setTotalCount(tb.getAllCount(kategorie));
		
		List<TripDto> result = tb.selectList(kategorie,page);
		System.out.println("사이즈: "+result.size());
		model.addAttribute("paging",pg);
		model.addAttribute("dto", result);
		
		return "page_trip/trip_main";
	}
	
	@RequestMapping(value = "/trip_detail.do", method = RequestMethod.GET)
	public String trip_detail(Model model, int trip_num) {
		logger.info("TRIP_DETAIL");
		
		TripDto dto = tb.selectOne(trip_num);
		
		model.addAttribute("dto", dto);
		
		return "page_trip/trip_detail";
	}

	@RequestMapping(value = "/trip_insert.do", method = RequestMethod.GET)
	public String trip_insert() {
		logger.info("TRIP_INSERT");
		return "page_trip/trip_insert";
	}
	
	@RequestMapping(value="/trip_insert_db.do", method = RequestMethod.GET)
	public String trip_insert_db(TripDto dto) {
		
		int res = tb.insert(dto);
		if(res>0) {
			System.out.println("INSERT 성공");
			return "redirect:trip_main.do?&page=1";
		}else {
			System.out.println("INSERT 실패");
			return "redirect:trip_insert.do";
		}
		
	}
	
	@RequestMapping(value = "/trip_update.do", method = RequestMethod.GET)
	public String trip_update(Model model, int trip_num) {
		logger.info("TRIP_UPDATE");
		
		TripDto dto = tb.selectOne(trip_num);
		
		model.addAttribute("dto", dto);
		
		return "page_trip/trip_update";
	}
	
	
	@RequestMapping(value="/trip_update_db.do", method=RequestMethod.GET)
	public String trip_update_db(TripDto dto) {
		logger.info("TRIP_UPDATE_DB");
		System.out.println(dto);
		
		int res = tb.update(dto);
		
		if(res>0) {
			System.out.println("UPDATE 성공");
			return "redirect:trip_main.do?page=1";
			
		}else {
			System.out.println("UPDATE 실패");
			return "redirect:trip_update.do?trip_num="+dto.getTrip_num();
		}
	}
	
	@RequestMapping(value="/trip_update_like.do", method=RequestMethod.GET)
	@ResponseBody
	public Map trip_update_like(int trip_num) {
		tb.likeUpdate(trip_num);
		Map map = new HashMap();
		map.put("에러나서","넣는값");
		return map;
	}
	
	
	@RequestMapping(value="/trip_delete.do", method=RequestMethod.GET)
	public String trip_delete(int trip_num, String trip_kategorie) {
		logger.info("TRIP_DELETE");
		int res = tb.delete(trip_num);
		
		if(res>0) {
			System.out.println("DELETE 성공");
			return "redirect:trip_main.do?page=1";
		}else {
			System.out.println("DELTE 실패");
			return "redirect:trip_detail.do?trip_num="+trip_num;
		}
	}
	
	@RequestMapping(value = "/trip_jeju.do", method = RequestMethod.GET)
	public String trip_jeju(Model model) {
		logger.info("TRIP_JEJU : SELECT ALL");
		
		Map<String, List> result = tb.getJeju("1");
		
		model.addAttribute("page", "1");
		model.addAttribute("dia", result.get("dia"));
		model.addAttribute("kor", result.get("kor"));
		
		return "page_trip/trip_jeju";
	}
	
	@RequestMapping(value = "/trip_jeju_page.do")
	public String trip_jeju_page(Model model, String page) {
		logger.info("TRIP_JEJU : SELECT "+page+" PAGE");
		
		Map<String, List> result = tb.getJeju(page);
		
		model.addAttribute("page", page);
		model.addAttribute("dia", result.get("dia"));
		model.addAttribute("kor", result.get("kor"));
		
		return "page_trip/trip_jeju";
	}

	@RequestMapping(value="/trip_jeju_search.do")
	public String trip_jeju_search(Model model, String search) {
		logger.info("TRIP_JEJU : SEARCH "+search);
		
		Map<String, List> result = tb.getSearch(search);
		
		model.addAttribute("page","999");
		model.addAttribute("dia", result.get("dia"));
		model.addAttribute("kor", result.get("kor"));
		
		return "page_trip/trip_jeju";
	}
	
}
