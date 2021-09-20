package com.olle.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor implements HandlerInterceptor{
	private Logger logger = LoggerFactory.getLogger(Interceptor.class);
	
	
	
	//controller 실행 요청 전에 수행되는 메소드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("[interceptor] : preHandle");
		HttpSession session = request.getSession();
		
		//세션 더미 테스트
//		session.setAttribute("login", request);
		
		
		if(request.getSession().getAttribute("login") != null) {
			return true;
		}
		
		if(request.getSession().getAttribute("login") == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();	
			out.println("<script>alert('로그인이 필요합니다.'); location.href='loginForm.do';</script>");			 
			out.flush();

			return false;
		}
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("[interceptor] : postHandle ");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("[interceptor] : afterCompletion");
	}

}
