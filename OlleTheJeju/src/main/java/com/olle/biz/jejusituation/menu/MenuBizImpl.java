package com.olle.biz.jejusituation.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.jejusituation.menu.MenuDao;
import com.olle.dto.jejusituation.menu.MenuDto;

@Service
public class MenuBizImpl implements MenuBiz{
	
	@Autowired
	private MenuDao dao;

	@Override
	public long maxMenuPerStore(int storeId) {
		// TODO Auto-generated method stub
		return dao.maxMenuPerStore(storeId);
	}

	@Override
	public int saveMenu(List<MenuDto> list) {
		// TODO Auto-generated method stub
		return 0;
	}

}
