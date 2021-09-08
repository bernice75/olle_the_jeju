package com.olle.dao.customplan;

import java.util.List;

import com.olle.dto.customplan.CustomDto;

public interface CustomDao {
	
	String NAMESPACE = "customplan.";

	public List<CustomDto> selectList();
	public CustomDto selectOne(int plan_num);
	public int insert(CustomDto dto);
	public int update(CustomDto dto);
	public int delete(int plan_num);
}
