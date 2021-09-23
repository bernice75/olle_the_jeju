package com.olle.biz.etc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.etc.DateDao;
import com.olle.dto.etc.DateDto;

@Service
public class DateBizImpl implements DateBiz {
	@Autowired
	private DateDao dao;

	@Override
	public int insert(DateDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int maxNum() {
		return dao.maxNum();
	}

	//나만의 일정 디테일 지도 값 받아오기
	@Override
	public DateDto selectOne(int plan_num) {
		return dao.selectOne(plan_num);
	}

	@Override
	public List<DateDto> selectList(int plan_num) {
		return dao.selectList(plan_num);
	}

	@Override
	public int delete(int plan_num) {
		return dao.delete(plan_num);
	}


}
