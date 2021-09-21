package com.olle.biz.mypage;

import java.util.List;

import com.olle.dto.customplan.CustomDto;
import com.olle.dto.etc.DibDto;
import com.olle.dto.etc.HashtagDto;
import com.olle.dto.member.Criteria;
import com.olle.dto.member.MemberDto;

public interface MypageBiz {
	//회원정보 조회
		public MemberDto mypageInfo(String user_id);
			
		//회원정보 수정
		public int userUpdate(MemberDto dto);
		
		//회원정보 수정 (프로필 이미지) //회원정보 수정 (프로필 이미지 등록 및 변경) - 작업중
		public int profileUpdate(String user_img);
		
		//회원정보 수정 및 탈퇴를 위한 비밀번호체크
		public boolean checkPw(String user_id, String user_pw);
		
		//회원 강제 탈퇴
		public int mypageLeave(String user_id, int user_warning);
		
		//회원 자진 탈퇴
		public int deleteUser(String user_id, String user_pw);
		
		//내가 작성한 게시글 조회
		public List<CustomDto> myWriteList(String plan_writer, Criteria cri);
		public HashtagDto hashList(int table_num);
		
		//내가 작성한 게시글 총 갯수
		public int listCount();
		
		//내가 찜한 게시글 조회 
		public List<DibDto> myDibList(int table_num);
		
		//문의사항 (실시간 채팅)
		
		//신고확인
		public MemberDto mypageWarn(String user_id);
}
