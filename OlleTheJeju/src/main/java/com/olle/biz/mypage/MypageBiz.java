package com.olle.biz.mypage;

import java.util.List;

import com.olle.dto.member.MemberDto;

public interface MypageBiz {
	
	//마이페이지 회원정보 조회
	public MemberDto mypageInfo(String user_id);
		
	//마이페이지 회원정보 수정
	/*public int mypageInfoUpdate(MemberDto userUpdate);*/
	public void mypageInfoUpdate(MemberDto dto);
	
	/* 다시 수정해야함
	 * //회원정보 수정 비밀번호 체크
	public boolean checkPw(String user_id, String user_pw);*/
	
	//회원 강제 탈퇴
	public int mypageLeave(String user_id, String user_pw);
	
	//회원 자진 탈퇴
	public int mypageDelete(String user_id, String user_pw);
	
	//내가 작성한 게시글 조회
	public List<MemberDto> myWriteList(String user_nick, int pageNum);
	
	//내가 찜한 게시글 조회 
	public List<MemberDto> myDibList(String user_nick, int pageNum);
	
	//문의사항 (실시간 채팅)
	
	//신고확인

}
