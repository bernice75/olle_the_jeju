package com.olle.biz.etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olle.dao.etc.BookingDao;
import com.olle.dto.etc.BookingDto;

@Service
public class BookingBizImpl implements BookingBiz{

	@Autowired
	private BookingDao dao;
	
	@Override
	public int preCheckPeople(BookingDto dto) {
		// TODO Auto-generated method stub
		return dao.preCheckPeople(dto);
	}

	@Override
	public int reservation(BookingDto dto) {
		// TODO Auto-generated method stub
		return dao.reservation(dto);
	}
	


}
