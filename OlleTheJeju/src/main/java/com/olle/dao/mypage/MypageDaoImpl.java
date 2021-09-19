package com.olle.dao.mypage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dto.customplan.CustomDto;
import com.olle.dto.etc.DibDto;
import com.olle.dto.etc.HashtagDto;
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
	/*@Override
	public int userUpdate(MemberDto userUpdate) {
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE+"userUpdate");
		} catch (Exception e) {
			System.out.println("[error] : userUpdate");
			e.printStackTrace();
		}
		return res;
	}*/
	@Override
	public int newPw(String user_pw, String new_pw) {
		MemberDto dto = new MemberDto();
		dto.setUser_pw(user_pw);
		dto.setUser_id(new_pw);
		
		int res = 0;
		
		res = sqlSession.update(NAMESPACE + "newPw", dto);
		return res;
	};
	
	//회원정보 수정 및 삭제를 위한 비밀번호체크
	@Override
	public boolean checkPw(String user_id, String user_pw) {
		boolean result = false;
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("user_pw", user_pw);
		
		int count = sqlSession.selectOne(NAMESPACE+"checkPw", map);
		if(count == 1) result = true;
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
	public List<CustomDto> myWriteList(String plan_writer) {
		List<CustomDto> list = new ArrayList<CustomDto>();
		
		try {
			list = sqlSession.selectList("customplan.mywritelist", plan_writer);
		} catch (Exception e) {
			System.out.println("[error] : myWriteList");
			e.printStackTrace();
		}
		return list;
	}
	//해시태그는 따로 추가
	@Override
	public List<HashtagDto> hashList(int table_num) {
		
		List<HashtagDto> dto = sqlSession.selectList("hashtag.selectList",table_num);
		
		return dto;
	}
	
	//내가 작성한 게시글 rowcount
	/*@Override
	public int myWriteRowCount(String user_id) {
		
		int count = 0;
		
		return 0;
	}*/

	//내가 찜한 게시글 조회에서는 찜 목록만 추가

	@Override
	public List<DibDto> myDibList(int table_num) {
		
		List<DibDto> dibDto = sqlSession.selectList("dib.selectdDibList", table_num);
		
		return dibDto;
	}

	//문의사항 (실시간 채팅)
	
	//신고확인
	@Override
	public MemberDto mypageWarn(String user_id) {
		
		MemberDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE+"mypageWarn", user_id);
		} catch (Exception e) {
			System.out.println("[error] : mypageWarn");
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int mypageInfoUpdate(MemberDto userUpdate) {
		// TODO Auto-generated method stub
		return 0;
	}

}
