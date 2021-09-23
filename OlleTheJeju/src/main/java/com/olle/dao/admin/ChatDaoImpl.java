package com.olle.dao.admin;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dto.etc.ChatMessage;

@Repository
public class ChatDaoImpl implements ChatDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<String> selectRoom() {
		return sqlSession.selectList(NAMESPACE + "selectRoom");
	}
	
	@Override
	public int maxNum() {
		return sqlSession.selectOne(NAMESPACE + "maxNum");
	}

	@Override
	public int insert(ChatMessage dto) {
		return sqlSession.insert(NAMESPACE + "insert", dto);
	}

	@Override
	public List<ChatMessage> selectList(String room_id) {
		return sqlSession.selectList(NAMESPACE + "selectList", room_id);
	}

	@Override
	public ChatMessage newMessage(String room_id) {
		return sqlSession.selectOne(NAMESPACE + "newMessage", room_id);
	}

}
