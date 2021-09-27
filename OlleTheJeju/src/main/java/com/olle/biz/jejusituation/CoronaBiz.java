package com.olle.biz.jejusituation;

import java.util.HashMap;
import java.util.List;

import org.w3c.dom.Element;

public interface CoronaBiz {
	static String coronaKey="your open data api app key";
	void searchData();
	String getTagValue(String tagName, Element element);
	List<HashMap<String,String>> coronaList(HashMap<String,String> map);
}
