package com.olle.biz.etc;

import com.olle.dto.etc.DateDto;

public interface DateBiz {
	public int insert(DateDto dto);
	public int maxNum();
	public DateDto selectOne(int plan_num);
	public DateDto selectList(DateDto dto);
}
