package com.olle.dao.etc;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dto.etc.DateDto;

@Repository
public class DateDaoImpl implements DateDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int insert(DateDto dto) {
		int res = sqlSession.insert(NAMESPACE + "insert", dto);

		if(res > 0) {
		} else {
			System.out.println("date insert error");
		}

		return res;
	}

	@Override
	public int maxNum() {
		return (Integer) (sqlSession.selectOne(NAMESPACE + "maxNum") == null ? 0:sqlSession.selectOne(NAMESPACE + "maxNum"));
	}
	
	@Override
	public DateDto selectOne(int plan_num) {
		return null;
	}
	
	//나만의 일정 디테일 지도 값 가져오기
	@Override
	public List<DateDto> selectList(int plan_num) {
		
		List<DateDto> dto = new ArrayList<DateDto>();
		
		try {
			dto = sqlSession.selectList(NAMESPACE + "selectList",plan_num);
		} catch (Exception e) {
			System.out.println("[error] : 나만의 일정 디테일 date 가져오기 실패");
			e.printStackTrace();
		}
		
		return dto;
	}
	
	@Override
	public int delete(int plan_num) {

		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE + "delete",plan_num);
		} catch (Exception e) {
			System.out.println("[error] : 나만의 일정 지도관련 삭제 실패");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int count(int plan_num) {
		return sqlSession.selectOne(NAMESPACE + "count", plan_num);
	}
}
