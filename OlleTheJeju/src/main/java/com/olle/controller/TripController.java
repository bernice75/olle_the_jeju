package com.olle.controller;

import java.util.ArrayList;
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

import com.olle.biz.etc.ImgBiz;
import com.olle.biz.trip.TripBiz;
import com.olle.dto.customplan.CustomDto;
import com.olle.dto.etc.ImgDto;
import com.olle.dto.pagination.Paging;
import com.olle.dto.trip.TripDto;

@Controller
public class TripController {
	
	private static final Logger logger = LoggerFactory.getLogger(TripController.class);
	
	@Autowired
	private TripBiz tb;
	@Autowired ImgBiz imgBiz;
	
	@RequestMapping(value = "/trip_main.do", method = RequestMethod.GET)
	public String trip_main(Model model, String kategorie,@RequestParam(value="page",defaultValue = "1")int page, String user_id) {
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
		
		List<TripDto> result = null;
		
		if(user_id==null||user_id=="") {
			System.out.println("USER_ID 없음");
			result = tb.selectList(kategorie, page);
		}else{
			System.out.println("USER_ID: "+user_id);
			result = tb.DibList(tb.selectList(kategorie,page), user_id);
		}
		
		model.addAttribute("paging",pg);
		model.addAttribute("dto", result);
		
		//이미지 정보
		List<ImgDto> img = imgBiz.selectList(1);
		List<ImgDto> nameList = new ArrayList<ImgDto>();
		for(ImgDto idx : img) {
			for(TripDto tidx : result) {
				if(tidx.getTrip_num() == idx.getTable_num()) {
					if(idx.getGroup_num() == 3) {
						nameList.add(idx);
					}
				}
			}
		}
		System.out.println("게시물과 매칭된 이미지 개수 : " + nameList.size());
		
		model.addAttribute("imgList", nameList);
		
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
	
	@RequestMapping(value="trip_dibs.do", method=RequestMethod.POST)
	@ResponseBody
	public int suggest_dibs(String trip_num, String user_id){
		logger.info("TRIP_DIBS");
		int num = Integer.parseInt(trip_num);
		int res = tb.insertDibs(num, user_id);
		System.out.println(res);
		return res;
	}
	
	
}