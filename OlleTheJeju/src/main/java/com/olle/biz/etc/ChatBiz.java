package com.olle.biz.etc;

import java.util.List;

import com.olle.dto.etc.ChatMessage;
import com.olle.dto.etc.ChatRoom;

public interface ChatBiz {
	//방번호 선택
	public ChatRoom selectChatRoom(String roomId);
	
	//채팅 내용 db 저장
	public int insertMessage(ChatMessage chatMessage);
	
	//메세지 내용 리스트 출력
	public List<ChatMessage> messageList(String roomId);
	
	//채팅방 db 저장
	public int createChat(ChatRoom roomId);
	
	//db에 채팅방 있는지 확인
	public ChatRoom searchChatRoom(ChatRoom roomId);
	
	//채팅 방 리스트 출력
	public List<ChatRoom> chatRoomList(String user_id);
	
	//채팅 읽지 않은 메세지 수 출력
	public int selectUnReadCount(ChatMessage message);
	
	//읽은 메세지 숫자 0으로 바꾸기
	public int updateCount(ChatMessage message);
}
