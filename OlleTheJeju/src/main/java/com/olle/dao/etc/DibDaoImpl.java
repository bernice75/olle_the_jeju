package com.olle.dao.etc;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dto.etc.DibDto;

@Repository
public class DibDaoImpl implements DibDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int countDib(int table_num) {
		return sqlSession.selectOne(NAMESPACE + "countDib", table_num);
	}

	@Override
	public int insert(DibDto dto) {
		return sqlSession.insert(NAMESPACE + "insert", dto);
	}

	@Override
	public int maxNum() {
		return sqlSession.selectOne(NAMESPACE + "maxNum");
	}

	@Override
	public int dibChk(DibDto dto) {
		int dib_num = 0;
		if(sqlSession.selectOne(NAMESPACE + "dibChk", dto) != null) {
			dib_num = sqlSession.selectOne(NAMESPACE + "dibChk", dto);
		}
		return dib_num;
	}

}
