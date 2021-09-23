package com.olle.biz.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.notice.NoticeDao;
import com.olle.dto.faq.FaqDto;

@Service
public class NoticeBizImpl implements NoticeBiz {

	@Autowired
	private NoticeDao dao;

	@Override
	public int insert(FaqDto dto) {
		return dao.insert(dto);
	}

	@Override
	public List<FaqDto> faqList() {
		return dao.faqList();
	}

}
