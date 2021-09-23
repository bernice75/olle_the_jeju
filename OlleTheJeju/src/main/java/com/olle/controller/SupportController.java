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
import com.olle.biz.admin.ChatBiz;
import com.olle.biz.member.MemberBiz;
import com.olle.dto.etc.ChatMessage;
import com.olle.dto.member.MemberDto;

@Controller
public class SupportController {
	@Autowired
    ChatBiz chatBiz;
	
	
}
