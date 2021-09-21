package com.olle.dto.etc;

//본격적인 메세지 VO(방번호와 메세지번호 PK)
public class ChatMessage {
	private String message_id;        // 메세지 번호
	private String room_id;            // 방 번호
    private String message_content;            // 메세지 내용
    private String from_user;            // 보낸이 이름
    
	public ChatMessage() {
		super();
	}

	public ChatMessage(String message_id, String room_id, String message_content, String from_user) {
		super();
		this.message_id = message_id;
		this.room_id = room_id;
		this.message_content = message_content;
		this.from_user = from_user;
	}

	public String getMessage_id() {
		return message_id;
	}

	public void setMessage_id(String message_id) {
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
}
