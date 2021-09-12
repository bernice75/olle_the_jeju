package com.olle.dao.member;

import com.olle.dto.member.MemberDto;

public interface MemberDao {
	String NAMESPACE="myMember.";
	public int userInsert(MemberDto dto);	// 회원 정보를 저장한다.

}
