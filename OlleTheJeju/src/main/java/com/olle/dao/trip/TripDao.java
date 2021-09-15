package com.olle.dao.trip;

import java.util.List;
import java.util.Map;

import org.w3c.dom.Element;

import com.olle.dto.trip.TripDto;

public interface TripDao {
	
	String NAMESPACE = "trip.";
	
	public Map<String, List> getJeju(String page);
	public Map<String, List> getSearch(String search);
	public String getTagValue(String sTag, Element eElement);
	public int insert(TripDto dto);
	public List<TripDto> selectList(String kategorie, int page);
	public TripDto selectOne(int trip_num);
	public int getAllCount(String kategorie);
	public int update(TripDto dto);
	public int delete(int trip_num);
	public void likeUpdate(int trip_num);
}
