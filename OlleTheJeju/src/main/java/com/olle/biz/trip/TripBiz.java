package com.olle.biz.trip;

import java.util.List;
import java.util.Map;

public interface TripBiz {
	public Map<String, List> getJeju(String page);
	public Map<String, List> getSearch(String search);
}
