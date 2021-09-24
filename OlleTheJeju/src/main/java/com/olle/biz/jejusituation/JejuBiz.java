package com.olle.biz.jejusituation;

import org.w3c.dom.Element;

import com.olle.dto.jejusituation.JejuDto;

public interface JejuBiz {
	
	
	

	
	//맛집등록게시판 pk 최댓값 찾기
	int getMaxJejuDtoNum();
	int saveStore(JejuDto dto);
	void setMaxPkFromSelectKey(int primaryKey);
	int getMaxPkFromSelectKey();
	//기본키로 가게 정보 가져오기
	JejuDto getOurStoreInfo(int situ_num);
//	int saveStore(JejuDto dto, ImgDto img, HashMap<String,Object> map);
}
