package com.olle.dao.suggest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dto.etc.DibDto;
import com.olle.dto.etc.HashtagDto;
import com.olle.dto.etc.ReportDto;
import com.olle.dto.suggest.SuggestDto;

@Repository
public class SuggestDaoImpl implements SuggestDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<SuggestDto> selectList(String kate, int page) {
		List<SuggestDto> result = new ArrayList<SuggestDto>();
		int pageP = (page-1)*6;
		int pageN = page*6;
		System.out.println("pageP: "+pageP);
		System.out.println("pageN: "+pageN);
		Map map = new HashMap();
		map.put("pageP", pageP);
		map.put("pageN", pageN);
		String sql="";
		
		if(kate.equals("편안")) {
			map.put("name", "편안");
			sql="selectList";
			
		}else if(kate.equals("힐링")) {
			map.put("name", "힐링");
			sql="selectList";
			
		}else if(kate.equals("올레길")) {
			map.put("name", "올레길");
			sql="selectList";
			
		}else if(kate.equals("맛집")) {
			map.put("name", "맛집");
			sql="selectList";
			
		}else if(kate.equals("트레킹")) {
			map.put("name", "트레킹");
			sql="selectList";
		}else {
			sql="selectListAll";
			map.put("name","전체");
		}
		
		System.out.println("불러올 카테고리: "+map.get("name"));
		
		try {
			result = sqlSession.selectList(NAMESPACE+sql,map);
			if(kate.equals("전체")) {
				for(int i=0; i<result.size()-1; i++) {
				 	result.get(i).setSug_kategorie("전체");
				}
			}
			
		} catch (Exception e) {
			System.out.println("[ERROR : SELECT_SUGGEST_LIST]");
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	@Override
	public int getAllCount(String kategorie) {
		int cnt=0;
		String sql="";
		try {
			if(kategorie.equals("전체")) {
				sql="countAll";
			}else {
				sql="count";
			}
			cnt = sqlSession.selectOne(NAMESPACE+sql, kategorie);
		} catch (Exception e) {
			System.out.println("[ERROR : COUNT]");
			e.printStackTrace();
		}
		return cnt;
	}
	
	@Override
	public SuggestDto selectOne(int trip_num) {
		SuggestDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE+"selectOne",trip_num);
			sqlSession.update(NAMESPACE+"viewsUpdate",trip_num);
			
			
			
		} catch (Exception e) {
			System.out.println("[ERROR : SELECT_SUGGEST_ONE]");
			e.printStackTrace();
		}
		
		return dto;
	}
	
	@Override
	public int insert(SuggestDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE+"insert",dto);
		} catch (Exception e) {
			System.out.println("[ERROR : SUGGEST_INSERT]");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int update(SuggestDto dto) {
		int res=0;
		
		try {
			res = sqlSession.update(NAMESPACE+"update",dto);
		} catch (Exception e) {
			System.out.println("[ERROR: SUGGEST_UPDATE]");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int delete(int sug_num) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"delete",sug_num);
		} catch (Exception e) {
			System.out.println("[ERROR : SUGGEST_DELETE]");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public String DateFormat(Date date) {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		String nDate = sd.format(date);
		
		return nDate;
	}
	
	@Override
	public void likeUpdate(int sug_num) {
		int res = 0;
		try {
			res = sqlSession.update(NAMESPACE+"likeUpdate",sug_num);
		}catch(Exception e) {
			System.out.println("[ERROR : TRIP_LIKE]");
			e.printStackTrace();
		}
	}
	
	@Override
	public int insertDibs(int sug_num,String user_id) {
		int res=0;
		int result = 0;
		DibDto chk = chkDibs(user_id,sug_num);
		if(chk==null) {
			try {
				DibDto in = new DibDto();
				in.setBoard_num(2);
				in.setTable_num(sug_num);
				in.setUser_id(user_id);
				res = sqlSession.insert("dib.insert",in);
				if(res>0) {
					result=1; //추가 성공
				}else {
					result=2; //추가 실패
				}
			} catch (Exception e) {
				System.out.println("[ERROR : DIB_INSERT]");
				e.printStackTrace();
			}
		}else {
			try {
				res = sqlSession.delete("dib.delete",chk.getDib_num());
				if(res>0) {
					result=3;//삭제 성공
				}else {
					result=4;//삭제 실패
				}
				
			} catch (Exception e) {
				System.out.println("[ERROR : DIB_DELETE");
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public DibDto chkDibs(String id,  int tNum) {
		
		DibDto dd = new DibDto();
		dd.setUser_id(id);
		dd.setTable_num(tNum);
		dd.setBoard_num(2);
		
		DibDto result=null;
		try {
			result = sqlSession.selectOne("dib.selectOne", dd);
		} catch (Exception e) {
			System.out.println("[ERROR : DIB_SELECTONE]");
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<SuggestDto> DibList(List<SuggestDto> list,String user_id) {
		
		List<DibDto> dlist = new ArrayList<DibDto>();
		
		DibDto dd = new DibDto();
		dd.setUser_id(user_id); //세션에서 받아온 유저아이디
		dd.setBoard_num(2);
		
		try {
			dlist = sqlSession.selectList("dib.selectList", dd);
			for(int i=0; i<list.size(); i++) {
				int sNum = list.get(i).getSug_num();
				
				for(int j=0; j<dlist.size(); j++) {
					if(dlist.get(j).getTable_num()==sNum) { //찜리스트에 해당 게시글의 번호가 있을경우
						list.get(i).setDib(1);
						break;
					}else {
						list.get(i).setDib(0);
					}
				}
				
			}
		} catch (Exception e) {
			System.out.println("[ERROR : DIB_SELECTLIST");
			e.printStackTrace();
		}
		
		return list;
	}



	/*
	 * @Override public int insert_ht(HashtagDto hdt) { int res = 0;
	 * 
	 * try { res = sqlSession.insert("hashtag.insert",hdt); } catch (Exception e) {
	 * System.out.println("[ERROR : HASH_INSERT"); e.printStackTrace(); } return
	 * res; }
	 */
	
	
}
