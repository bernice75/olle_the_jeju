package com.olle.biz.trip;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.trip.TripDao;

@Service
public class TripBiz {
	
	@Autowired
	private TripDao td;
	
	
	public List getDialect(String page) {
		List result = td.getDialect(page);
		
		return result;
	}
	
	public List getKor(String page) {
		List result = td.getKor(page);
		
		return result;
	}
	
	public List getSearch(String search) {
		List result = td.getSearch(search);
		
		return result;
	}
}
