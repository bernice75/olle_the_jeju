package com.olle.biz.trip;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.trip.TripDaoImpl;
import com.olle.dto.trip.TripDto;

@Service
public class TripBiz {
	
	@Autowired
	private TripDaoImpl td;
	
	
	public Map<String, List> getJeju(String page) {
		Map<String, List> result = td.getJeju(page);
		
		return result;
	}

	
	public Map<String, List> getSearch(String search) {
		Map<String, List> result = td.getSearch(search);
		
		return result;
	}
	
	public int insert(TripDto dto) {
		int res = td.insert(dto);
		
		return res;
	}
	
	public List selectList(String kategorie) {
		
		List result = td.selectList(kategorie);
		
		return result;
	}
	

}
