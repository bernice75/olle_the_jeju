package com.olle.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.olle.biz.customplan.CustomBiz;
import com.olle.biz.etc.ImgBiz;
import com.olle.biz.member.NaverLoginBO;
import com.olle.dto.customplan.CustomDto;
import com.olle.dto.etc.ImgDto;

@Controller
public class HomeController {
	
	@Autowired
	private CustomBiz cusBiz;
	
	@Autowired
	private ImgBiz imgBiz;
	
	// NaverLoginBO
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;
	
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO){
		this.naverLoginBO = naverLoginBO;
	}
	
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest req, HttpSession session) {
		List<Integer> planNumList = cusBiz.topten();
		List<CustomDto> titleList = new ArrayList<CustomDto>();
		
		for(int i = 0; i < planNumList.size(); i++) {
			titleList.add(i, cusBiz.selectTopten(planNumList.get(i)));
		}
		model.addAttribute("titleList", titleList);
		
		List<ImgDto> imgList = imgBiz.selectList(3);
		List<ImgDto> nameList = new ArrayList<ImgDto>();
		for(ImgDto idx : imgList) {
			for(Integer pidx : planNumList) {
				if(pidx == idx.getTable_num()) {
					if(idx.getGroup_num() == 3) {
						nameList.add(idx);
					}
				}
			}
		}
		model.addAttribute("nameList", nameList);
		
		String user_id = req.getParameter("user_id");
		
		if(user_id == null || user_id == "") {
			session.setAttribute("idChk", false);
		} else {
			session.setAttribute("idChk", true);
			session.setAttribute("user_id", user_id);
		}
		return "home";
	}
	
	@RequestMapping(value = "loginForm.do", method = RequestMethod.GET)
	public String loginForm(HttpSession session, Model model) {
		// 네이버 로그인
		// Naver ID로 인증 URL을 생성하기 위하여 naverLoginBO class의 getAuthorizationUrl method 호출 
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		
		//결론 넘어가는 파라미터 종류 : response_type, client_id, redirect_uri, state
		System.out.println("네이버:" + naverAuthUrl);
		
		// Naver 
		model.addAttribute("url", naverAuthUrl);
		return "login";
	}
	
	// Naver Login 성공시 callback호출 method
	@RequestMapping(value = "callback.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws IOException {
		System.out.println("여기는 callback");
		OAuth2AccessToken oauthToken;
        oauthToken = naverLoginBO.getAccessToken(session, code, state);
        // Login 사용자 정보를 읽어온다.
        apiResult = naverLoginBO.getUserProfile(oauthToken);
        model.addAttribute("result", apiResult);
        session.setAttribute("naver", "naver");
        // Naver Login 성공 페이지 View 호출
        return "redirect:home.do";
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
