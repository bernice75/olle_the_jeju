package com.olle.biz.jejusituation;

import java.util.List;

import org.w3c.dom.Element;

import com.olle.dto.jejusituation.CoronaDto;
import com.olle.dto.jejusituation.JejuDto;

public interface JejuBiz {
	static String coronaKey="XBgVgJ5lWfGZupLLI4wP0judrcdSx%2BSSoQS0NmIl%2Bm1EFIeJXfIaG5K4VWI2kGcI8rCegDtstBtgTmnHIE0Cog%3D%3D";
	
	List<CoronaDto> searchData();
	String getTagValue(String tagName, Element element);
	//맛집등록게시판 pk 최댓값 찾기
	int getMaxJejuDtoNum();
	int saveStore(JejuDto dto);	
	
	void setMaxPkFromSelectKey(int primaryKey);
	int getMaxPkFromSelectKey();
}