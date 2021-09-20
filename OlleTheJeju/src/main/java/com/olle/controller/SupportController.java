package com.olle.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.olle.biz.etc.ChatBiz;
import com.olle.biz.member.MemberBiz;
import com.olle.dto.etc.ChatMessage;
import com.olle.dto.etc.ChatRoom;
import com.olle.dto.member.MemberDto;

@Controller
public class SupportController {
	/*
	@Autowired
    ChatBiz cService;
	
	@Autowired
	MemberBiz memberBiz;
	
	//해당 채팅방의 채팅 메세지 불러오기
	@RequestMapping(value="{roomId}.do")
    public void messageList(@PathVariable String roomId, String name, Model model, HttpServletResponse response) throws JsonIOException, IOException {
        
        List<ChatMessage> mList = cService.messageList(roomId);
        response.setContentType("application/json; charset=utf-8");
 
        // 안읽은 메세지의 숫자 0으로 바뀌기
        ChatMessage message = new ChatMessage();
        message.setName(name);
        message.setRoomId(roomId);
        cService.updateCount(message);
        
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        gson.toJson(mList,response.getWriter());
    }
	
	//채팅 방이 없을 때 생성
	@RequestMapping("createChat.do")
	@ResponseBody
    public String createChat(ChatRoom room, String user_id, String master_id){
		MemberDto user = memberBiz.selectUser(user_id); //보낸 이
        MemberDto master = memberBiz.selectUser(master_id); //받는 이
		
        room.setUser_id(user_id);
        room.setUserPic(user.getUser_img());
        room.setMasterName(master_id);
        room.setMasterPic(master.getUser_img());
 
        ChatRoom exist  = cService.searchChatRoom(room);
        
        // DB에 방이 없을 때
        if(exist == null) {
            System.out.println("방이 없다!!");
            int result = cService.createChat(room);
            if(result == 1) {
                System.out.println("방 만들었다!!");
                return "new";
            }else {
                return "fail";
            }
        }
        // DB에 방이 있을 때
        else{
            System.out.println("방이 있다!!");
            return "exist";
        }
    }
	
	//채팅 방 목록 불러오기
	@RequestMapping("chatRoomList.do")
    public void createChat(ChatRoom room, ChatMessage message, String name, HttpServletResponse response) throws JsonIOException, IOException{
        List<ChatRoom> cList = cService.chatRoomList(name);
        
        for(int i = 0; i < cList.size(); i++) {
            message.setRoomId(cList.get(i).getRoomId());
            message.setName(name);
            int count = cService.selectUnReadCount(message);
            cList.get(i).setUnReadCount(count);
        }
        
        response.setContentType("application/json; charset=utf-8");
 
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        gson.toJson(cList,response.getWriter());
    }
	
	@RequestMapping("chatSession.do")
    public void chatSession( HttpServletResponse response) throws JsonIOException, IOException{
        
        ArrayList<String> chatSessionList = cSession.getLoginUser();
        
        response.setContentType("application/json; charset=utf-8");
 
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        gson.toJson(chatSessionList,response.getWriter());
    }
    */
}
