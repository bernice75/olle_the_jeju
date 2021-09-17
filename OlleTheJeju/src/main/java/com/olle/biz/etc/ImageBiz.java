package com.olle.biz.etc;

import com.olle.dto.etc.ImgDto;

public interface ImageBiz {
	int selectMaxPK();
	int selectMaxGroupId(int boardNum);
	int saveStoreImg(ImgDto dto);
}
