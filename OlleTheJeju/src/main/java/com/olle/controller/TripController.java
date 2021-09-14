package com.olle.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.olle.biz.trip.TripBiz;
import com.olle.dto.trip.TripDto;

@Controller
public class TripController {
	
	private static final Logger logger = LoggerFactory.getLogger(TripController.class);
	
	@Autowired
	private TripBiz tb;
	
	
	@RequestMapping(value = "/trip_main.do", method = RequestMethod.GET)
	public String trip_main(Model model) {
		logger.info("TRIP_MAIN");
		String kategorie = "명소";
		
		List result = tb.selectList(kategorie);
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
		model.addAttribute("place", result);
		
		return "page_trip/trip_main";
	}
	
	@RequestMapping(value = "/trip_detail.do", method = RequestMethod.GET)
	public String trip_detail() {
		logger.info("TRIP_DETAIL");
		return "page_trip/trip_detail";
	}
	
	@RequestMapping(value = "/trip_insert.do", method = RequestMethod.GET)
	public String trip_insert() {
		logger.info("TRIP_INSERT");
		return "page_trip/trip_insert";
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
	
	@RequestMapping(value="/trip_insert_db.do", method = RequestMethod.GET)
	public String trip_insert_db(TripDto dto) {
		
		int res = tb.insert(dto);
		if(res>0) {
			return "redirect:trip_main.do";
		}else {
			return "redirect:trip_insert.do";
		}
		
	}
	
	
}
