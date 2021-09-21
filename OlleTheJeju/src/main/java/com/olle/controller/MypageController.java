package com.olle.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.olle.biz.mypage.MypageBiz;
import com.olle.dto.customplan.CustomDto;
import com.olle.dto.etc.DibDto;
import com.olle.dto.etc.HashtagDto;
import com.olle.dto.member.Criteria;
import com.olle.dto.member.MemberDto;
import com.olle.dto.member.PageMaker;

@Controller
public class MypageController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	HttpSession session;
	
	@Autowired
	private MypageBiz biz;
	
	//회원정보 조회 - 작업완료 
	@RequestMapping(value = "mypage_main.do", method = RequestMethod.GET)
	public String mypage_main(Model model, String user_id) {
		logger.info("mypage_main");
		
		model.addAttribute("dto", biz.mypageInfo(user_id));
		return "page_mypage/mypage";
	}
	
	//회원정보 수정 - 작업완료
	@RequestMapping(value="userUpdate.do", method=RequestMethod.POST)
	@ResponseBody
	public int userUpdate(HttpSession session, MemberDto dto) {
		logger.info("userUpdate");
		
		int res = 0;
		dto.setUser_id((String)session.getAttribute("user_id"));
		
		try {
			res = biz.userUpdate(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	//회원정보 수정 (프로필 이미지 등록 및 변경) - 작업중
	@RequestMapping(value="profileUpdate.do", method=RequestMethod.POST)
	public String profileUpdate(HttpServletRequest req, 
			@RequestParam("profileimg") MultipartFile profileimg) throws IOException {
		
		logger.info("profileUpdate");
		
		//4. 이미지 관련 저장
		String path = req.getSession().getServletContext().getRealPath("/") + "/resources/mypage";

		//db에 저장할 이름
		String fileName = profileimg.getOriginalFilename();

		//폴더에 이미지 저장
		InputStream input = null;
		OutputStream out = null;

		input = profileimg.getInputStream();
		File store = new File(path);
		if(!store.exists()) {
		   try {
		        //디렉토리 생성
		        store.mkdirs();
		        System.out.println("디렉토리 생성 성공");
		    } catch (Exception e) {
		        System.out.println("디렉토리 생성 실패");
		        e.printStackTrace();
		   }
		}

		File newFile = new File(path + "/" + fileName);

		//해당 경로 안에 해당하는 파일이 존재하는지 여부
		if(!newFile.exists()) {
		    //새로 생성
		    newFile.createNewFile();
		}

		out = new FileOutputStream(newFile);
		int read = 0;
		byte[] b = new byte[(int)profileimg.getSize()];
		while((read = input.read(b)) != -1) {
		     //파일 저장
		     out.write(b, 0, read);
		}
		
		return "page_mypage/mypage";
	}
		
	//회원정보 수정 비밀번호 체크
	/*
	 * @RequestMapping(value="info_update.do", method=RequestMethod.GET) public
	 * String mypage_updateChk(@ModelAttribute MemberDto dto, Model model) { boolean
	 * result = biz.checkPw(dto.getUser_id(), dto.getUser_pw());
	 * 
	 * if(result) { biz.mypageInfoUpdate(dto); //비밀번호 일치 하다면 수정 처리, 리턴으로 페이지 이동은
	 * 없는것으로 return ""; }else { MemberDto dto2 = biz.mypageInfo(dto.getUser_id());
	 * model.addAttribute("dto", dto); model.addAttribute("message", "비밀번호 불일치");
	 * //비밀번호 불일치시 메시지창 띄우고 페이지 이동 없음 return ""; } }
	 */
	
	//회원 강제 탈퇴 - 보류중 / 작업해야함
	@RequestMapping(value="", method= RequestMethod.POST) 
	public int mypageLeave(String user_id, int user_warning, Model model) {
		logger.info("myapgeLeave");
	 
		int res = 0;
	 
		return 0; 
	}
	
	//회원 자진 탈퇴 (삭제) - 작업완료 
	@RequestMapping(value="deleteUser.do", method= RequestMethod.POST)
	@ResponseBody
	public int deleteUser(String user_id, String user_pw, Model model, HttpServletResponse resp) throws IOException {
		logger.info("deleteUser");
		int res = 0;
		//비밀번호 체크
		boolean result = biz.checkPw(user_id, user_pw);
		
		//비밀번호가 맞으면 리턴
		if(result) {
			res = biz.deleteUser(user_id, user_pw);
		}
		return res;
	}
	
	//내가쓴 게시글 조회 - 작업완료
	@RequestMapping(value = "mypage_plan.do", method = RequestMethod.GET)
	public String myWriteList(Model model, String plan_writer, Criteria cri) {
		logger.info("mypage_plan, plan_writer: " + plan_writer);
		
		System.out.println("확인");
		System.out.println("getPage:::"+cri.getPage());
		System.out.println("getRowEnd:::"+cri.getRowEnd());
		System.out.println("getRowStart:::"+cri.getRowStart());
		
		//게시글 정보 조회
		List<CustomDto> list = new ArrayList<CustomDto>();
		list = biz.myWriteList(plan_writer, cri);
		System.out.println("게시물 개수 : " + list.size());
		
		//해시태그 조회
		CustomDto dto = new CustomDto();
		int plan_num = 0;
		List<HashtagDto> hash = new ArrayList<HashtagDto>();
		for(int i = 0; i < list.size(); i++) {
			dto.setPlan_num(list.get(i).getPlan_num());
			plan_num = dto.getPlan_num();
			hash.add(i, biz.hashList(plan_num));
		}
		//해시태그 형식은 해시1, 해시2 이런 방식이므로 대표 1개의 해시태그만 끊어오려면 split을 사용
		List<HashtagDto> hashList = new ArrayList<HashtagDto>();
		for(int i = 0; i < hash.size(); i++) {
			HashtagDto hashTag = new HashtagDto();
			hashTag.setHash_num(hash.get(i).getHash_num());
			hashTag.setBoard_num(hash.get(i).getBoard_num());
			hashTag.setTable_num(hash.get(i).getTable_num());
			hashTag.setHash_content(hash.get(i).getHash_content().split(",")[0]);
			hashList.add(i, hashTag);
		}
		//찜 조회
		List<List<DibDto>> dibList = new ArrayList<List<DibDto>>();
		for(int i = 0; i < list.size(); i++) {
			dto.setPlan_num(list.get(i).getPlan_num());
			plan_num = dto.getPlan_num();
			List<DibDto> dib = biz.myDibList(plan_num);
			dibList.add(i, dib);
		}
		
		
		for(int i = 0; i < dibList.size(); i++) {
			for(int j = 0; j < dibList.get(i).size(); j++) {
				System.out.println(dibList.get(i).get(j).getTable_num());
			}
		}
		
		//게시글 정보
		if(list.size() > 0) {
			model.addAttribute("list", list);
			//해시태그
			if(hashList.size() > 0) {
				model.addAttribute("tag", hashList);
			}else {
				model.addAttribute("tag", null);
			}
		} else {
			model.addAttribute("list", null);
		}
		
		//찜 정보
		if(dibList.size() > 0) {
			model.addAttribute("zzim", dibList);
		}else {
			model.addAttribute("zzim", null);
		}
		
		//페이징
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(biz.listCount());
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "page_mypage/mypage_plan";
	}
		
	
	//문의하기 (채팅 기능) - 보류중 / 작업해해야됨
	@RequestMapping(value = "mypage_inquire.do", method = RequestMethod.GET)
	public String mypage_inquire() {
		return "page_mypage/mypage_inquire";
	}
	
	//신고 확인 기능 - 수정해야함
	@RequestMapping(value = "mypage_warn.do", method = RequestMethod.GET)
	public String mypage_warn(String user_id, Model model) {
		logger.info("mypage_main");

		model.addAttribute("dto", biz.mypageWarn(user_id));
		
		return "page_mypage/mypage_warn";
	}
}