package com.olle.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import com.olle.biz.etc.ImageBiz;
import com.olle.biz.jejusituation.JejuBiz;
import com.olle.biz.jejusituation.menu.MenuBiz;
import com.olle.biz.member.MemberBiz;
import com.olle.dto.etc.ImgDto;
import com.olle.dto.jejusituation.CoronaDto;
import com.olle.dto.jejusituation.JejuDto;
import com.olle.dto.jejusituation.menu.MenuDto;
import com.olle.dto.member.MemberDto;

@Controller
public class JejusituationController {
	
	@Autowired
	private JejuBiz biz;
	@Autowired
	private MemberBiz memberBiz;
	@Autowired
	private ImageBiz imageBiz;
	@Autowired
	private MenuBiz menuBiz;
	
	private static Logger logger=LoggerFactory.getLogger(JejusituationController.class);
	
	
	@RequestMapping(value = "jejusituation_main.do", method = RequestMethod.GET)
	public String jejusituation_main() {
		return "page_jejusituation/jejusituation";
	}
	
	@RequestMapping(value = "/jejusituation_rest.do", method = RequestMethod.GET)
	public String jejusituation_detail() {
		return "page_jejusituation/jejusituation_rest";
	}
	
	@RequestMapping(value="/jejusituation_rest_detail.do")
	public String jejusituation_rest_detail() {
		return "page_jejusituation/jejusituation_rest_detail";
	}
	@RequestMapping(value="/jejusituation_rest_detail2.do")
	public String jejusituation_rest_detail2() {
		return "page_jejusituation/jejusituation_rest_detail2";
	}
	@RequestMapping(value="/jejusituation_rest_create.do")
	public String jejusituation_rest_create(Model model,HttpServletRequest request) {
		HttpSession session=request.getSession();
		String user_id="";
		MemberDto dto=new MemberDto();
		if(session.getAttribute("user_id")!=null) {
			user_id=(String)session.getAttribute("user_id");
			if(user_id!=null) {
				dto=memberBiz.selectUser(user_id);				
				model.addAttribute("user",dto);
			}
		}
		
		return "page_jejusituation/jejusituation_rest_create";
	}
	
	@RequestMapping(value="/saveCoronaData.do")
	public String jejusituation_save_data(Model model) {
		
		List<CoronaDto> list=biz.searchData();
		
		model.addAttribute("list", list);
		logger.info("corona info: {}",list);
		
		return "page_jejusituation/test";
		
	}
	
	@RequestMapping(value="/jejuSituationValidUser.do")
	@ResponseBody
	public Map<String, Boolean> jejusituation_registerForm(HttpServletRequest request) {
		HttpSession session=request.getSession();
		Map<String, Boolean> msg=new HashMap<String,Boolean>();
		if(session.getAttribute("user_id")!=null) {
			String user_id=(String)session.getAttribute("user_id");
			MemberDto dto=memberBiz.selectUser(user_id);
			String grade="";
			if(dto!=null) {
				grade=dto.getUser_member();
			}
			logger.info("[jeju situation] user: {}",dto);
			if(grade.equals("사업자")) {
				msg.put("msg", true);
			}else{
				msg.put("msg", false);
			}
			
		}else {
			msg.put("msg", false);
		}
		
		return msg;
		
	}
	
