package com.olle.dao.notice;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dto.faq.FaqDto;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int insert(FaqDto dto) {
		int res = 0;
		
		res = sqlSession.insert(NAMESPACE + "insert", dto);
		
		return res;
	}

	@Override
	public List<FaqDto> faqList() {
		List<FaqDto> list = new ArrayList<FaqDto>();
		
		list = sqlSession.selectList(NAMESPACE + "faqList");
		
		return list;
	}

	@Override
	public int update(FaqDto dto) {
		return sqlSession.update(NAMESPACE + "update", dto);
	}

	@Override
	public int delete(int faq_num) {
		return sqlSession.delete(NAMESPACE + "delete", faq_num);
	}

}