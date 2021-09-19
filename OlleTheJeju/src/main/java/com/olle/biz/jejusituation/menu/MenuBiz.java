package com.olle.biz.jejusituation.menu;

import java.util.List;

import com.olle.dto.jejusituation.menu.MenuDto;

public interface MenuBiz {
	int maxMenuPerStore(int storeId);
	//int saveMenu(HashMap<String,Object> map);
	//store id 별로 메뉴 가져오기
	List<MenuDto> getMenuByStoreId(int storeId);
	//int saveMenu(List<MenuDto> list);
}
