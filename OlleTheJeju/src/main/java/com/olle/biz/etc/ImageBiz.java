package com.olle.biz.etc;

import java.util.List;

import com.olle.dto.etc.ImgDto;

public interface ImageBiz {
	int selectMaxPK();
	int selectMaxGroupId(int boardNum);
	int saveStoreImg(ImgDto dto);
	
	//제주상황-이미지 한개만 딱 pick
	//ImgDto getStoreImg(int table_num);
	List<ImgDto> getStoreImg(int startIdx, int endIdx);
}
