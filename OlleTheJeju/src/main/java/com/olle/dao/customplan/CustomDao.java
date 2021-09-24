package com.olle.dao.customplan;

import java.util.List;

import com.olle.dto.customplan.CustomDto;

public interface CustomDao {
	
	String NAMESPACE = "customplan.";

	public List<CustomDto> selectList(String search, int page);
	public CustomDto selectOne(int plan_num);
	public int insert(CustomDto dto);
	public int updateView(int plan_num);
	public int updatePush(int plan_num);
	public int update_hide(int plan_num);
	public int delete(int plan_num);
	public int maxNum();
	public int getAllCount(String search);
	public int cusUpdate(CustomDto dto);
}
