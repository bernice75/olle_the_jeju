package com.olle.dao.etc;

import com.olle.dto.etc.HashtagDto;

public interface HashDao {
	
	String NAMESPACE = "hashtag.";
	
	public int insert(HashtagDto dto);
}
