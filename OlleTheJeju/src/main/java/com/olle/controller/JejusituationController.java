package com.olle.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.olle.biz.etc.BookingBiz;
import com.olle.biz.etc.ImgBiz;
import com.olle.biz.jejusituation.CoronaBiz;
import com.olle.biz.jejusituation.JejuBiz;
import com.olle.biz.jejusituation.menu.MenuBiz;
import com.olle.biz.member.MemberBiz;
import com.olle.biz.pagination.JejuPageBiz;
import com.olle.dto.etc.BookingDto;
import com.olle.dto.etc.ImgDto;
import com.olle.dto.jejusituation.JejuDto;
import com.olle.dto.jejusituation.MenuDto;
import com.olle.dto.jejusituation.ReservationRequest;
import com.olle.dto.member.MemberDto;
import com.olle.dto.pagination.JejuPage;
import com.olle.mapper.MenuBatchService;

@Controller
public class JejusituationController {
	
	@Autowired
	private JejuBiz biz;
	@Autowired
	private MemberBiz memberBiz;
	@Autowired
	private ImgBiz imageBiz;
	@Autowired
	private MenuBiz menuBiz;
	@Autowired
	private JejuPageBiz pBiz;
	@Autowired
	private MenuBatchService mBatchService;
	@Autowired
	private BookingBiz bookingBiz;
	@Autowired
	private CoronaBiz cBiz;

	
	private static Logger logger=LoggerFactory.getLogger(JejusituationController.class);
	
	
	@RequestMapping(value = "jejusituation_main.do")
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
		int listBtnUnit=(int)Math.round((double)totPage/5);//리스트 유닛
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
			if(finUnit==1) {
				pFlag=false;
				nFlag=false;
			}else {
				pFlag=false;
				nFlag=true;
			}

		}
		else if(unit==finUnit) {
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
	
	//구분조건에 따른 페이징 조회
	@RequestMapping(value="/jejusituation_search_gubun.do")
	public String jejusituation_search_gubun(Model model,@RequestParam(value="gubun") String gubun, @RequestParam(value="page",defaultValue="1") int page) {
		JejuPage pageList=new JejuPage();
		pageList.setCurPage(page); //현재 페이지
		pageList.setElementsPerPage(6); //한 페이지당 아이템수
		int totPage=pBiz.getTotalPagesByGubun(gubun, 6); //총 페이지수 계산
		int totRows=pBiz.getTotalElementsByGubun(gubun);
		int listBtnUnit=(int)Math.round((double)totPage/5);//리스트 유닛
		pageList.setTotalPages(totPage); //총 페이지수
		pageList.setTotalElements(totRows); //총 행 개수
		pageList.setListBtnUnit(listBtnUnit);
		
		int[] indexes=pBiz.getStartAndEndIdx(6, page);//시작 인덱스, 끝인덱스 가져오기
		
		pageList.setStartIdx(indexes[0]); //시작 인덱스
		pageList.setEndIdx(indexes[1]); //끝 인덱스
		pageList.setCurPage(page);
		
		int unit=(int)Math.ceil((double)page/5);
		int finUnit=(int)Math.ceil((double)totPage/5);

		
		logger.info("current page gubun: {}, unit: {}",page,unit);
		Boolean pFlag=false;
		Boolean nFlag=false;
		//1~5같이 1인 경우는 이전페이지는 없음
		if(unit==1) {
			if(finUnit==1) {
				pFlag=false;
				nFlag=false;
			}else {
				pFlag=false;
				nFlag=true;
			}

		}
		else if(unit==finUnit) {
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
		List<JejuDto> jeju=pBiz.getStoreElementsByGubun(gubun, indexes[0],indexes[1], page);
		//가게들에 대한 메뉴정보
		int mStartIdx=36*page-35;
		logger.info("menuList startIdx: {}",mStartIdx);
	//	List<MenuDto> menuList=menuBiz.getPageMenuList(mStartIdx, page);
		//이미지에 대한 정보
		List<ImgDto> imgList=pBiz.getImgElementsByGubun(gubun, indexes[0],indexes[1], page);
		
		pageList.setJeju(jeju);
		pageList.setImg(imgList);
		pageList.setGubun(gubun);
		
		//유닛값에 따른 시작버튼 값
		int unitStartBtn=5*unit-4;//1,6,...
		pageList.setListBtnStartIdx(unitStartBtn);
		logger.info("pagination meta info: {}",pageList);
		logger.info("list unit start idx(btn):"+unitStartBtn);
		model.addAttribute("paginationMetaInfo",pageList );
		
		logger.info("defaultPage of gubun-jeju:{}",jeju);
		logger.info("jejusize of gubun: {}",jeju.size());
		logger.info("defaultPage of gubun-img:{}",imgList);
		//model에 6개를 뽑아서 전달하기
		//그런데 그 전에 몇 개가 그 페이지에 들어가는지 확인해야 할 것
		int size1=jeju.size();
		int size2=imgList.size();
		int size=Math.min(size1, size2);//이미지가 삽입되지 않은 경우의 수도 존재
		
		
		String[] div= {"one","two","three","four","five","six"};
		
		for(int i=0;i<size;i++) {
			model.addAttribute(div[i]+"Jeju",jeju.get(i));
			model.addAttribute(div[i]+"Img", imgList.get(i));
		}
		//총 페이지 정보도 보낼 것
		model.addAttribute("totPages",totPage);
		
		
		return "page_jejusituation/jejusituation_rest2";
	}
	//키워드 검색
	@RequestMapping(value="/searchByKeyword.do")
	public String jejusituation_keyword_search(Model model, @RequestParam(value="keyword") String keyword,@RequestParam(value="page",defaultValue="1") int page) {
		logger.info("keyword: {}",keyword);
		//페이징 처리가 필요
		JejuPage pageList=new JejuPage();
		pageList.setCurPage(page); //현재 페이지
		pageList.setElementsPerPage(6); //한 페이지당 아이템수
		int totPage=pBiz.getTotalPagesByKeyword(keyword, 6); //총 페이지수 계산
		int totRows=pBiz.getTotalElementsByKeyword(keyword);
		int listBtnUnit=(int)Math.round((double)totPage/5);//리스트 유닛
		pageList.setTotalPages(totPage); //총 페이지수
		pageList.setTotalElements(totRows); //총 행 개수
		pageList.setListBtnUnit(listBtnUnit);
		pageList.setKeyword(keyword);
		
		int[] indexes=pBiz.getStartAndEndIdx(6, page);//시작 인덱스, 끝인덱스 가져오기
		
		pageList.setStartIdx(indexes[0]); //시작 인덱스
		pageList.setEndIdx(indexes[1]); //끝 인덱스
		pageList.setCurPage(page);
		
		int unit=(int)Math.ceil((double)page/5);
		int finUnit=(int)Math.ceil((double)totPage/5);

		
		logger.info("current page gubun: {}, unit: {}",page,unit);
		Boolean pFlag=false;
		Boolean nFlag=false;
		//1~5같이 1인 경우는 이전페이지는 없음
		if(unit==1) {
			if(finUnit==1) {
				pFlag=false;
				nFlag=false;
			}else {
				pFlag=false;
				nFlag=true;
			}

		}
		else if(unit==finUnit) {
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
		
		logger.info("start-search:{}",indexes[0]);
		logger.info("end-search:{}",indexes[1]);
		logger.info("prevFlag:{}",pFlag);
		logger.info("nextFlag:{}",nFlag);
		//가게정보
		List<JejuDto> jeju=pBiz.getStoreElementsByKeyword(keyword,indexes[0],indexes[1], page);
		//가게들에 대한 메뉴정보
		int mStartIdx=36*page-35;
		logger.info("menuList startIdx: {}",mStartIdx);
	//	List<MenuDto> menuList=menuBiz.getPageMenuList(mStartIdx, page);
		//이미지에 대한 정보
		List<ImgDto> imgList=pBiz.getStoreImgElementsByKeyword(keyword, indexes[0],indexes[1], page);
		
		pageList.setJeju(jeju);
		pageList.setImg(imgList);
		
		//유닛값에 따른 시작버튼 값
		int unitStartBtn=5*unit-4;//1,6,...
		pageList.setListBtnStartIdx(unitStartBtn);
		logger.info("pagination meta info: {}",pageList);
		logger.info("list unit start idx(btn):"+unitStartBtn);
		model.addAttribute("paginationMetaInfo",pageList );
		
		logger.info("defaultPage of keyword-jeju:{}",jeju);
		logger.info("jejusize of search keyword: {}",jeju.size());
		logger.info("defaultPage of keyword-img:{}",imgList);
		//model에 6개를 뽑아서 전달하기
		//그런데 그 전에 몇 개가 그 페이지에 들어가는지 확인해야 할 것
		int size1=jeju.size();
		int size2=imgList.size();
		int size=Math.min(size1, size2);//이미지가 삽입되지 않은 경우의 수도 존재
		
		
		String[] div= {"one","two","three","four","five","six"};
		
		for(int i=0;i<size;i++) {
			model.addAttribute(div[i]+"Jeju",jeju.get(i));
			model.addAttribute(div[i]+"Img", imgList.get(i));
		}
		//총 페이지 정보도 보낼 것
		model.addAttribute("totPages",totPage);
		
		return "page_jejusituation/jejusituation_rest_search";
	}
	@RequestMapping(value="/jejusituation_rest_detail.do")
	public String jejusituation_rest_detail(Model model,@RequestParam(value="situ_num") int situ_num) {
		//각 가게별 세부 사항 조회해서 전달해주기 위함
		//메뉴,이미지,가게정보를 다 가져와야 함!
		JejuDto jeju=biz.getOurStoreInfo(situ_num);
		ImgDto img=imageBiz.getDetailImage(situ_num);
		List<MenuDto> menuList=menuBiz.getMenuListForOurStore(situ_num);
		
		model.addAttribute("jeju", jeju);
		model.addAttribute("img",img);
		model.addAttribute("menuList", menuList);
		
		logger.info("our store info:{}",jeju);
		logger.info("our store img: {}",img);
		logger.info("our store menuList:{}",menuList);
		
		return "page_jejusituation/jejusituation_rest_detail";
	}
	@RequestMapping(value="/jejusituation_rest_detail2.do")
	public String jejusituation_rest_detail2(Model model, HttpServletRequest request,@RequestParam(value="situ_num")int situ_num) {
		JejuDto jeju=biz.getOurStoreInfo(situ_num);
		String open=jeju.getSitu_open_time();
		String[] oArr=open.split(":");
		String close=jeju.getSitu_close_time();
		String[] cArr=close.split(":");
		model.addAttribute("situ_num",situ_num);
		model.addAttribute("open", open);
		model.addAttribute("open_hour", oArr[0]);
		model.addAttribute("open_min", oArr[1]);
		model.addAttribute("close", close);
		model.addAttribute("close_hour", cArr[0]);
		model.addAttribute("close_min", cArr[1]);
		
		if(request.getSession().getAttribute("prev")!=null) {
			String prev=(String)request.getSession().getAttribute("prev");
			if(prev.equals("개인")||prev.equals("사업자")) {
				return "page_jejusituation/jejusituation_rest_detail2";				
			}
		}
		return "redirect:jejusituation_rest_detail.do?situ_num="+situ_num;
		
	}
	
	//예약요청
	@ResponseBody
	@RequestMapping(value="/jejusituation_reservation.do",method=RequestMethod.POST)
	public Map<String,String> jejusituation_reservation(@RequestBody ReservationRequest req) throws ParseException {
		Map<String,String> response=new HashMap<String,String>();
		BookingDto booking=new BookingDto();
		booking.setSitu_num(req.getSitu_num());
		booking.setBook_name(req.getName().trim());
		booking.setBook_people(req.getCnt());
		String temp=req.getDate();
		StringTokenizer st=new StringTokenizer(temp,"-");
		StringBuilder sb=new StringBuilder();
		sb.append(st.nextToken().trim()).append("-").append(st.nextToken().trim()).append("-").append(st.nextToken().trim());
		String f=sb.toString();
		booking.setBook_regdate(f);
		booking.setBook_time(req.getTime().trim());
		booking.setBook_content(req.getRequire().trim());
		booking.setBook_phone(req.getPhone().trim());
		
		/*
		 * StoreStatus store=new StoreStatus(); store.setSitu_num(req.getSitu_num());
		 * store.setTime_range(req.getTime());
		 */
		logger.info("request:{}",req);
		logger.info("booking req:{}",booking);
	//	logger.info("store status :{}",store);
		
		
		int res=bookingBiz.reservation(booking);

		logger.info("예약처리 결과:{}",res);
		
		if(res>0) {
			response.put("message", "예약되었습니다");
		}else {
			response.put("message", "다른 시간대를 이용해주세요");
		}
		
		return response;
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
				session.setAttribute("prev", dto.getUser_member());//권한을 세션에서 공유하도록 설정
				model.addAttribute("user",dto);
			}
		}
		
		return "page_jejusituation/jejusituation_rest_create";
	}
	
//	@RequestMapping(value="/saveCoronaData.do")
//	public String jejusituation_save_data(Model model) {
//		
//		List<CoronaDto> list=biz.searchData();
//		
//		model.addAttribute("list", list);
//		logger.info("corona info: {}",list);
//		
//		return "page_jejusituation/test";
//		
//	}
	@RequestMapping(value="/corona.do")
	public String jejusituation_save_corona(Model model) {
		LocalDate today=LocalDate.now();
		HashMap<String,String> map=new HashMap<String,String>();
		DayOfWeek end=today.getDayOfWeek();
		DayOfWeek start=today.minusDays(7).getDayOfWeek();
		
		if(end.equals(DayOfWeek.SATURDAY)) {
			today=today.minusDays(1);
		}else if(end.equals(DayOfWeek.SUNDAY)) {
			today=today.minusDays(2);
		}
		
		map.put("start",today.minusDays(7).toString());
		map.put("end",today.toString());
		logger.info("corona map: {}",map);
		//저장된 데이터 가져오기
		List<HashMap<String,String>> list=cBiz.coronaList(map);
		logger.info("corona data:{}",list);
		//x를 " " 기준으로 split하여 그룹1만 담고,
		//def_cnt는 데이터로 담기
		List<String> labels=new ArrayList<String>();
		List<Long> dataSet=new ArrayList<Long>();
		
		Iterator iter=list.iterator();
		
		while(iter.hasNext()) {
			HashMap<String,String> map2=(HashMap<String, String>) iter.next();
			String def=String.valueOf(map2.get("DEF_CNT"));
			String x=String.valueOf(map2.get("X"));
			logger.info("x: "+x);
			String temp=x.substring(0,11);
			labels.add(temp.trim());
			dataSet.add(Long.valueOf(def));
		}
		
		logger.info("labels:{}",labels);
		logger.info("dataSet:{}",dataSet);
		
		if(labels.size()==6) {
			labels.add(LocalDate.now().toString());
			dataSet.add(0L);
		}
		
		model.addAttribute("label1",labels.get(0));
		model.addAttribute("label2",labels.get(1));
		model.addAttribute("label3",labels.get(2));
		model.addAttribute("label4",labels.get(3));
		model.addAttribute("label5",labels.get(4));
		model.addAttribute("label6",labels.get(5));
		model.addAttribute("label7",labels.get(6));
		model.addAttribute("data1",dataSet.get(0));
		model.addAttribute("data2",dataSet.get(1));
		model.addAttribute("data3",dataSet.get(2));
		model.addAttribute("data4",dataSet.get(3));
		model.addAttribute("data5",dataSet.get(4));
		model.addAttribute("data6",dataSet.get(5));
		model.addAttribute("data7",dataSet.get(6));
		
		return "page_jejusituation/jejusituation_corona";
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
