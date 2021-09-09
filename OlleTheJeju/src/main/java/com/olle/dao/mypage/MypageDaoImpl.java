package com.olle.dao.mypage;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.olle.dto.mypage.MypageDto;

public class MypageDaoImpl implements MypageDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public MypageDto mypageInfo(String user_id) {
		return null;
	}

	@Override
	public int mypageInfoUpdate(MypageDto userUpdate) {
		return 0;
	}

	@Override
	public int mypageLeave(String user_id, String user_pw) {
		return 0;
	}

	@Override
	public int mypageDelete(String user_id) {
		return 0;
	}

	@Override
	public List<MypageDto> myWriteList(String user_nick, int pageNum) {
		return null;
	}

	@Override
	public List<MypageDto> myDibList(String user_nick, int pageNum) {
		return null;
	}
	
	//문의사항 (실시간 채팅)
	
	//신고확인

}
