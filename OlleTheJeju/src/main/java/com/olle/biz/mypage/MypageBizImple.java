package com.olle.biz.mypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.member.MemberDao;
import com.olle.dao.mypage.MypageDao;
import com.olle.dto.member.MemberDto;

@Service
public class MypageBizImple implements MypageBiz{

	@Autowired
	private MypageDao dao;
	
	//회원정보 조회
	@Override
	public MemberDto mypageInfo(String user_id) {
		return dao.mypageInfo(user_id);
	}

	//회원정보 수정
	/*@Override
	public int userUpdate(MemberDto userUpdate) {
		return dao.userUpdate(userUpdate);
	}*/
	@Override
	public int newPw(String user_pw, String new_pw) {
		return dao.newPw(user_pw, new_pw);
	}
	
	//회원정보 수정 및 삭제를 위한 비밀번호체크
	@Override
	public boolean checkPw(String user_id, String user_pw) {
		return dao.checkPw(user_id, user_pw);
	}

	//회원 강제 탈퇴
	@Override
	public int mypageLeave(String user_id, int user_warning) {
		return dao.mypageLeave(user_id, user_warning);
	}

	//회원 자진 탈퇴
	public int deleteUser(String user_id, String user_pw) {
		return dao.deleteUser(user_id, user_pw);
	}

	//내가 작성한 게시글 조회
	@Override
	public List<MemberDto> myWriteList(String user_id, int pageNum) {
		return dao.myWriteList(user_id, pageNum);
	}

	//내가 찜한 게시글 조회 
	@Override
	public List<MemberDto> myDibList(String user_id, int pageNum) {
		return dao.myDibList(user_id, pageNum);
	}

	//문의사항 (실시간 채팅)
	
	//신고확인
	@Override
	public MemberDto mypageWarn(String user_id) {
		return dao.mypageWarn(user_id);
	}
	
}
