package com.olle.dao.jejusituation;

import com.olle.dto.jejusituation.JejuDto;

public interface JejuDao {
	
	String NAMESPACE = "jeju.";
	
	int getMaxJejuDtoNum();
	int saveStore(JejuDto dto);
	void setMaxPkFromSelectKey(int primaryKey);
	int getMaxPkFromSelectKey();
	//pk값으로 가게 정보 가져오기
	//기본키로 가게 정보 가져오기
	JejuDto getOurStoreInfo(int situ_num);
}