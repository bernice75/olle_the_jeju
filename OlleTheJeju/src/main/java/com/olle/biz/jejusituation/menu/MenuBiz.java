package com.olle.biz.jejusituation.menu;

import java.util.List;

import com.olle.dto.jejusituation.menu.MenuDto;

public interface MenuBiz {
	long maxMenuPerStore(int storeId);
	int saveMenu(List<MenuDto> list);
}
