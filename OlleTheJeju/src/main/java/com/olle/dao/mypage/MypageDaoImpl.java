package com.olle.dao.mypage;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.olle.dto.mypage.MypageDto;

public class MypageDaoImpl implements MypageDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	//마이페이지 회원정보 조회
	@Override
	public MypageDto mypageInfo(String user_id) {
		
		MypageDto dto = null;
		
		try {
			dto = sqlSession.mypageInfo(NAMESPACE+"mypageInfo", user_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	//마이페이지 회원정보수정
	@Override
	public int mypageInfoUpdate(MypageDto userUpdate) {
		return 0;
	}
	//회원 강제탈퇴(관리자 권한 / 신고에 의해)
	@Override
	public int mypageLeave(String user_id, String user_pw) {
		return 0;
	}
	//회원 자진틸퇴(로그인한 본인이 탈퇴시 DB에서 삭제)
	@Override
	public int mypageDelete(String user_id) {
		return 0;
	}
	//내가 작성한 게시글 조회
	@Override
	public List<MypageDto> myWriteList(String user_nick, int pageNum) {
		return null;
	}
	//내가찜한 게시글 조회
	@Override
	public List<MypageDto> myDibList(String user_nick, int pageNum) {
		return null;
	}
	
	//문의사항 (실시간 채팅)
	
	//신고확인

}
