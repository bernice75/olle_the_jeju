package com.olle.biz.jejusituation;

import java.util.List;

import org.w3c.dom.Element;

import com.olle.dto.jejusituation.CoronaDto;

public interface JejuBiz {
	static String coronaKey="XBgVgJ5lWfGZupLLI4wP0judrcdSx%2BSSoQS0NmIl%2Bm1EFIeJXfIaG5K4VWI2kGcI8rCegDtstBtgTmnHIE0Cog%3D%3D";
	
     List<CoronaDto> searchData();
	
	String getTagValue(String tagName, Element element);
}
