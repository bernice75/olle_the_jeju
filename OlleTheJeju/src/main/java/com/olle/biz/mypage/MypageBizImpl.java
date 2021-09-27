package com.olle.biz.mypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.mypage.MypageDao;
import com.olle.dto.customplan.CustomDto;
import com.olle.dto.etc.DibDto;
import com.olle.dto.etc.HashtagDto;
import com.olle.dto.member.Criteria;
import com.olle.dto.member.MemberDto;

@Service
public class MypageBizImpl implements MypageBiz {
	@Autowired
	private MypageDao dao;
	
	//회원정보 조회
	@Override
	public MemberDto mypageInfo(String user_id) {
		return dao.mypageInfo(user_id);
	}

	//회원정보 수정
	@Override
	 public int userUpdate(MemberDto dto) { 
		 return dao.userUpdate(dto); 
	}
	
	//회원정보 수정 (프로필 이미지) //회원정보 수정 (프로필 이미지 등록 및 변경)
	@Override
	public int profileUpdate(MemberDto dto) {
		return dao.profileUpdate(dto);
	}
	 
	//회원정보 수정 및 탈퇴를 위한 비밀번호체크
	@Override public boolean checkPw(String user_id, String user_pw) { 
		return dao.checkPw(user_id, user_pw); 
	}

	//회원 강제 탈퇴
	@Override
	public int mypageLeave(String user_id, int user_warning) {
		return dao.mypageLeave(user_id, user_warning);
	}

	//회원 자진 탈퇴
	public int deleteUser(String user_id, String user_pw) {
		return dao.deleteUser(user_id, user_pw);
	}

	//내가 작성한 게시글 조회
	//썸네일 부분 전체
	@Override
	public List<CustomDto> myWriteList(String plan_writer, int page) {
		return dao.myWriteList(plan_writer, page);
	}
	
	@Override
	public HashtagDto hashList(int table_num) {
		return dao.hashList(table_num);
	}
	
	//내가 작성한 게시글 총 갯수
	@Override
	public int listCount(String plan_writer) {
		return dao.listCount(plan_writer);
	}
	//내가 찜한 게시글 조회 
	@Override
	public List<DibDto> myDibList(int table_num) {
		return dao.myDibList(table_num);
	}
	
	//신고확인
	@Override
	public int mypageWarn(String user_id) {
		return dao.mypageWarn(user_id);
	}
}