package com.olle.biz.etc;

import java.util.List;

import com.olle.dto.etc.ImgDto;

public interface ImgBiz {
	int selectMaxPK();
	int selectMaxGroupId(int boardNum);
	int saveStoreImg(ImgDto dto);

	//제주상황-이미지 한개만 딱 pick
	//ImgDto getStoreImg(int table_num);
	List<ImgDto> getStoreImg(int startIdx, int endIdx);
	
	//나만의 일정
	public int cusInsert(ImgDto dto); // 이미지 저장
	public List<ImgDto> selectList(int board_num);
	public ImgDto selectOne(int img_num); //나만의 일정 디테일 페이지 이미지 불러오기
}
