package com.olle.biz.suggest;

import java.util.Date;
import java.util.List;

import com.olle.dto.etc.DibDto;
import com.olle.dto.suggest.SuggestDto;

public interface SuggestBiz {
	public List<SuggestDto> selectList(String kate, int page);
	public SuggestDto selectOne(int sug_num);
	public int insert(SuggestDto dt);
	public int update(SuggestDto dt);
	public int delete(int sug_num);
	public int getAllCount(String kate);
	public String DateFormat(Date date);
	public void likeUpdate(int trip_num);
	public int insertDibs(int sug_num, String user_id);
	public List<SuggestDto> DibList(List<SuggestDto> list, String user_id);
}
