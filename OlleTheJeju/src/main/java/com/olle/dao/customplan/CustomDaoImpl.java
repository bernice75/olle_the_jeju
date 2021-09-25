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
	public List<Integer> topten() {
		return sqlSession.selectList(NAMESPACE + "topten");
	}
	
	@Override
	public CustomDto selectTopten(int plan_num) {
		return sqlSession.selectOne(NAMESPACE + "selectTopten", plan_num);
	}
	
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
	public List<CustomDto> selectHide(String search, int page) {
		List<CustomDto> list = new ArrayList<CustomDto>();
		
		int pageP = (page-1)*6;
		int pageN = page*6;
		
		Map map = new HashMap();
		map.put("pageP", pageP);
		map.put("pageN", pageN);
		
		if(search.equals("전체")) {
			list = sqlSession.selectList(NAMESPACE + "selectHide", map);
		} else {
			map.put("search", search);
			list = sqlSession.selectList(NAMESPACE + "selectHide", map);
		}
		System.out.println("목록 개수 : " + list.size());
		return list;
	}

	@Override
	public CustomDto selectOne(int plan_num) {
		return sqlSession.selectOne(NAMESPACE + "selectOne", plan_num);
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
	public int updateView(int plan_num) {
		return sqlSession.update(NAMESPACE + "viewsUpdate", plan_num);
	}
	
	@Override
	public int updatePush(int plan_num) {
		return sqlSession.update(NAMESPACE + "likeUpdate", plan_num);
	}

	@Override
	public int delete(int plan_num) {
		
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE + "delete",plan_num);
		} catch (Exception e) {
			System.out.println("[error] : 나만의 일정 plan 테이블 컬럼 삭제 실패");
			e.printStackTrace();
		}
		
		return res;
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
	
	@Override
	public int countAllHide(String search) {
		int cnt = 0;
		String sql = "";
		try {
			if(search.equals("전체")) {
				sql = "countAllHide";
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
	
	@Override
	public int cusUpdate(CustomDto dto) {

		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE + "cusUpdate", dto);
		} catch (Exception e) {
			System.out.println("[error] : 나만의 일정 글 수정 실패");
			e.printStackTrace();
		}
		
		return res;
	}
}
