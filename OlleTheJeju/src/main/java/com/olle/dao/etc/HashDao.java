package com.olle.dao.etc;

import java.util.List;

import com.olle.dto.etc.HashtagDto;

public interface HashDao {
	String NAMESPACE = "hashtag.";

	public int insert(HashtagDto dto);
	public int maxNum();
	public List<HashtagDto> selectList(int board_num);
	public HashtagDto selectOne(int plan_num);
}
