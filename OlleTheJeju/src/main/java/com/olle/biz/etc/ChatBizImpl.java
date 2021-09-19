package com.olle.biz.etc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.etc.ChatDao;
import com.olle.dto.etc.ChatMessage;
import com.olle.dto.etc.ChatRoom;

@Service
public class ChatBizImpl implements ChatBiz {
	
	@Autowired
	private ChatDao dao;
	
	@Override
	public ChatRoom selectChatRoom(String roomId) {
		return dao.selectChatRoom(roomId);
	}

	@Override
	public int insertMessage(ChatMessage chatMessage) {
		return dao.insertMessage(chatMessage);
	}

	@Override
	public List<ChatMessage> messageList(String roomId) {
		return dao.messageList(roomId);
	}

	@Override
	public int createChat(ChatRoom roomId) {
		return dao.createChat(roomId);
	}

	@Override
	public ChatRoom searchChatRoom(ChatRoom roomId) {
		return dao.searchChatRoom(roomId);
	}

	@Override
	public List<ChatRoom> chatRoomList(String user_id) {
		return dao.chatRoomList(user_id);
	}

	@Override
	public int selectUnReadCount(ChatMessage message) {
		return dao.selectUnReadCount(message);
	}

	@Override
	public int updateCount(ChatMessage message) {
		return dao.updateCount(message);
	}
}
