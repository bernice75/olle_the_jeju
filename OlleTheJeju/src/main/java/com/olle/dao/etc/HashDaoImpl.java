package com.olle.dao.etc;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dto.etc.HashtagDto;

@Repository
public class HashDaoImpl implements HashDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int insert(HashtagDto dto) {
		int res = sqlSession.insert(NAMESPACE + "insert", dto);

		if(res > 0) {

		} else {
			System.out.println("hash insert error");
		}
		return res;
	}

	@Override
	public int maxNum() {
		return (Integer) (sqlSession.selectOne(NAMESPACE + "maxNum") == null ? 0:sqlSession.selectOne(NAMESPACE + "maxNum"));
	}

	@Override
	public List<HashtagDto> selectList(int board_num) {
		return sqlSession.selectList(NAMESPACE + "selectList", board_num);
	}
	
	@Override
	public HashtagDto selectOne(int plan_num) {
		
		HashtagDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "selectOne",plan_num);
		} catch (Exception e) {
			System.out.println("[error] : 나만의 일정 detail 해시태그 불러오기 실패");
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
			System.out.println("[error] : 나만의 일정 해시태그 삭제 실패");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int update(HashtagDto dto) {
		return sqlSession.update(NAMESPACE + "update", dto);
	}
}
