package com.olle.dao.mypage;

import com.olle.dto.mypage.MypageDto;

public interface MypageDao {
	
	//마이페이지 회원정보 조회
	public MypageDto mypageInfo(String email);
	
	//마이페이지 회원정보 수정
	public int mypageInfoUpdate(MypageDto userUpdate);
	
	//회원탈퇴
	public int mypageLeave(String email, String password);
}
