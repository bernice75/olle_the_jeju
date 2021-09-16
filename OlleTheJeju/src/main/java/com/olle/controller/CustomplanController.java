package com.olle.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.olle.biz.member.MemberBiz;
import com.olle.dto.member.MemberDto;

@Controller
public class CustomplanController {
	
	private Logger logger = LoggerFactory.getLogger(CustomplanController.class);
	HttpSession session;
	MemberDto dto;
	
	@RequestMapping(value = "customplan_main.do", method = RequestMethod.GET)
	public String customplan_main() {
		return "page_customplan/customplan";
	}
	
	@RequestMapping(value = "customplan_detail.do", method = RequestMethod.GET)
	public String customplan_detail() {
		return "page_customplan/customplan_detail";
	}
	
	@RequestMapping(value = "customplan_insert.do", method = RequestMethod.GET)
	public String customplan_insert(Model model) throws ParseException {
		
		JSONParser trip_parser = new JSONParser();
		JSONArray trip = new JSONArray();
		
		try {
			Reader trip_reader = new FileReader("C:\\workspace\\Tmap_test\\src\\main\\resources\\json\\trip.json");
			JSONObject trip_obj = (JSONObject)trip_parser.parse(trip_reader);
			
			trip = (JSONArray)trip_obj.get("trip");
			
			model.addAttribute("trip", trip);
		} catch(IOException e) {
			e.printStackTrace();
		}
		//-----------------------------------------관광지 관련 데이터 끝
		
		//---------------------------------------------음식점 과련 데이터 시작
		JSONParser food_parser = new JSONParser();
		JSONArray food = new JSONArray();
		
		try {
			Reader food_reader = new FileReader("C:\\workspace\\Tmap_test\\src\\main\\resources\\json\\safe.json");
			JSONObject safe = (JSONObject)food_parser.parse(food_reader);
			
			food = (JSONArray)safe.get("safe");
			
			model.addAttribute("food", food);

		} catch(IOException e) {
			e.printStackTrace();
		}
		//---------------------------------------------음식점 과련 데이터 끝
		
		//---------------------------------------------숙박 관련 데이터 시작
		JSONParser hotel_parser = new JSONParser();
		JSONArray hotel = new JSONArray();
		
		try {
			Reader hotel_reader = new FileReader("C:\\workspace\\Tmap_test\\src\\main\\resources\\json\\hotel.json");
			JSONObject hotel_obj = (JSONObject) hotel_parser.parse(hotel_reader);
			
			hotel = (JSONArray)hotel_obj.get("hotel");
			
			model.addAttribute("hotel", hotel);

		} catch(IOException e) {
			e.printStackTrace();
		}
		//---------------------------------------------숙박 관련 데이터 끝
		
		return "page_customplan/customplan_insert";
	}
	
}
