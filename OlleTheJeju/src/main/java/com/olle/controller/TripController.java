package com.olle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TripController {
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
	public String trip_jeju() {
		return "page_trip/trip_jeju";
	}
	
}
