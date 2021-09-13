package com.olle.biz.mypage;

import java.util.List;

import com.olle.dto.member.MemberDto;

public interface MypageBiz {
	
	//회원정보 조회
	public MemberDto mypageInfo(String user_id);
		
	//회원정보 수정
	/*public int userUpdate(MemberDto userUpdate);*/
	//public void updateUser(MemberDto dto);
	public int newPw(String user_pw, String new_pw);
	
	//회원정보 수정 및 삭제를 위한 비밀번호체크
	public boolean checkPw(String user_id, String user_pw);
	
	//회원 강제 탈퇴
	public int mypageLeave(String user_id, String user_pw);
	
	//회원 자진 탈퇴
	/*public int mypageDelete(String user_id, String user_pw);*/
	public void deleteUser(String user_id);
	
	//내가 작성한 게시글 조회
	public List<MemberDto> myWriteList(String user_nick, int pageNum);
	
	//내가 찜한 게시글 조회 
	public List<MemberDto> myDibList(String user_nick, int pageNum);
	
	//문의사항 (실시간 채팅)
	
	//신고확인

}
