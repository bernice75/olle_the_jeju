package com.olle.dao.jejusituation;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dto.jejusituation.JejuDto;

@Repository
public class JejuDaoImpl implements JejuDao {
	
	public static int primaryKey;
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int getMaxJejuDtoNum() {
		int maxPk=0;
		maxPk=sqlSession.selectOne(NAMESPACE+"olleSituStoreMaxPk");
		return maxPk;
	}

	@Override
	public int saveStore(JejuDto dto) {
		int res=0;
		try {
			sqlSession.insert(NAMESPACE+"insertSit",dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.setMaxPkFromSelectKey(dto.getSitu_num());
			res=this.getMaxPkFromSelectKey();
		}
		return res;
	}

	@Override
	public int getMaxPkFromSelectKey() {
		return this.primaryKey;
	}

	@Override
	public void setMaxPkFromSelectKey(int primaryKey) {
		this.primaryKey=primaryKey;
	}

}