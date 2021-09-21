package com.olle.dao.jejusituation;

import com.olle.dto.jejusituation.JejuDto;

public interface JejuDao {
	
	static final String NAMESPACE="jeju.";
	
	
	int getMaxJejuDtoNum();
	int saveStore(JejuDto dto);
	void setMaxPkFromSelectKey(int primaryKey);
	int getMaxPkFromSelectKey();

//	int saveStore(JejuDto dto, ImgDto img, HashMap<String,Object> map);
}
