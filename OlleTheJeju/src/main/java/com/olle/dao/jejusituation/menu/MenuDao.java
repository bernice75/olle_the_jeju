package com.olle.dao.jejusituation.menu;

import java.util.List;

import com.olle.dto.jejusituation.MenuDto;

public interface MenuDao {
	static final String NAMESPACE="menu.";
		
	int maxMenuPerStore(int storeId);
	//store id별로 가져오기
	List<MenuDto> getMenuByStoreId(int storeId);
	//페이지에 할당될 수 있는 모든 메뉴 리스트 가져오기
	List<MenuDto> getPageMenuList(int startIdx,int page);
}