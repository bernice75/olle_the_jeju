package com.olle.dao.jejusituation;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dto.jejusituation.Criteria;
import com.olle.dto.jejusituation.JejuDto;

@Repository
public class JejuDaoImpl implements JejuDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<JejuDto> selectList(Criteria cri) {
		return sqlSession.selectList(NAMESPACE + "selectList", cri);
	}

	@Override
	public int countTotal() {
		return sqlSession.selectOne(NAMESPACE + "countTotal");
	}

}
