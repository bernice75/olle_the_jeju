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
import com.olle.biz.etc.ChatBiz;

@RequestMapping("echo.do")
public class EchoHandler extends TextWebSocketHandler {
	@Autowired
    ChatBiz cService;
    
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    // 채팅방 목록 <방 번호, ArrayList<session>>이 들어간다.
    private Map<String, ArrayList<WebSocketSession>> RoomList = new HashMap<String, ArrayList<WebSocketSession>>();
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
