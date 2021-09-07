package com.olle.biz.trip;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.trip.TripDao;

@Service
public class TripBiz {
	
	@Autowired
	private TripDao td;
	
	
	public List getDialect() {
		List result = td.getDialect();
		
		return result;
	}
	
	public List getKor() {
		List result = td.getKor();
		
		return result;
	}
	
}
