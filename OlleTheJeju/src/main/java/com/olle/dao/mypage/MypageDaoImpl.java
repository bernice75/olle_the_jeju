package com.olle.dao.mypage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dao.member.MemberDao;
import com.olle.dto.customplan.CustomDto;
import com.olle.dto.etc.DibDto;
import com.olle.dto.etc.HashtagDto;
import com.olle.dto.member.Criteria;
import com.olle.dto.member.MemberDto;

@Repository
public class MypageDaoImpl implements MypageDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	//회원정보 조회
	@Override
	public MemberDto mypageInfo(String user_id) {
		
		MemberDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE+"selectOneUser", user_id);
		} catch (Exception e) {
			System.out.println("[error] : mypageInfo");
			e.printStackTrace();
		}
		return dto;
	}

	//회원정보 수정
	@Override
	public int userUpdate(MemberDto dto) { 
		try {
			sqlSession.update(NAMESPACE+"userUpdate", dto); 
		} catch (Exception e) {
			System.out.println("[error] : userUpdate"); 
		e.printStackTrace(); 
		} 
		
		return sqlSession.update(NAMESPACE+"userUpdate", dto);
	}
	
	//회원정보 수정 (프로필 이미지) //회원정보 수정 (프로필 이미지 등록 및 변경) - 작업중
	@Override
	public int profileUpdate(MemberDto dto) {
		
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE+"profileUpdate", dto);
		} catch (Exception e) {
			System.out.println("[error] : profileUpdate"); 
			e.printStackTrace();
		}
		return res;
	}
	 
	//회원정보 수정 및 탈퇴를 위한 비밀번호체크 
	@Override public boolean checkPw(String user_id, String user_pw) {
		boolean	result = false; 
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id); 
		map.put("user_pw", user_pw);
	 
		int count = sqlSession.selectOne(NAMESPACE+"checkPw", map); 
		
		if(count == 1)
		result = true; 
		
		return result; 
	}
	 
	
	//회원강제 탈퇴(관리자 권한/신고수적용)
	@Override
	public int mypageLeave(String user_id, int user_warning) {
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE+"leaveUser");
		} catch (Exception e) {
			System.out.println("[error] : mypageLeave");
			e.printStackTrace();
		}
		return res;
	}

	//회원 자진탈퇴(로그인한 본인이 탈퇴시 계정삭제)
	@Override
	public int deleteUser(String user_id, String user_pw) {
		MemberDto dto = new MemberDto();
		dto.setUser_id(user_id);
		dto.setUser_pw(user_pw);
		
		int res = sqlSession.delete(NAMESPACE+"userDelete", dto);
		return res;
	}

	//내가 작성한 게시글 조회
	//썸네일 부분 전체
	@Override
	public List<CustomDto> myWriteList(String plan_writer, int page) {
		List<CustomDto> list = new ArrayList<CustomDto>();
		
		int pageP = (page-1)*6;
		int pageN = page*6;
		
		Map map = new HashMap();
		map.put("pageP", pageP);
		map.put("pageN", pageN);
		map.put("plan_writer", plan_writer);
		
		
		list = sqlSession.selectList("customplan.selectAll", map);
		
		System.out.println("목록 개수 : " + list.size());
		return list;
	}
	
	@Override
	public HashtagDto hashList(int table_num) {
		
		HashtagDto dto = sqlSession.selectOne("hashtag.selectHash", table_num);
		
		return dto;
	}
	
	//내가 작성한 게시글 총 갯수
	@Override
	public int listCount(String plan_writer) {
		int cnt = 0;
		String sql = "";
		try {
			if(plan_writer.equals("전체")) {
				sql = "countAll";
			} else {
				sql = "count";
			}
			
			cnt = sqlSession.selectOne(NAMESPACE + sql, plan_writer);
		}catch (Exception e) {
			System.out.println("[ERROR : COUNT]");
	        e.printStackTrace();
		}
		
		return cnt;
	}
	
	//내가 찜한 게시글 조회에서는 찜 목록만 추가
	@Override
	public List<DibDto> myDibList(int table_num) {
		
		List<DibDto> dibDto = sqlSession.selectList("dib.selectdDibList", table_num);
		
		return dibDto;
	}

	//문의사항 (실시간 채팅)
	
	//신고확인
	@Override
	public int mypageWarn(String user_id) {
		
		int res = 0;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"mypageWarn", user_id);
		} catch (Exception e) {
			System.out.println("[error] : mypageWarn");
			e.printStackTrace();
		}
		return res;
	}
}
