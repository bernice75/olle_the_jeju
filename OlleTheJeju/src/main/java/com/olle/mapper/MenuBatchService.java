package com.olle.mapper;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.olle.dto.jejusituation.menu.MenuDto;

@Service
public class MenuBatchService {

	@Resource(name="sqlSessionTemplate")
	private SqlSession session;
	
	public static int primaryKey;
	
	public int batchInsert(List<MenuDto> list) {
		//mapper interface 객체 반환
		MenuMapper mapper=session.getMapper(MenuMapper.class);
		int res=0;
		
		try {
			res=mapper.batchInsert(list);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
}
