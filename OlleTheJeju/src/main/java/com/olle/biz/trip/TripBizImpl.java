package com.olle.biz.trip;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.trip.TripDao;
import com.olle.dto.trip.TripDto;

@Service
public class TripBizImpl implements TripBiz {
	@Autowired
	private TripDao td;
	
	@Override
	public Map<String, List> getJeju(String page) {
		Map<String, List> result = td.getJeju(page);
		
		return result;
	}

	@Override
	public Map<String, List> getSearch(String search) {
		Map<String, List> result = td.getSearch(search);
		
		return result;
	}
	
	@Override
	public int insert(TripDto dto) {
		int res = td.insert(dto);
		
		return res;
	}
	
	@Override
	public List<TripDto> selectList(String kategorie, int page) {
		
		List<TripDto> result = td.selectList(kategorie, page);
		
		return result;
	}
	
	@Override
	public int getAllCount(String kategorie) {
		return td.getAllCount(kategorie);
	}
	
	@Override
	public TripDto selectOne(int trip_num) {
		return td.selectOne(trip_num);
	}
	
	@Override
	public int update(TripDto dto) {
		return td.update(dto);
	}
	
	@Override
	public int delete(int trip_num) {
		return td.delete(trip_num);
	}
	
	@Override
	public void likeUpdate(int trip_num) {
		td.likeUpdate(trip_num);
	}
	
	@Override
	public int insertDibs(int trip_num, String user_id) {
		return td.insertDibs(trip_num, user_id);
	}
	
	@Override
	public List<TripDto> DibList(List<TripDto> list, String user_id) {
		return td.DibList(list, user_id);
	}
}
