package com.olle.biz.jejusituation.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.jejusituation.menu.MenuDao;
import com.olle.dto.jejusituation.MenuDto;

@Service
public class MenuBizImpl implements MenuBiz{
	
	@Autowired
	private MenuDao dao;

	@Override
	public int maxMenuPerStore(int storeId) {
		// TODO Auto-generated method stub
		return dao.maxMenuPerStore(storeId);
	}
//
//	@Override
//	public int saveMenu(HashMap<String,Object> map) {
//		// TODO Auto-generated method stub
//		return dao.saveMenu(map);
//	}

	@Override
	public List<MenuDto> getMenuByStoreId(int storeId) {
		// TODO Auto-generated method stub
		return dao.getMenuByStoreId(storeId);
	}

	@Override
	public List<MenuDto> getPageMenuList(int startIdx, int page) {
		// TODO Auto-generated method stub
		return dao.getPageMenuList(startIdx, page);
	}

	@Override
	public List<MenuDto> getMenuListForOurStore(int situ_num) {
		// TODO Auto-generated method stub
		return dao.getMenuListForOurStore(situ_num);
	}



}
