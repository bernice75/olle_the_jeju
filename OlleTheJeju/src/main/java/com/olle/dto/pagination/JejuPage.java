package com.olle.dto.pagination;

import java.util.ArrayList;
import java.util.List;

import com.olle.dto.etc.ImgDto;
import com.olle.dto.jejusituation.JejuDto;
import com.olle.dto.jejusituation.MenuDto;

public class JejuPage {
	//총 아이템수
	int totalElements;
	//총 페이지 수
	int totalPages;
	//한 페이지당 아이템수
	int elementsPerPage;
	//시작 인덱스(페이지당)
	int startIdx;
	//끝인덱스
	int endIdx;
	//현재 페이지
	int curPage;
	//리스트 유닛
	int listBtnUnit;
	//이전 유닛으로 넘어갈 수 있는지 여부
	boolean prevUnit;
	boolean nextUnit;
	//페이지당 아이뎀 담기
	//가게정보
	List<JejuDto> jeju=new ArrayList<JejuDto>();
	//이미지
	List<ImgDto> img=new ArrayList<ImgDto>();
	//각 가게당 메뉴 리스트들을 담을 리스트
	List<MenuDto> menuList=new ArrayList<MenuDto>();
	//버튼리스트 시작버튼값
	int listBtnStartIdx;
	//구분값
	String gubun;
	//키워드
	String keyword;
	public JejuPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JejuPage(int totalElements, int totalPages, int elementsPerPage, int startIdx, int endIdx, int curPage,
			int listBtnUnit, boolean prevUnit, boolean nextUnit, List<JejuDto> jeju, List<ImgDto> img,
			List<MenuDto> menuList, int listBtnStartIdx, String gubun, String keyword) {
		super();
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.elementsPerPage = elementsPerPage;
		this.startIdx = startIdx;
		this.endIdx = endIdx;
		this.curPage = curPage;
		this.listBtnUnit = listBtnUnit;
		this.prevUnit = prevUnit;
		this.nextUnit = nextUnit;
		this.jeju = jeju;
		this.img = img;
		this.menuList = menuList;
		this.listBtnStartIdx = listBtnStartIdx;
		this.gubun = gubun;
		this.keyword = keyword;
	}
	public int getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getElementsPerPage() {
		return elementsPerPage;
	}
	public void setElementsPerPage(int elementsPerPage) {
		this.elementsPerPage = elementsPerPage;
	}
	public int getStartIdx() {
		return startIdx;
	}
	public void setStartIdx(int startIdx) {
		this.startIdx = startIdx;
	}
	public int getEndIdx() {
		return endIdx;
	}
	public void setEndIdx(int endIdx) {
		this.endIdx = endIdx;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getListBtnUnit() {
		return listBtnUnit;
	}
	public void setListBtnUnit(int listBtnUnit) {
		this.listBtnUnit = listBtnUnit;
	}
	public boolean isPrevUnit() {
		return prevUnit;
	}
	public void setPrevUnit(boolean prevUnit) {
		this.prevUnit = prevUnit;
	}
	public boolean isNextUnit() {
		return nextUnit;
	}
	public void setNextUnit(boolean nextUnit) {
		this.nextUnit = nextUnit;
	}
	public List<JejuDto> getJeju() {
		return jeju;
	}
	public void setJeju(List<JejuDto> jeju) {
		this.jeju = jeju;
	}
	public List<ImgDto> getImg() {
		return img;
	}
	public void setImg(List<ImgDto> img) {
		this.img = img;
	}
	public List<MenuDto> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<MenuDto> menuList) {
		this.menuList = menuList;
	}
	public int getListBtnStartIdx() {
		return listBtnStartIdx;
	}
	public void setListBtnStartIdx(int listBtnStartIdx) {
		this.listBtnStartIdx = listBtnStartIdx;
	}
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "JejuPage [totalElements=" + totalElements + ", totalPages=" + totalPages + ", elementsPerPage="
				+ elementsPerPage + ", startIdx=" + startIdx + ", endIdx=" + endIdx + ", curPage=" + curPage
				+ ", listBtnUnit=" + listBtnUnit + ", prevUnit=" + prevUnit + ", nextUnit=" + nextUnit + ", jeju="
				+ jeju + ", img=" + img + ", menuList=" + menuList + ", listBtnStartIdx=" + listBtnStartIdx + ", gubun="
				+ gubun + ", keyword=" + keyword + "]";
	}

	
	
}
