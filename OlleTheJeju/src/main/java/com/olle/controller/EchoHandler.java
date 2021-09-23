package com.olle.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.olle.biz.admin.ChatBiz;
import com.olle.dto.etc.ChatMessage;

@RequestMapping("echo.do")
public class EchoHandler extends TextWebSocketHandler {
	@Autowired
    ChatBiz chatBiz;
    
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    //웹소켓 세션을 담아둘 맵
    HashMap<String, WebSocketSession> sessionMap = new HashMap<String, WebSocketSession>();
    
    //클라이언트가 웹소켓 연결 성공
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    	System.out.println(session.getId());
    	//소켓 연결
		super.afterConnectionEstablished(session);
		sessionMap.put(session.getId(), session);
		JSONObject obj = new JSONObject();
		obj.put("type", "getId");
		obj.put("sessionId", session.getId());
		session.sendMessage(new TextMessage(obj.toJSONString()));
    }
    
    //클라이언트가 웹소켓 서버로 메시지를 전송했을 때 실행
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    	//메시지 발송
    	String msg = message.getPayload();
    	System.out.println(msg);
		JSONObject obj = jsonToObjectParser(msg);
		ChatMessage chat = new ChatMessage();
		
		//테이블에서 message_id 최대값 조회
		int message_id = chatBiz.maxNum();
		System.out.println("message_id : " + message_id);
		
		//메세지 저장
		String room_id = (String) obj.get("room_id");
		String from_user = (String) obj.get("from_user");
		String to_user = (String) obj.get("to_user");
		String message_content = (String) obj.get("msg");
		
		chat.setMessage_id(message_id + 1);
		chat.setRoom_id(room_id);
		chat.setFrom_user(from_user);
		chat.setTo_user(to_user);
		chat.setMessage_content(message_content);
		
		int res = chatBiz.insert(chat);
		
		if(res > 0) {
			System.out.println("해당 메세지 저장 완료");
		} else {
			System.out.println("메세지 저장 실패");
		}
		
		//다른 사람한테 메세지 수신
		for(String key : sessionMap.keySet()) {
			WebSocketSession wss = sessionMap.get(key);
			try {
				wss.sendMessage(new TextMessage(obj.toJSONString()));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
    }
    
    //클라이언트가 웹소켓 연결 종료
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    	//소켓 종료
    	sessionMap.remove(session.getId());
		super.afterConnectionClosed(session, status);
    }
    
    //제이슨 형태의 문자열 파싱
    private static JSONObject jsonToObjectParser(String jsonStr) {
		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(jsonStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
