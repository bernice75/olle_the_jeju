package com.olle.dao.etc;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dto.etc.ChatMessage;
import com.olle.dto.etc.ChatRoom;

@Repository
public class ChatDaoImpl implements ChatDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public ChatRoom selectChatRoom(String roomId) {
		ChatRoom res = sqlSession.selectOne(NAMESPACE + "selectChatRoom", roomId);
		
		return res;
	}

	@Override
	public int insertMessage(ChatMessage chatMessage) {
		int res = sqlSession.insert(NAMESPACE + "insertMessage", chatMessage);
		
		return res;
	}

	@Override
	public List<ChatMessage> messageList(String roomId) {
		List<ChatMessage> res = sqlSession.selectList(NAMESPACE + "messageList", roomId);
		
		return res;
	}

	@Override
	public int createChat(ChatRoom roomId) {
		int res = sqlSession.insert(NAMESPACE + "createChat", roomId);
		
		return res;
	}

	@Override
	public ChatRoom searchChatRoom(ChatRoom roomId) {
		ChatRoom res = sqlSession.selectOne(NAMESPACE + "searchChatRoom", roomId);
		
		return res;
	}

	@Override
	public List<ChatRoom> chatRoomList(String user_id) {
		List<ChatRoom> res = sqlSession.selectList(NAMESPACE + "chatRoomList", user_id);
		
		return res;
	}

	@Override
	public int selectUnReadCount(ChatMessage message) {
		int res = sqlSession.selectOne(NAMESPACE + "selectUnReadCount",message);
		
		return res;
	}

	@Override
	public int updateCount(ChatMessage message) {
		int res = sqlSession.update(NAMESPACE + "updateCount", message);
		
		return res;
	}

	

}
