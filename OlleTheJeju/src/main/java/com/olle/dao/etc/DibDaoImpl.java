package com.olle.dao.etc;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DibDaoImpl implements DibDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int countDib(int table_num) {
		return sqlSession.selectOne(NAMESPACE + "countDib", table_num);
	}

}
