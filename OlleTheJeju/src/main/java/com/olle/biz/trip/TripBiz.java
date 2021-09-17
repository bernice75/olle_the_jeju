package com.olle.biz.trip;

import java.util.List;
import java.util.Map;

import com.olle.dto.suggest.SuggestDto;
import com.olle.dto.trip.TripDto;

public interface TripBiz {
	public Map<String, List> getJeju(String page);
	public Map<String, List> getSearch(String search);
	public int insert(TripDto dto);
	public List<TripDto> selectList(String kategorie, int page);
	public int getAllCount(String kategorie);
	public TripDto selectOne(int trip_num);
	public int update(TripDto dto);
	public int delete(int trip_num);
	public void likeUpdate(int trip_num);
	public int insertDibs(int sug_num,String user_id);
	public List<TripDto> DibList(List<TripDto> list,String user_id);
}
