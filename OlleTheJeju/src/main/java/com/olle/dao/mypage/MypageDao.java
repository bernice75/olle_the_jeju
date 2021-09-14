package com.olle.dao.mypage;


import java.util.List;

import com.olle.dto.member.MemberDto;

public interface MypageDao {

	String NAMESPACE="user.";
	
	//회원정보 조회
	public MemberDto mypageInfo(String user_id);
	
	//회원정보 수정
	/*public int userUpdate(MemberDto userUpdate);*/
	//public void updateUser(MemberDto dto);
	public int newPw(String user_pw, String new_pw);
	
	//회원정보 수정 및 삭제를 위한 비밀번호체크
	public boolean checkPw(String user_id, String user_pw);
	
	//회원 강제 탈퇴(관리자 권한/신고수적용)
	public int mypageLeave(String user_id, int user_warning);
	
	//회원 자진 탈퇴(로그인한 본인이 탈퇴시 계정삭제)
	public int deleteUser(String user_id, String user_pw);
	
	//내가 작성한 게시글 조회
	public List<MemberDto> myWriteList(String user_id, int pageNum);
	
	//내가 찜한 게시글 조회 
	public List<MemberDto> myDibList(String user_id, int pageNum);
	
	//문의사항 (실시간 채팅)
	
	//신고확인
	public MemberDto mypageWarn(String user_id);
	
}
