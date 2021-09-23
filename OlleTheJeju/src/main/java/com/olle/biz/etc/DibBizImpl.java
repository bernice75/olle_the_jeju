package com.olle.biz.etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.etc.DibDao;
import com.olle.dto.etc.DibDto;

@Service
public class DibBizImpl implements DibBiz {
	@Autowired
	private DibDao dao;

	@Override
	public int countDib(int table_num) {
		return dao.countDib(table_num);
	}

	@Override
	public int insert(DibDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int maxNum() {
		return dao.maxNum();
	}

	@Override
	public int dibChk(DibDto dto) {
		return dao.dibChk(dto);
	}

}
