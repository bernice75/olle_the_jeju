package com.olle.dao.member;

import java.util.List;

import com.olle.dto.member.MemberDto;

public interface MemberDao {
	
	String NAMESPACE="member.";
	
	public List<MemberDto> userList();
	public int userInsert(MemberDto dto);	// 회원 정보를 저장한다.
	public int idChk(String user_id);  //아이디 중복체크
	public int nickChk(String user_nick);  //닉네임 중복체크
	public String login(String user_id, String user_pw); //로그인
	public String findId(String user_email);
	public String findPw(String user_id);
	public MemberDto selectUser(String user_id); //유저 정보 출력
	public int warn_update(String user_id); //경고 +1
}
