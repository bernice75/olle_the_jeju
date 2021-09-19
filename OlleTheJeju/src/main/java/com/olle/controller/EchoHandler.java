package com.olle.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    // session, 방 번호가 들어간다.
    private Map<String, WebSocketSession> sessionList = new HashMap<String, WebSocketSession>();
    
    //클라이언트가 웹소켓 연결 성공
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    	System.out.println(session.getId());
    	super.afterConnectionEstablished(session);
    	sessionList.put(session.getId(), session);
    }
    
    //클라이언트가 웹소켓 서버로 메시지를 전송했을 때 실행
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    	//메시지 발송(형식 : (보낸사람이 관리자라면 -> 내용 : 관리자)
		String msg = message.getPayload();
		//띄어쓰기를 기준으로 잘라 0번째 값을 msg에 저장한다.
		msg = msg.split(" : ")[0];
		System.out.println("메세지 : " + msg);
		
		for(String key : sessionList.keySet()) {
			WebSocketSession wss = sessionList.get(key);
			try {
				wss.sendMessage(new TextMessage(msg));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
    }
    
    //클라이언트가 웹소켓 연결 종료
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    	//소켓 종료
    	sessionList.remove(session.getId());
		super.afterConnectionClosed(session, status);
    }
}
