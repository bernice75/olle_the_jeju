package com.olle.biz.customplan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.customplan.CustomDao;
import com.olle.dto.customplan.CustomDto;

@Service
public class CustomBizImpl implements CustomBiz{

	@Autowired
	private CustomDao dao;
	
	@Override
	public List<Integer> topten() {
		return dao.topten();
	}
	
	@Override
	public CustomDto selectTopten(int plan_num) {
		return dao.selectTopten(plan_num);
	}
	
	@Override
	public List<CustomDto> selectList(String search, int page) {
		return dao.selectList(search, page);
	}
	
	@Override
	public List<CustomDto> selectHide(String search, int page) {
		return dao.selectHide(search, page);
	}

	@Override
	public CustomDto selectOne(int plan_num) {
		return dao.selectOne(plan_num);
	}

	@Override
	public int insert(CustomDto dto) {
		return dao.insert(dto);
	}
	
	@Override
	public int updateView(int plan_num) {
		return dao.updateView(plan_num);
	}
	
	@Override
	public int updatePush(int plan_num) {
		return dao.updatePush(plan_num);
	}

	@Override
	public int delete(int plan_num) {
		return dao.delete(plan_num);
	}
	
	@Override
	public int maxNum() {
		return dao.maxNum();
	}

	@Override
	public int update_hide(int plan_num) {
		return dao.update_hide(plan_num);
	}
	
	@Override
	public int getAllCount(String search) {
		return dao.getAllCount(search);
	}
	
	@Override
	public int countAllHide(String search) {
		return dao.countAllHide(search);
	}
	
	@Override
	public int cusUpdate(CustomDto dto) {
		return dao.cusUpdate(dto);
	}
}
