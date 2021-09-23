package com.olle.biz.etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.etc.BookingDao;
import com.olle.dto.etc.BookingDto;

@Service
public class BookingBizImpl implements BookingBiz {
	@Autowired
	private BookingDao dao;
	
	@Override
	public int preCheckPeople(BookingDto dto) {
		return dao.preCheckPeople(dto);
	}

	@Override
	public int reservation(BookingDto dto) {
		return dao.reservation(dto);
	}
}
