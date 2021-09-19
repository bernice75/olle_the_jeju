package com.olle.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.olle.biz.etc.ImageBiz;
import com.olle.biz.jejusituation.JejuBiz;
import com.olle.biz.jejusituation.menu.MenuBiz;
import com.olle.biz.member.MemberBiz;
import com.olle.biz.pagination.jejusit.JejuPageBiz;
import com.olle.dto.etc.ImgDto;
import com.olle.dto.jejusituation.CoronaDto;
import com.olle.dto.jejusituation.JejuDto;
import com.olle.dto.jejusituation.menu.MenuDto;
import com.olle.dto.member.MemberDto;
import com.olle.dto.pagination.jejusitu.JejuPage;
import com.olle.mapper.biz.MenuBatchService;

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
	@Autowired
	private JejuPageBiz pBiz;
	@Autowired
	private MenuBatchService mBatchService;

	
	private static Logger logger=LoggerFactory.getLogger(JejusituationController.class);
	
	
	@RequestMapping(value = "jejusituation_main.do", method = RequestMethod.GET)
	public String jejusituation_main() {
		return "page_jejusituation/jejusituation";
	}
	/*
	 * <-1 2 3..->이렇게 페이지를 보여줄 것인데, 이전 페이지 혹은 이후 페이지가 존재하는지 판단해줄 필요가 있음
	 * 페이지값이 1이면 이전버튼을 보이지 않게 하고
	 * >버튼을 누르면 5페이지가 넘어가서 <-6 7 8 9 10->이런식으로 보이도록 하기
	 * 즉 << >>개념으로 접근할것
	 * 리스트버튼은 5개씩 보일것이라 5개씩 보일때 그 단위체를 갖고 있을 필요도 있음
	 * */
	@RequestMapping(value = "/jejusituation_rest.do", method = RequestMethod.GET)
	public String jejusituation_rest(Model model ,@RequestParam(defaultValue="1") int page ) {
		JejuPage pageList=new JejuPage();
		pageList.setCurPage(page); //현재 페이지
		pageList.setElementsPerPage(6); //한 페이지당 아이템수
		int totPage=pBiz.getTotalPages(6); //총 페이지수 계산
		int totRows=pBiz.getTotalElements();
		int listBtnUnit=(int)Math.round((double)totPage/3);//리스트 유닛
		pageList.setTotalPages(totPage); //총 페이지수
		pageList.setTotalElements(totRows); //총 행 개수
		pageList.setListBtnUnit(listBtnUnit);
		
		int[] indexes=pBiz.getStartAndEndIdx(6, page);//시작 인덱스, 끝인덱스 가져오기
		
		pageList.setStartIdx(indexes[0]); //시작 인덱스
		pageList.setEndIdx(indexes[1]); //끝 인덱스
		pageList.setCurPage(page);
		
		int unit=(int)Math.ceil((double)page/5);
		int finUnit=(int)Math.ceil((double)totPage/5);

		
		logger.info("current page: {}, unit: {}",page,unit);
		Boolean pFlag=false;
		Boolean nFlag=false;
		//1~5같이 1인 경우는 이전페이지는 없음
		if(unit==1) {
			pFlag=false;
			nFlag=true;
		}else if(unit>=finUnit) {
			//마지막 유닛은 다음페이지가 없음
			pFlag=true;
			nFlag=false;
		}else if(unit<finUnit){
			//그 외에 앞으로 단위체가 더 많으면 이전, 이후 유닛페이지가 있음
			pFlag=true;
			nFlag=true;
		}
		pageList.setPrevUnit(pFlag);
		pageList.setNextUnit(nFlag);
		model.addAttribute("unit",unit);
		model.addAttribute("finUnit",finUnit);
		model.addAttribute("prevFlag", pFlag);
		model.addAttribute("nextFlag",nFlag);
		logger.info("finUnit:{}",finUnit);
		
		logger.info("start:{}",indexes[0]);
		logger.info("end:{}",indexes[1]);
		logger.info("prevFlag:{}",pFlag);
		logger.info("nextFlag:{}",nFlag);
		//가게정보
		List<JejuDto> jeju=pBiz.getStoreElementsPerPage(indexes[0], indexes[1], page);
		//가게들에 대한 메뉴정보
		int mStartIdx=36*page-35;
		logger.info("menuList startIdx: {}",mStartIdx);
	//	List<MenuDto> menuList=menuBiz.getPageMenuList(mStartIdx, page);
		//이미지에 대한 정보
		List<ImgDto> imgList=pBiz.getImgElementsPerPage(indexes[0], indexes[1], page);
		
		pageList.setJeju(jeju);
		pageList.setImg(imgList);
		
		//유닛값에 따른 시작버튼 값
		int unitStartBtn=5*unit-4;//1,6,...
		pageList.setListBtnStartIdx(unitStartBtn);
		logger.info("pagination meta info: {}",pageList);
		logger.info("list unit start idx(btn):"+unitStartBtn);
		model.addAttribute("paginationMetaInfo",pageList );
		
		logger.info("defaultPage-jeju:{}",jeju);
		logger.info("jejusize: {}",jeju.size());
	//	logger.info("defaultPage-menuList:{}",menuList);
		logger.info("defaultPage-img:{}",imgList);
		//model에 6개를 뽑아서 전달하기
		//그런데 그 전에 몇 개가 그 페이지에 들어가는지 확인해야 할 것
		int size1=jeju.size();
		int size2=imgList.size();
		int size=Math.min(size1, size2);//이미지가 삽입되지 않은 경우의 수도 존재
		
		
		String[] div= {"one","two","three","four","five","six"};
		
		for(int i=0;i<size;i++) {
			model.addAttribute(div[i]+"Jeju",jeju.get(i));
			//model.addAttribute(div[i]+"Menu",menuList.get(i));->전체조회에서는 메뉴를 뿌려줄 필요는 없을 것이지만
			//나중에 상세조회에서는 페이지에 대해서 6등분해서 소분해줄 필요는 있을 것
			model.addAttribute(div[i]+"Img", imgList.get(i));
		}
		//총 페이지 정보도 보낼 것
		model.addAttribute("totPages",totPage);
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
		
		String writer=request.getParameter("writer");
		//JejuDto
		//게시글 최대 번호 가져오기
		int boardNo=0;
		//이미지 그룹별 최대 번호 가져오기
		int groupNo=0;
		//메뉴 최대 번호 가져오기
		int menuNo=0;

		JejuDto jeju=new JejuDto();
		String[] arr=request.getParameter("time").split("~");
	//	jeju.setSitu_num(boardNo);
		jeju.setSitu_name(request.getParameter("company"));
		jeju.setSitu_phone(request.getParameter("phone"));
		jeju.setSitu_addr(request.getParameter("address"));
		jeju.setSitu_writer(writer);

		jeju.setSitu_open_time(arr[0]);
		jeju.setSitu_close_time(arr[1]);
		jeju.setSitu_gubun(request.getParameter("gubun"));
		
		
		//제주 정보 저장
		int jRes=biz.saveStore(jeju);//여기에 최댓값이 담길것
		logger.info("jeju save result jRes:{}", jRes);
		//메뉴 저장
		String[] tempMenu=request.getParameterValues("menu");
		//가격 저장
		String[] tempPrice=request.getParameterValues("price");
		//메뉴가 비어있으면 리스트에 포함시키지 않기
		List<MenuDto> menuList=new ArrayList<MenuDto>();
		//menu pk
		menuNo=menuBiz.maxMenuPerStore(boardNo);
		//모두 비워져 있는 상태/혹은/tempMenu나  길이가 맞지 않으면 최소 길이에 맞게 없음, 0넣기
		int mSize=tempMenu.length;
		int pSize=tempPrice.length;
		int size=0;
		
		if(mSize<=pSize) {
			size=mSize;
		}else {
			size=pSize;
		}
		
		
		for(int i=0; i<size;i++) {
			String chk=tempMenu[i];
			String pr=tempPrice[i];
			MenuDto dto=new MenuDto();
			dto.setStore_id(jRes);
			if(!chk.equals("") && !chk.equals("")) {
				dto.setMenu_id(menuNo);
				dto.setMenu(chk);
				dto.setPrice(Integer.valueOf(pr));
				//menuNo++;
			}else {
				dto.setMenu_id(menuNo);
				dto.setMenu("없음");
				dto.setPrice(1);//Wrapper->null로 0인식가능
			}
			menuNo++;
			menuList.add(dto);
		}
		//menu list 저장
		logger.info("menuList: {}",menuList);
		int menuRes=mBatchService.batchInsert(menuList);
		logger.info("menu save result:{}",menuRes);
		
		
		
		
		//이미지 저장
		MultipartFile multipartFile=request.getFile("file");
		//파일 이름 가져오기
		String originName=multipartFile.getOriginalFilename();
		//루트 경로
		String root=request.getSession().getServletContext().getRealPath("/");
		logger.info("contex path:{}",root);
		String appPath="\\resources\\img\\jejusitu";
		
		String full=root+appPath;
		
		//폴더 위치잡기
		File folder=new File(full);
		
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
		File toSave=new File(full,originName);
		//파일 저장
		//multipartFile.transferTo(toSave);
		if(!toSave.exists()) {
			toSave.createNewFile();
		}
		InputStream input=multipartFile.getInputStream();
		OutputStream output=null;
		if(!multipartFile.isEmpty()) {
			output=new FileOutputStream(toSave);
			
			byte[] bArr=new byte[(int)multipartFile.getSize()];
			int read=0;
			
			while((read=input.read(bArr))!=-1) {
				output.write(bArr, 0, read);
			}
		}
		
		input.close();
		output.close();
		
		if(!toSave.exists()) {
			toSave.mkdirs();
		}
		
		ImgDto dto=new ImgDto();
		groupNo=imageBiz.selectMaxGroupId(4);
		dto.setBoard_num(4);
		dto.setGroup_num(groupNo);
		dto.setTable_num(jRes);
		dto.setImg_title(originName);
		
		int saveRes=imageBiz.saveStoreImg(dto);
		
		logger.info("saved image?: {}",saveRes);

		return "redirect:jejusituation_main.do";
	}
	
//	@Transactional
//	public int saveStore(JejuDto jeju,ImgDto img,HashMap<String, Object> map) {
//		int tot=0;
//		int res1=biz.saveStore(jeju);
//		int res2=imageBiz.saveStoreImg(img);
//		int res3=menuBiz.saveMenu(map);
//		
//		
//		if(res1>0&&res2>0&&res3>0) {
//			tot=1;
//		}else {
//			tot=-1;
//		}
//		return tot;
//	}
}
