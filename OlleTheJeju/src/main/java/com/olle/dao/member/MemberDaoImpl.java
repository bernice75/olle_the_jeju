package com.olle.dao.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dto.member.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int userInsert(MemberDto dto) {
		int resIns = 0;
		
		try {
			System.out.println("회원가입 시도 중...");
			resIns=sqlSession.insert(NAMESPACE + "userInsert", dto);
			
			if(resIns > 0) {
				System.out.println("resIns : " + resIns);
				System.out.println("회원가입 성공");
			}else {
				System.out.println("회원가입 실패");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR]userInsert");
		}
		
		return resIns;
	}

	@Override
	public int idChk(String user_id) {
		System.out.println("넘어온 id값 : " + user_id);
		int res = 0;
		try {
			System.out.println(NAMESPACE + "idChk 실행.....");
			
			res = sqlSession.selectOne(NAMESPACE + "idChk", user_id);
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR]idChk");
		}
		
		return res;
	}
	
	@Override
	public int nickChk(String user_nick) {
		System.out.println("넘어온 nick값 : " + user_nick);
		int res = 0;
		try {
			System.out.println(NAMESPACE + "nickChk 실행.....");
			
			res = sqlSession.selectOne(NAMESPACE + "nickChk", user_nick);
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR]nickChk");
		}
		
		return res;
	}

	@Override
	public List<MemberDto> userList() {
		List<MemberDto> userList = null;
		
		try {
			System.out.println(NAMESPACE + "selectList 실행.....");
			userList = sqlSession.selectList(NAMESPACE + "selectList");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR]userList");
		}
		return userList;
	}

	@Override
	public String login(String user_id, String user_pw) {
		MemberDto dto = new MemberDto();
		dto.setUser_id(user_id);
		dto.setUser_pw(user_pw);
		
		String res = sqlSession.selectOne(NAMESPACE + "login", dto);
		
		return res;
	}
	
	@Override
	public MemberDto selectUser(String user_id) {
		MemberDto dto = sqlSession.selectOne(NAMESPACE + "selectUser", user_id);
		
		return dto;
	}

	@Override
	public int warn_update(String user_id) {
		return sqlSession.update(NAMESPACE + "warn_update", user_id);
	}

	@Override
	public String findId(String user_email) {
		return sqlSession.selectOne(NAMESPACE + "findId", user_email);
	}

	@Override
	public String findPw(String user_id) {
		return sqlSession.selectOne(NAMESPACE + "findPw", user_id);
	}
}
