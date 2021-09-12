package com.olle.dao.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dto.member.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 *	회원을 저장한다.
	 */
	@Override
	public int userInsert(MemberDto dto) {
		int resIns=0;
		
		try {
			System.out.println("MemberDaoImpl userInsert");
			System.out.println(dto);
			resIns=sqlSession.insert("userInsert",dto);
			
			if(resIns>0) {
				System.out.println("resIns");
				System.out.println(resIns);
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

}
