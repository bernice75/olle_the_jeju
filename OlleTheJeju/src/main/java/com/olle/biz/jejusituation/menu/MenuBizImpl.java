package com.olle.biz.jejusituation.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.jejusituation.menu.MenuDao;
import com.olle.dto.jejusituation.MenuDto;

@Service
public class menuBizImpl implements MenuBiz {
	@Autowired
	private MenuDao dao;
	
	@Override
	public int maxMenuPerStore(int storeId) {
		return dao.maxMenuPerStore(storeId);
	}
	
	@Override
	public List<MenuDto> getMenuByStoreId(int storeId) {
		return dao.getMenuByStoreId(storeId);
	}
}