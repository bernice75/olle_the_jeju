package com.olle.dto.etc;

import java.util.Date;

//본격적인 메세지 VO(방번호와 메세지번호 PK)
public class ChatMessage {
	private int message_id;        // 메세지 번호
	private String room_id;            // 방 번호
    private String message_content;       // 메세지 내용
    private String from_user;            // 보낸이 이름
    private String to_user;             // 받는이 이름
    private Date message_regdate;   //보낸 날짜
    
	public ChatMessage() {
		super();
	}

	public ChatMessage(int message_id, String room_id, String message_content, String from_user, String to_user, Date message_regdate) {
		super();
		this.message_id = message_id;
		this.room_id = room_id;
		this.message_content = message_content;
		this.from_user = from_user;
		this.to_user = to_user;
		this.message_regdate = message_regdate;
	}

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

	public String getRoom_id() {
		return room_id;
	}

	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}

	public String getMessage_content() {
		return message_content;
	}

	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}

	public String getFrom_user() {
		return from_user;
	}

	public void setFrom_user(String from_user) {
		this.from_user = from_user;
	}
	public String getTo_user() {
		return to_user;
	}

	public void setTo_user(String to_user) {
		this.to_user = to_user;
	}

	public Date getMessage_regdate() {
		return message_regdate;
	}

	public void setMessage_regdate(Date message_regdate) {
		this.message_regdate = message_regdate;
	}
}
