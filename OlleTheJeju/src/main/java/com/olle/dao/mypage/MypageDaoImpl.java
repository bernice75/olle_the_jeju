package com.olle.dao.mypage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dao.member.MemberDao;
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
	public int mypageInfoUpdate(MemberDto userUpdate) {
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE+"updateUser");
		} catch (Exception e) {
			System.out.println("[error] : mypageInfoUpdate");
			e.printStackTrace();
		}
		return res;
	}*/
	@Override
	public void mypageInfoUpdate(MemberDto dto) {
		sqlSession.update(NAMESPACE+"updateUser", dto);
	}

	/* 다시 수정해야함
	 * //회원정보 수정 비밀번호 체크
	public boolean checkPw(String user_id, String user_pw) {
		
		boolean result = false;
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("user_pw", user_pw);
		
		int count = sqlSession.selectOne(NAMESPACE+"checkPw", map);
		if(count == 1)result = true;
		
		return result;
	}*/
	
	
	//회원강제 탈퇴(관리자 권한/신고수적용)
	@Override
	public int mypageLeave(String user_id, String user_pw) {
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
	public int mypageDelete(String user_id, String user_pw) {
		int res = 0;
		try {
			res = sqlSession.delete(NAMESPACE+"deleteUser", user_id);
		} catch (Exception e) {
			System.out.println("[error]  :  mypageDelete");
			e.printStackTrace();
		}
		return res;
	}

	//내가 작성한 게시글 조회
	@Override
	public List<MemberDto> myWriteList(String user_nick, int pageNum) {
		List<MemberDto> list = new ArrayList<MemberDto>();
		
		try {
			list = sqlSession.selectList(NAMESPACE+"mywritelist");
		} catch (Exception e) {
			System.out.println("[error] : myWriteList");
			e.printStackTrace();
		}
		return list;
	}

	//내가 찜한 게시글 조회 
	@Override
	public List<MemberDto> myDibList(String user_nick, int pageNum) {
		List<MemberDto> diblist = new ArrayList<MemberDto>();
		
		try {
			diblist = sqlSession.selectList(NAMESPACE+"mydiblist");
		} catch (Exception e) {
			System.out.println("[error] : myDiblist");
			e.printStackTrace();
		}
		return diblist;
	}

	

	//문의사항 (실시간 채팅)
	
	//신고확인

}
