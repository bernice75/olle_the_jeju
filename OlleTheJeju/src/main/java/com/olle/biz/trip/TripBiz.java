package com.olle.biz.trip;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.trip.TripDaoImpl;
import com.olle.dao.trip.Paging;
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
	
	public List<TripDto> selectList(String kategorie, int page) {
		
		List<TripDto> result = td.selectList(kategorie, page);
		
		return result;
	}
	
	public int getAllCount(String kategorie) {
		return td.getAllCount(kategorie);
	}
	
	public TripDto selectOne(int trip_num) {
		return td.selectOne(trip_num);
	}
	
	public int update(TripDto dto) {
		return td.update(dto);
	}
	
	public int delete(int trip_num) {
		return td.delete(trip_num);
	}
	
	public void likeUpdate(int trip_num) {
		td.likeUpdate(trip_num);
	}
}
