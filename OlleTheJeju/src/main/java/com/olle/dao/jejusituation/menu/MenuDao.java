package com.olle.dao.jejusituation.menu;

import java.util.List;

import com.olle.dto.jejusituation.MenuDto;

public interface MenuDao {
static final String NAMESPACE="menu.";
	
	int maxMenuPerStore(int storeId);
	//int saveMenu(List<MenuDto> list);
	//store id별로 가져오기
	List<MenuDto> getMenuByStoreId(int storeId);
}
