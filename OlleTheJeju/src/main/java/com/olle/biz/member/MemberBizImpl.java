package com.olle.biz.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.member.MemberDao;
import com.olle.dto.member.MemberDto;

@Service
public class MemberBizImpl implements MemberBiz{

	@Autowired
	private MemberDao memberDao;

	/**
	 * 회원 정보를 저장한다.
	 */
	@Override
	public int userInsert(MemberDto dto) {
		System.out.println("MemberBizImpl userInsert");
		System.out.println(dto);
		return memberDao.userInsert(dto);
	}

}
