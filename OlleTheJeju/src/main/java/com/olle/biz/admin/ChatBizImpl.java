package com.olle.biz.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.admin.ChatDao;
import com.olle.dto.etc.ChatMessage;

@Service
public class ChatBizImpl implements ChatBiz {
	
	@Autowired
	private ChatDao dao;

	@Override
	public List<String> selectRoom() {
		return dao.selectRoom();
	}
	
	@Override
	public int maxNum() {
		return dao.maxNum();
	}

	@Override
	public int insert(ChatMessage dto) {
		return dao.insert(dto);
	}

	@Override
	public List<ChatMessage> selectList(String room_id) {
		return dao.selectList(room_id);
	}

	@Override
	public ChatMessage newMessage(String room_id) {
		return dao.newMessage(room_id);
	}

}
