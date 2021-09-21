package com.olle.biz.jejusituation.menu;

import java.util.List;

import com.olle.dto.jejusituation.MenuDto;

public interface MenuBiz {
	int maxMenuPerStore(int storeId);
	//store id 별로 메뉴 가져오기
	List<MenuDto> getMenuByStoreId(int storeId);
}