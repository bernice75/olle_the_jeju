package com.olle.dto.member;

public class MemberDto {
	private String user_id;	// 아이디
	private String user_pw;	// 비밀번호
	private String user_name;	// 이름
	private int user_age;	// 나이
	private String user_addr;	// 주소
	private String user_addrdetail;	// 주소
	private String user_phone;	// 전화번호
	private String user_email;	// 이메일
	private String user_member;	// 가입구분(개인, 사업자)
	private String user_status;	// 탈퇴여부(N)
	private int user_warning;	// 경고 수(누적 5회 이상시 강퇴)
	private String user_regdate;	// 가입일
	private String user_secdate;	// 탈퇴일
	private String user_img;		// 프로필이미지
	private String user_nick;	// 닉네임
	
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberDto(String user_id, String user_pw, String user_name, int user_age, String user_addr,
			String user_addrdetail, String user_phone, String user_email, String user_member, String user_status,
			int user_warning, String user_regdate, String user_secdate, String user_img, String user_nick) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_age = user_age;
		this.user_addr = user_addr;
		this.user_addrdetail = user_addrdetail;
		this.user_phone = user_phone;
		this.user_email = user_email;
		this.user_member = user_member;
		this.user_status = user_status;
		this.user_warning = user_warning;
		this.user_regdate = user_regdate;
		this.user_secdate = user_secdate;
		this.user_img = user_img;
		this.user_nick = user_nick;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getUser_age() {
		return user_age;
	}

	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}

	public String getUser_addr() {
		return user_addr;
	}

	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}

	public String getUser_addrdetail() {
		return user_addrdetail;
	}

	public void setUser_addrdetail(String user_addrdetail) {
		this.user_addrdetail = user_addrdetail;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_member() {
		return user_member;
	}

	public void setUser_member(String user_member) {
		this.user_member = user_member;
	}

	public String getUser_status() {
		return user_status;
	}

	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}

	public int getUser_warning() {
		return user_warning;
	}

	public void setUser_warning(int user_warning) {
		this.user_warning = user_warning;
	}

	public String getUser_regdate() {
		return user_regdate;
	}

	public void setUser_regdate(String user_regdate) {
		this.user_regdate = user_regdate;
	}

	public String getUser_secdate() {
		return user_secdate;
	}

	public void setUser_secdate(String user_secdate) {
		this.user_secdate = user_secdate;
	}

	public String getUser_img() {
		return user_img;
	}

	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}

	public String getUser_nick() {
		return user_nick;
	}

	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	
	
	
}
