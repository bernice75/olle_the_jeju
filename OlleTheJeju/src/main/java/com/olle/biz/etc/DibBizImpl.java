package com.olle.biz.etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.etc.DibDao;

@Service
public class DibBizImpl implements DibBiz {
	@Autowired
	private DibDao dao;

	@Override
	public int countDib(int table_num) {
		return dao.countDib(table_num);
	}

}
