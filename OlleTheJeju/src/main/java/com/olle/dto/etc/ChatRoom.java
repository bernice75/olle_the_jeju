package com.olle.dto.etc;


//채팅방 VO(방번호와 사용자 - 상대방의 정보)
//roomId로 채팅방을 구분, unReadCount를 통해 읽었는지 파악 
public class ChatRoom {
	private String room_id;       // 방 번호
    private String from_user;    // 사용자 이름
    private String from_pic;    // 사용자 사진
    private String to_user;    // 상대방 이름
    private String to_pic;    // 상대방 사진
    
	public ChatRoom() {
		super();
	}
	public ChatRoom(String room_id, String from_user, String from_pic, String to_user, String to_pic) {
		super();
		this.room_id = room_id;
		this.from_user = from_user;
		this.from_pic = from_pic;
		this.to_user = to_user;
		this.to_pic = to_pic;
	}

	public String getRoom_id() {
		return room_id;
	}

	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}

	public String getFrom_user() {
		return from_user;
	}

	public void setFrom_user(String from_user) {
		this.from_user = from_user;
	}

	public String getFrom_pic() {
		return from_pic;
	}

	public void setFrom_pic(String from_pic) {
		this.from_pic = from_pic;
	}

	public String getTo_user() {
		return to_user;
	}

	public void setTo_user(String to_user) {
		this.to_user = to_user;
	}

	public String getTo_pic() {
		return to_pic;
	}

	public void setTo_pic(String to_pic) {
		this.to_pic = to_pic;
	}
}
