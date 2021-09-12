package com.olle.dto.member;

public class MemberDto {
	private String userId;	// 아이디
	private String userPw;	// 비밀번호
	private String userName;	// 이름
	private int userAge;	// 나이
	private String userAddr;	// 주소
	private String userAddrdetail;	// 주소
	private String userPhone;	// 전화번호
	private String userEmail;	// 이메일
	private String userMember;	// 가입구분(개인, 사업자)
	private String userStatus;	// 탈퇴여부(N)
	private int userWarning;	// 경고 수(누적 5회 이상시 강퇴)
	private String userRegdate;	// 가입일
	private String userSecDate;	// 탈퇴일
	private String userImg;		// 프로필이미지
	private String userNick;	// 닉네임
	
	public MemberDto() {
		super();
	}
	
	public MemberDto(String userId, String userPw, String userName, int userAge, String userAddr, String userAddrdetail,
			String userPhone, String userEmail, String userMember, String userStatus, int userWarning,
			String userRegdate, String userSecDate, String userImg, String userNick) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userAge = userAge;
		this.userAddr = userAddr;
		this.userAddrdetail = userAddrdetail;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userMember = userMember;
		this.userStatus = userStatus;
		this.userWarning = userWarning;
		this.userRegdate = userRegdate;
		this.userSecDate = userSecDate;
		this.userImg = userImg;
		this.userNick = userNick;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getUserAddrdetail() {
		return userAddrdetail;
	}
	public void setUserAddrdetail(String userAddrdetail) {
		this.userAddrdetail = userAddrdetail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserMember() {
		return userMember;
	}
	public void setUserMember(String userMember) {
		this.userMember = userMember;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public int getUserWarning() {
		return userWarning;
	}
	public void setUserWarning(int userWarning) {
		this.userWarning = userWarning;
	}
	public String getUserRegdate() {
		return userRegdate;
	}
	public void setUserRegdate(String userRegdate) {
		this.userRegdate = userRegdate;
	}
	public String getUserSecDate() {
		return userSecDate;
	}
	public void setUserSecDate(String userSecDate) {
		this.userSecDate = userSecDate;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	@Override
	public String toString() {
		return "MemberDto [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userAge=" + userAge
				+ ", userAddr=" + userAddr + ", userAddrdetail=" + userAddrdetail + ", userPhone=" + userPhone
				+ ", userEmail=" + userEmail + ", userMember=" + userMember + ", userStatus=" + userStatus
				+ ", userWarning=" + userWarning + ", userRegdate=" + userRegdate + ", userSecDate=" + userSecDate
				+ ", userImg=" + userImg + ", userNick=" + userNick + "]";
	}
	
	
}
