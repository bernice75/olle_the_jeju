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
	public List<CustomDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomDto selectOne(int plan_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(CustomDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(CustomDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int plan_num) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
