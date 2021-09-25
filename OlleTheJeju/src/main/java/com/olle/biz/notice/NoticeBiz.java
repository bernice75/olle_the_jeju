package com.olle.biz.notice;

import java.util.List;

import com.olle.dto.faq.FaqDto;

public interface NoticeBiz {
	public List<FaqDto> faqList();
	public int insert(FaqDto dto);
	public int update(FaqDto dto);
	public int delete(int faq_num);
}
