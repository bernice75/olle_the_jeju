package com.olle.dao.admin;

import java.util.List;

import com.olle.dto.etc.ChatMessage;

public interface ChatDao {
	String NAMESPACE = "support.";
	
	//해당하는 방이 있는지 조회
	public List<String> selectRoom();
	
	//방번호로 최신 메세지 가져오기
	public ChatMessage newMessage(String room_id);
	
	//메세지 저장
	public int maxNum();
	public int insert(ChatMessage dto);
	
	//방정보 목록 가져오기
	public List<ChatMessage> selectList(String room_id);
}
