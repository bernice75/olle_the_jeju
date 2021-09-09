package com.olle.dao.mypage;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dto.member.MemberDto;

@Repository
public class MypageDaoImpl implements MypageDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public MemberDto mypageInfo(String user_id) {
		
		MemberDto dto = null;
		//dto = sqlSession.mypageInfo(NAMESPACE+"mypageInfo", user_id);
		return null;
	}

	@Override
	public int mypageInfoUpdate(MemberDto userUpdate) {
		return 0;
	}

	@Override
	public int mypageLeave(String user_id, String user_pw) {
		return 0;
	}

	@Override
	public int mypageDelete(String user_id, String user_pw) {
		return 0;
	}

	@Override
	public List<MemberDto> myWriteList(String user_nick, int pageNum) {
		return null;
	}

	@Override
	public List<MemberDto> myDibList(String user_nick, int pageNum) {
		return null;
	}

	
	
	//문의사항 (실시간 채팅)
	
	//신고확인

}
