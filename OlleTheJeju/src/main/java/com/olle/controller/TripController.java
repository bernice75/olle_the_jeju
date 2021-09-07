package com.olle.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.olle.biz.trip.TripBiz;

@Controller
public class TripController {
	
	private static final Logger logger = LoggerFactory.getLogger(TripController.class);
	
	@Autowired
	private TripBiz tb;
	
	
	@RequestMapping(value = "trip_main.do", method = RequestMethod.GET)
	public String trip_main() {
		return "page_trip/trip_main";
	}
	
	@RequestMapping(value = "trip_detail.do", method = RequestMethod.GET)
	public String trip_detail() {
		return "page_trip/trip_detail";
	}
	
	@RequestMapping(value = "trip_insert.do", method = RequestMethod.GET)
	public String trip_insert() {
		return "page_trip/trip_insert";
	}
	
	@RequestMapping(value = "trip_jeju.do", method = RequestMethod.GET)
	public String trip_jeju(Model model) {
		logger.info("TRIP_JEJU : SELECT ALL");
		
		List dia = tb.getDialect();
		List kor = tb.getKor();
		
		model.addAttribute("dia", dia);
		model.addAttribute("kor", kor);
		
		return "page_trip/trip_jeju";
	}
	
	
}
