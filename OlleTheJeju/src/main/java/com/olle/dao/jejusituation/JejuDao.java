package com.olle.dao.jejusituation;

import java.util.List;

import com.olle.dto.jejusituation.JejuDto;

public interface JejuDao {
	
	String NAMESPACE = "jeju.";
	
	int getMaxJejuDtoNum();
	int saveStore(JejuDto dto);
	void setMaxPkFromSelectKey(int primaryKey);
	int getMaxPkFromSelectKey();
}