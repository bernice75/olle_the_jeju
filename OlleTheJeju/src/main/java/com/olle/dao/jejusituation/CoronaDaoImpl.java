package com.olle.dao.jejusituation;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dto.jejusituation.CoronaDto;

@Repository
public class CoronaDaoImpl implements CoronaDao{
	
	@Autowired
	private SqlSessionTemplate session;


	@Override
	public void searchData(List<CoronaDto> list) {
		// TODO Auto-generated method stub
		int merge=session.update(NAMESPACE+"merge",list);
		System.out.println("merge corona result: "+merge);
	}


	@Override
	public List<HashMap<String,String>> coronaList(HashMap<String,String> map) {
		// TODO Auto-generated method stub
		List<HashMap<String,String>> list=session.selectList(NAMESPACE+"coronaList",map);
		return list;
	}

}
