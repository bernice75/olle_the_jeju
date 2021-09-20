package com.olle.dao.etc;

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
}
