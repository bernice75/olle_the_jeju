package com.olle.biz.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.member.MemberDao;
import com.olle.dto.member.MemberDto;

@Service
public class MemberBizImpl implements MemberBiz{

	@Autowired
	private MemberDao memberDao;

	@Override
	public int userInsert(MemberDto dto) {
		System.out.println("회원가입");
		return memberDao.userInsert(dto);
	}

	@Override
	public int idChk(String user_id) {
		System.out.println("dao 실행 시작");
		return memberDao.idChk(user_id);
	}
	
	@Override
	public int nickChk(String user_nick) {
		System.out.println("dao 실행 시작");
		return memberDao.nickChk(user_nick);
	}

	@Override
	public List<MemberDto> userList() {
		return null;
	}

	@Override
	public String login(String user_id, String user_pw) {
		return memberDao.login(user_id, user_pw);
	}
	@Override
	public MemberDto selectUser(String user_id) {
		// TODO Auto-generated method stub
		return memberDao.selectUser(user_id);
	}
}
