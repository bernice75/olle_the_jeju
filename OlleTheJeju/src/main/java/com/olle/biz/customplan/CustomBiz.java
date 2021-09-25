package com.olle.biz.customplan;

import java.util.List;

import com.olle.dto.customplan.CustomDto;

public interface CustomBiz {
	public List<Integer> topten();
	public CustomDto selectTopten(int plan_num);
	public List<CustomDto> selectList(String search, int page);
	public List<CustomDto> selectHide(String search, int page);
	public CustomDto selectOne(int plan_num);
	public int insert(CustomDto dto);
	public int updateView(int plan_num);
	public int updatePush(int plan_num);
	public int update_hide(int plan_num); //신고당한 후 복귀
	public int delete(int plan_num);
	public int maxNum();
	public int getAllCount(String search);
	public int countAllHide(String search);
	public int cusUpdate(CustomDto dto);
}
