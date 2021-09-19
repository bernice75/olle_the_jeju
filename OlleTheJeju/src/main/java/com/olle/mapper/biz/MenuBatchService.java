package com.olle.mapper.biz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.olle.dto.jejusituation.menu.MenuDto;
import com.olle.mapper.MenuMapper;

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
