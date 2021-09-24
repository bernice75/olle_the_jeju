package com.olle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olle.biz.member.MemberBiz;
//import com.olle.dto.etc.ChatSession;
import com.olle.dto.member.MemberDto;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

	@Autowired
	private MemberBiz memberBiz;
	
	//회원가입
	@RequestMapping(value="userInsert.do", method=RequestMethod.POST)
	@ResponseBody
	public String userInsert(String user_id, String user_pw, String user_name, int user_age, String user_addr,
			String user_addrdetail, String user_phone, String user_email, String user_member, String user_nick) {
		
		MemberDto dto = new MemberDto();
		dto.setUser_id(user_id);
		dto.setUser_pw(user_pw);
		dto.setUser_name(user_name);
		dto.setUser_age(user_age);
		dto.setUser_addr(user_addr);
		dto.setUser_addrdetail(user_addrdetail);
		dto.setUser_phone(user_phone);
		dto.setUser_email(user_email);
		dto.setUser_member(user_member);
		dto.setUser_nick(user_nick);
		
		memberBiz.userInsert(dto);	// 회원 정보를 저장
		
		return "loginForm.do";
	}
	
	//로그인
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	@ResponseBody
	public String login(String user_id, String user_pw, HttpServletRequest request, HttpSession session) throws IOException {
		String res = memberBiz.login(user_id, user_pw);

		if(res == null || res == "") {
			session.setAttribute("loginChk", false);
		} else {
			MemberDto user = memberBiz.selectUser(user_id);
			if(user.getUser_status().equals("Y")) {
				res = "status";
				session.setAttribute("loginChk", false);
			} else {
				session.setAttribute("loginChk", true);
		        session.setAttribute("user_id", user_id);
			}
		}
		
		return res;
	}
	
	@RequestMapping(value = "findId.do", method = RequestMethod.POST)
	@ResponseBody
	public String findId(String user_email) {
		String res = null;
		String user_id = memberBiz.findId(user_email);
		if(user_id == "" || user_id == null) {
			res = null;
		} else {
			//메일 서버 생성
			String host = "smtp.naver.com";
			final String user = ""; // 자신의 네이버 계정('@naver.com'은 적지 말 것)
			final String password = "";// 자신의 네이버 패스워드
			int port = 465;
			// 메일 받을 주소
			System.out.println("user_email: " + user_email);
			
			// SMTP 서버 정보를 설정
			Properties props = System.getProperties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", port);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.ssl.trust", host);
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.debug", "true");
			
			Session e_session = Session.getDefaultInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password);
				}
			});
			
			// email 전송
			try {
				MimeMessage msg = new MimeMessage(e_session);
				msg.setFrom(new InternetAddress(user + "@naver.com", "OLLE THE JEJU"));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(user_email));

				// 메일 제목
				msg.setSubject("안녕하세요.  OLLE THE JEJU 인증 메일입니다.");
				// 메일 내용
				msg.setText("회원님의 id는 " + user_id + "입니다.");

				Transport.send(msg);
				res = "success";
				System.out.println("이메일 전송 완료");

			} catch (Exception e) {
				res = "error";
				e.printStackTrace();
			}
		}
		return res;
	}
	
	@RequestMapping(value = "findPw.do", method = RequestMethod.POST)
	@ResponseBody
	public String findPw(String user_id, String user_email) {
		String res = null;
		String user_pw = memberBiz.findPw(user_id);
		if(user_pw == "" || user_pw == null) {
			res = null;
		} else {
			//메일 서버 생성
			String host = "smtp.naver.com";
			final String user = ""; // 자신의 네이버 계정('@naver.com'은 적지 말 것)
			final String password = "";// 자신의 네이버 패스워드
			int port = 465;
			// 메일 받을 주소
			System.out.println("user_email: " + user_email);
			
			// SMTP 서버 정보를 설정
			Properties props = System.getProperties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", port);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.ssl.trust", host);
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.debug", "true");
			
			Session e_session = Session.getDefaultInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password);
				}
			});
			
			// email 전송
			try {
				MimeMessage msg = new MimeMessage(e_session);
				msg.setFrom(new InternetAddress(user + "@naver.com", "OLLE THE JEJU"));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(user_email));

				// 메일 제목
				msg.setSubject("안녕하세요.  OLLE THE JEJU 인증 메일입니다.");
				// 메일 내용
				msg.setText("회원님의 pw는 " + user_pw + "입니다.");

				Transport.send(msg);
				res = "success";
				System.out.println("이메일 전송 완료");

			} catch (Exception e) {
				res = "error";
				e.printStackTrace();
			}
		}
		return res;
	}
	
	//로그아웃
	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest req) {
		String user_id = req.getParameter("user_id");
		String naverChk = (String) session.getAttribute("naver");
		
		if(naverChk == null || naverChk == "") {
			if(user_id != null || user_id != "") {
				session.setAttribute("user_id", null);
				session.setAttribute("loginChk", false);
			}
		} else {
			return "redirect:http://nid.naver.com/nidlogin.logout";
		}
		
		return "redirect:home.do";
	}
	
	//아이디 중복체크
	@RequestMapping(value="idChk.do", method=RequestMethod.POST)
	@ResponseBody
	public int idChk(String user_id) {
		int res = 0;
		
		res = memberBiz.idChk(user_id);
		
		if(res > 0) {
			System.out.println("controller - 존재");
		} else {
			System.out.println("controller - 미존재");
		}
		
		return res;
	}
	
	//닉네임 중복체크
	@RequestMapping(value="nickChk.do", method=RequestMethod.POST)
	@ResponseBody
	public int nickChk(String user_nick) {
		int res = 0;
		res = memberBiz.nickChk(user_nick);
		
		if(res > 0) {
			System.out.println("controller - 존재");
		} else {
			System.out.println("controller - 미존재");
		}
		
		return res;
	}
}
