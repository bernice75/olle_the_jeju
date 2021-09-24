package com.olle.biz.etc;

import java.util.List;

import com.olle.dto.etc.DateDto;

public interface DateBiz {
	public int insert(DateDto dto);
	public int maxNum();
	public DateDto selectOne(int plan_num);
	public List<DateDto> selectList(int plan_num);
	public int delete(int plan_num);
	public int count(int plan_num);
}
