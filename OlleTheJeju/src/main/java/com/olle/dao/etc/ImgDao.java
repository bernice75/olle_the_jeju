package com.olle.dao.etc;

import java.util.List;

import com.olle.dto.etc.ImgDto;

public interface ImgDao {
	String NAMESPACE = "img.";

	public List<ImgDto> selectList();
	public ImgDto selectOne(int img_num);
	public int insert(ImgDto dto);
	public int update(ImgDto dto);
	public int delete(int img_num);
}
