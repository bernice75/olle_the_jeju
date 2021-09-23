package com.olle.dao.jejusituation.menu;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dto.jejusituation.MenuDto;
import com.olle.dto.pagination.PaginationIdxes;

@Repository
public class MenuDaoImpl implements MenuDao {
	@Autowired
	private SqlSessionTemplate session;
	

	@Override
	public int maxMenuPerStore(int storeId) {
		int res=0;
		
		try {
			res=session.selectOne(NAMESPACE+"pkMax");
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
			list=session.selectList(NAMESPACE+"getMenuListByStoreId", storeId);
		}catch(Exception e) {
			list=null;
		}
		return list;
	}

	@Override
	public List<MenuDto> getPageMenuList(int startIdx, int page) {
		int endIdx=page*36;
		PaginationIdxes pg=new PaginationIdxes();
		pg.setStartIdx(startIdx);
		pg.setEndIdx(endIdx);
		List<MenuDto> list=session.selectList(NAMESPACE+"getPageMenuList",pg);
		return list;
	}
	
	@Override
	public List<MenuDto> getMenuListForOurStore(int situ_num) {
		List<MenuDto> list=session.selectList(NAMESPACE+"getMenuListForStore", situ_num);
		return list;
	}
}
