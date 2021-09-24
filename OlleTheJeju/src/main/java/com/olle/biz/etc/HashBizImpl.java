package com.olle.biz.etc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.etc.HashDao;
import com.olle.dto.etc.HashtagDto;

@Service
public class HashBizImpl implements HashBiz {
	@Autowired
	private HashDao dao;

	@Override
	public int insert(HashtagDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int maxNum() {
		return dao.maxNum();
	}

	@Override
	public List<HashtagDto> selectList(int board_num) {
		return dao.selectList(board_num);
	}
	
	@Override
	public HashtagDto selectOne(int plan_num) {
		return dao.selectOne(plan_num);
	}
	
	@Override
	public int delete(int plan_num) {
		return dao.delete(plan_num);
	}

	@Override
	public int update(HashtagDto dto) {
		return dao.update(dto);
	}
}
