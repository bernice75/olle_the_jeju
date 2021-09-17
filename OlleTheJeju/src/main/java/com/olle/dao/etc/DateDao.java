package com.olle.dao.etc;

import com.olle.dto.etc.DateDto;

public interface DateDao {
	String NAMESPACE = "date.";
	
	public int insert(DateDto dto);
}
