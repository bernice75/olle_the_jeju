package com.olle.dao.trip;

import java.util.List;
import java.util.Map;

public interface TripDao {
	public Map<String, List> getJeju(String page);
	public Map<String, List> getSearch(String search);
}
