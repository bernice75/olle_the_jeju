package com.olle.biz.etc;

import com.olle.dto.etc.BookingDto;

public interface BookingBiz {
	//가게의 해당 일자, 해당 시간대의 인원수 체크
	int preCheckPeople(BookingDto dto);
	//인원수 체크 결과에 따른 insert
	int reservation(BookingDto dto);

}
