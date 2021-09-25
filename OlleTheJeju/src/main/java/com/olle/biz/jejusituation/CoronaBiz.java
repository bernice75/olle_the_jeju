package com.olle.biz.jejusituation;

import java.util.HashMap;
import java.util.List;

import org.w3c.dom.Element;

public interface CoronaBiz {
	static String coronaKey="XBgVgJ5lWfGZupLLI4wP0judrcdSx%2BSSoQS0NmIl%2Bm1EFIeJXfIaG5K4VWI2kGcI8rCegDtstBtgTmnHIE0Cog%3D%3D";
	void searchData();
	String getTagValue(String tagName, Element element);
	List<HashMap<String,String>> coronaList(HashMap<String,String> map);
}
