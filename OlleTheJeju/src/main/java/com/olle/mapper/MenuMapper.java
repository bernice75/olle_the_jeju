package com.olle.mapper;

import java.util.List;

import com.olle.dto.jejusituation.MenuDto;

public interface MenuMapper {
	public int batchInsert(List<MenuDto> list) throws Exception;
}