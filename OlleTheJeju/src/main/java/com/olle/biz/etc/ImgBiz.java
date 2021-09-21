package com.olle.biz.etc;

import java.util.List;

import com.olle.dto.etc.ImgDto;

public interface ImgBiz {
	int selectMaxPK();
	int selectMaxGroupId(int boardNum);
	int saveStoreImg(ImgDto dto);

	//제주상황-이미지 한개만 딱 pick
	List<ImgDto> getStoreImg(int startIdx, int endIdx);
	//구분에 따른 이미지 리스트 가져오기
	List<ImgDto> getStoreImgByGubun(String gubun,int startIdx,int endIdx);
	
	//나만의 일정
	public int cusInsert(ImgDto dto); // 이미지 저장
	public List<ImgDto> selectList(int board_num);
}
