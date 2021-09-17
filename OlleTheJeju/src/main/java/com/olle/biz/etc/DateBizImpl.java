package com.olle.biz.etc;

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

}
