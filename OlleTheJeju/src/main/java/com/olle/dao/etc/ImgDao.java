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
	//이미지 최대 PK값 가져오기
	int selectMaxPK();
	
	//group num 최댓값 가져오기
	int selectMaxGroupId(int boardNum);
	
	int saveStoreImg(ImgDto dto);
}
