package com.olle.dao.jejusituation.menu;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dto.jejusituation.menu.MenuDto;

@Repository
public class MenuDaoImpl implements MenuDao{

	@Autowired
	private static SqlSessionTemplate session;
	

	@Override
	public int maxMenuPerStore(int storeId) {
		// TODO Auto-generated method stub
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

//	@Override
//	public int saveMenu(HashMap<String,Object> map) {
//		// TODO Auto-generated method stub
//		int res=0;
//		
//		Iterator iterator=map.entrySet().iterator();
//		while(iterator.hasNext()) {
//			Map.Entry<String,Object> me=(Entry<String, Object>) iterator.next();
//			String key=me.getKey();
//			MenuDto value=(MenuDto) me.getValue();
//			System.out.print("value: "+value+", instanceof: ");
//			System.out.println(value instanceof MenuDto);
//			int result = session.insert(NAMESPACE+"insertMenu",value);
//			if(result > 0) {
//				res++;
//			}
//		}
//		return res;
//	}

	@Override
	public List<MenuDto> getMenuByStoreId(int storeId) {
		// TODO Auto-generated method stub
		List<MenuDto> list=new ArrayList<MenuDto>();
		try {
			list=session.selectList(NAMESPACE+"getMenuListByStoreId", storeId);
		}catch(Exception e) {
			list=null;
		}
		return list;
	}



}
