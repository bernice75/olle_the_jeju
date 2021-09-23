package com.olle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.olle.dto.jejusituation.MenuDto;


@Mapper
public interface MenuMapper {
	public int batchInsert(List<MenuDto> list) throws Exception;
}
