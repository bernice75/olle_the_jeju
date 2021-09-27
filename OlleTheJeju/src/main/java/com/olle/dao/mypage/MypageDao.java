package com.olle.dao.mypage;


import java.util.List;

import com.olle.dto.customplan.CustomDto;
import com.olle.dto.etc.DibDto;
import com.olle.dto.etc.HashtagDto;
import com.olle.dto.member.Criteria;
import com.olle.dto.member.MemberDto;

public interface MypageDao {

	String NAMESPACE="user.";
		
	//회원정보 조회
	public MemberDto mypageInfo(String user_id);
	
	//회원정보 수정
	public int userUpdate(MemberDto dto);
	
	//회원정보 수정 (프로필 이미지) //회원정보 수정 (프로필 이미지 등록 및 변경)
	public int profileUpdate(MemberDto dto);
	
	//회원정보 수정 및 삭제를 위한 비밀번호체크 
	public boolean checkPw(String user_id, String user_pw);
	
	//회원 강제 탈퇴(관리자 권한/신고수적용)
	public int mypageLeave(String user_id, int user_warning);
	
	//회원 자진 탈퇴(로그인한 본인이 탈퇴시 계정삭제)
	public int deleteUser(String user_id, String user_pw);
	
	//내가 작성한 게시글 조회
	public List<CustomDto> myWriteList(String plan_writer, int page);
	public HashtagDto hashList(int table_num);
	
	//내가 작성한 게시글 총 갯수
	public int listCount(String plan_writer);
	
	//내가 찜한 게시글 조회 
	public List<DibDto> myDibList(int table_num);
	
	//문의사항 (실시간 채팅)
	
	//신고확인
	public int mypageWarn(String user_id);
}