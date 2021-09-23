package com.olle.dao.etc;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.olle.dto.etc.BookingDto;

@Repository
public class BookingDaoImpl implements BookingDao{

	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int preCheckPeople(BookingDto dto) {
		// TODO Auto-generated method stub
		int res=session.selectOne(NAMESPACE+"limit",dto);
		System.out.println("res: "+res);
		return res;
	}

	@Transactional
	@Override
	public int reservation(BookingDto dto) {
		// TODO Auto-generated method stub
		int r1=preCheckPeople(dto);
		System.out.println("BookingDao check people before reservation: "+r1);
		int res=0;
		
		if(r1<30) {
			res=session.insert(NAMESPACE+"insert",dto);
		}
		
		return res;
	}

}
