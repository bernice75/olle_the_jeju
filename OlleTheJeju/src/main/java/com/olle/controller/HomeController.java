package com.olle.controller;

import java.util.Properties;
import java.util.Random;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "loginForm.do", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "joinForm.do", method = RequestMethod.GET)
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "emailChk.do", method = RequestMethod.POST)
	@ResponseBody
	public String emailChk(String user_email) {
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
		
		// 인증 번호 생성기 시작
		StringBuffer temp = new StringBuffer();
		Random rnd = new Random();
		for (int i = 0; i < 10; i++) {
			int rIndex = rnd.nextInt(3);
			switch (rIndex) {
			case 0:
				// a-z
				temp.append((char) ((int) (rnd.nextInt(26)) + 97));
				break;
			case 1:
				// A-Z
				temp.append((char) ((int) (rnd.nextInt(26)) + 65));
				break;
			case 2:
				// 0-9
				temp.append((rnd.nextInt(10)));
				break;
			}
		}
		
		String AuthenticationKey = temp.toString();
		System.out.println("생성된 인증번호 : " + AuthenticationKey);
		//인증번호 생성기 끝
		
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
			msg.setText("인증 번호는 " + temp + "입니다.");

			Transport.send(msg);
			System.out.println("이메일 전송 완료");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return AuthenticationKey;
	}
}
