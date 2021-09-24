package com.olle.dao.admin;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dto.admin.ReportDto;

@Repository
public class ReportDaoImpl implements ReportDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ReportDto> selectList() {
		return sqlSession.selectList(NAMESPACE + "selectList");
	}

	@Override
	public int delete(int rep_num) {
		return sqlSession.delete(NAMESPACE + "delete", rep_num);
	}

	@Override
	public int reportInsert(ReportDto dto) {
		return sqlSession.insert(NAMESPACE + "insert", dto);
	}
	
	@Override
	public int maxNum() {
		return sqlSession.selectOne(NAMESPACE + "maxNum");
	}

	@Override
	public int repChk(ReportDto dto) {
		int rep_num = 0;
		if(sqlSession.selectOne(NAMESPACE + "repChk", dto) != null) {
			rep_num = sqlSession.selectOne(NAMESPACE + "repChk", dto);
		}
		return rep_num;
	}
	
}
