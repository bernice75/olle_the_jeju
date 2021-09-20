package com.olle.dao.jejusituation.menu;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dto.jejusituation.MenuDto;

@Repository
public class MenuDaoImpl implements MenuDao {
	@Autowired
	private static SqlSessionTemplate sqlSession;
	
	@Override
	public int maxMenuPerStore(int storeId) {
		int res=0;
		
		try {
			res=sqlSession.selectOne(NAMESPACE+"pkMax");
		}catch(NullPointerException e) {
			res=0;
		}finally {
			res++;
		}
		
		return res;
	}
	
	@Override
	public List<MenuDto> getMenuByStoreId(int storeId) {
		List<MenuDto> list=new ArrayList<MenuDto>();
		try {
			list=sqlSession.selectList(NAMESPACE+"getMenuListByStoreId", storeId);
		}catch(Exception e) {
			list=null;
		}
		return list;
	}
}