	@RequestMapping(value="/registerStore.do")
	public String registerFoodStore(Model model,MultipartHttpServletRequest request) throws IOException {
		MultipartFile multipartFile=request.getFile("file");
		String writer=request.getParameter("writer");
		//JejuDto
		//게시글 최대 번호 가져오기
		int boardNo=biz.getMaxJejuDtoNum();
		//이미지 최대 번호 가져오기
		int imageNo=imageBiz.selectMaxPK();
		//메뉴 최대 번호 가져오기
		long menuNo=0;
		
		JejuDto jeju=new JejuDto();
		String[] arr=request.getParameter("time").split("~");
		jeju.setSitu_num(boardNo);
		jeju.setSitu_name(request.getParameter("name"));
		jeju.setSitu_phone(request.getParameter("phone"));
		jeju.setSitu_addr(request.getParameter("address"));
		jeju.setSitu_writer(writer);
		LocalDateTime date=LocalDateTime.now();
		String cur=date.toString();
		jeju.setSitu_regDate(cur);
		jeju.setSitu_open_time(arr[0]);
		jeju.setSitu_close_time(arr[1]);
		jeju.setSitu_home(request.getParameter("homepage"));
		
		String[] tempMenu=request.getParameterValues("menu");
		List<MenuDto> menuList=new ArrayList<MenuDto>();
		logger.info("menu raw: "+Arrays.toString(tempMenu));
		menuNo=menuBiz.maxMenuPerStore(boardNo);
		for(int i=0;i<tempMenu.length;i++) {
			logger.info("menu: ["+tempMenu[i]+"]");
			logger.info("is null menu: {}",tempMenu[i]==null);
			logger.info("is null menu: {}",tempMenu[i].equals(" "));
			logger.info("is null menu: {}",tempMenu[i].equals(""));
			if(!tempMenu[i].equals("")) {
				MenuDto dto=new MenuDto();
				dto.setMenu_id(menuNo+1+i);
				dto.setStore_id((long) boardNo);
				dto.setMenu(tempMenu[i]);
				menuList.add(dto);
			}
		}
		int tot=0;
		//파일업로드 준비
		if(!multipartFile.isEmpty()) {
			ImgDto img=new ImgDto();
			ServletContext ctx=request.getSession().getServletContext();
			String uploadPath="/upload/jejusitu";
			//String uploadPath="D:/final/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/OlleTheJeju/resources/olle_img/jejusituation";
			logger.info("uploadpath: {}",uploadPath);
			String fileName=multipartFile.getOriginalFilename();
			String full=WebUtils.getRealPath(ctx, uploadPath);
			
			File folder=new File(full);
			
			if(!folder.exists()) {
				folder.mkdirs();
			}
			int groupNoMax=imageBiz.selectMaxGroupId(boardNo);
			
			img.setImg_num(imageNo);
			img.setImg_title(full+"/"+fileName);
			img.setBoard_num(4);
			img.setTable_num(boardNo);
			img.setGroup_num((groupNoMax+1));//이것도 최대 그룹값 가져와야 함
			tot=saveStore(jeju,img,menuList);
			
			File file=new File(full,fileName);
			
//			if(!file.exists()) {
//				file.createNewFile();
//			}else {
//				Writer writer1=new FileWriter(full+"/"+fileName,false);//overwrite
//			}
			//FileCopyUtils.copy(multipartFile.getBytes(), file);
			multipartFile.transferTo(file);
//			InputStream inputStream = multipartFile.getInputStream();
//			OutputStream outputStream=null;
//			
//			try {
//				outputStream=new FileOutputStream(file);
//				
//				int read=0;
//				byte[] bytes=new byte[(int)multipartFile.getSize()];
//				
//				while((read=inputStream.read())!=-1) {
//					outputStream.write(bytes,0,read);
//				}
//			}catch(Exception e) {
//				e.printStackTrace();
//			}finally {
//				try {
//					inputStream.close();
//					outputStream.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
		//아래 3개를 동시에 진행하도록 트랜잭션으로 관리	
			//이미지 테이블에 저장
//			int r1=imageBiz.saveStoreImg(img);
//			//메뉴 테이블에 저장
//			int r2=menuBiz.saveMenu(menuList);
//			//가게 저장
//			int r3=biz.saveStore(jeju);
//			
//			if(r1>0&&r2>0&&r3>0) {
//				tot=3;
//			}else {
//				tot=-1;
//			}
			
			logger.info("jejuDto: {}",jeju);
			logger.info("imgDto:{}",img);
			logger.info("menuList:{}",menuList);

		}

		return "redirect:jejusituation_main.do";
	}
	
	@Transactional
	public int saveStore(JejuDto jeju,ImgDto img,List<MenuDto> menuList) {
		int tot=0;
		int res1=biz.saveStore(jeju);
		int res2=imageBiz.saveStoreImg(img);
		int res3=menuBiz.saveMenu(menuList);
		
		if(res1>0&&res2>0&&res3>0) {
			tot=1;
		}else {
			tot=-1;
		}
		return tot;
	}
}
