package com.olle.dao.customplan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dto.customplan.CustomDto;

@Repository
public class CustomDaoImpl implements CustomDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public List<CustomDto> selectList(String search, int page) {
		List<CustomDto> list = new ArrayList<CustomDto>();
		
		int pageP = (page-1)*6;
		int pageN = page*6;
		
		Map map = new HashMap();
		map.put("pageP", pageP);
		map.put("pageN", pageN);
		
		if(search.equals("전체")) {
			list = sqlSession.selectList(NAMESPACE + "selectAll", map);
		} else {
			map.put("search", search);
			list = sqlSession.selectList(NAMESPACE + "selectList", map);
		}
		System.out.println("목록 개수 : " + list.size());
		return list;
	}

	@Override
	public CustomDto selectOne(int plan_num) {
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
		return 0;
	}

	@Override
	public int delete(int plan_num) {
		return 0;
	}

	@Override
	public int maxNum() {
		return (Integer) (sqlSession.selectOne(NAMESPACE + "maxNum") == null ? 0:sqlSession.selectOne(NAMESPACE + "maxNum"));
	}

	@Override
	public int update_hide(int plan_num) {
		return sqlSession.update(NAMESPACE + "update_hide", plan_num);
	}
	
	@Override
	public int getAllCount(String search) {
		int cnt = 0;
		String sql = "";
		try {
			if(search.equals("전체")) {
				sql = "countAll";
			} else {
				sql = "count";
			}
			
			cnt = sqlSession.selectOne(NAMESPACE + sql, search);
		}catch (Exception e) {
			System.out.println("[ERROR : COUNT]");
	        e.printStackTrace();
		}
		
		return cnt;
	}
}
