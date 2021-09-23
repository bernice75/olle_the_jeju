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
	public List<CustomDto> selectList(String search, int page) {
		return dao.selectList(search, page);
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
	public int update(CustomDto dto) {
		return dao.update(dto);
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
	public int cusUpdate(int plan_num) {
		return dao.cusUpdate(plan_num);
	}
}
