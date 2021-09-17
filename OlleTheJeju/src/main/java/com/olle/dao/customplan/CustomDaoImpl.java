package com.olle.dao.customplan;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dto.customplan.CustomDto;

@Repository
public class CustomDaoImpl implements CustomDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public List<CustomDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomDto selectOne(int plan_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(CustomDto dto) {
		
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE+"insert", dto);
		} catch (Exception e) {
			System.out.println("[error] : insert");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int update(CustomDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int plan_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int maxNum() {
		int res = sqlSession.selectOne(NAMESPACE + "maxNum");
		return res;
	}

	
}
