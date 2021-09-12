package com.olle.biz.member;

import com.olle.dto.member.MemberDto;

public interface MemberBiz {
	public int userInsert(MemberDto dto);	// 회원 정보를 저장한다.
}
