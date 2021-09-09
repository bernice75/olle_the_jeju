package com.olle.biz.trip;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.trip.TripDao;

@Service
public class TripBiz {
	
	@Autowired
	private TripDao td;
	
	
	public Map<String, List> getJeju(String page) {
		Map<String, List> result = td.getJeju(page);
		
		return result;
	}

	
	public Map<String, List> getSearch(String search) {
		Map<String, List> result = td.getSearch(search);
		
		return result;
	}
	

}
