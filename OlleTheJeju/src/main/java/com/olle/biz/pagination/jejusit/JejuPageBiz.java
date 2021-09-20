package com.olle.biz.pagination.jejusit;

import java.util.ArrayList;
import java.util.List;

import com.olle.dto.etc.ImgDto;
import com.olle.dto.jejusituation.JejuDto;
import com.olle.dto.jejusituation.menu.MenuDto;

public interface JejuPageBiz {
	//전체 요소 갯수 가져오기
	int getTotalElements();
	//전체 페이지수계산-unit개씩 끊어서 계산
	int getTotalPages(int unit);
	//시작인덱스,끝인덱스 계산하기
	int[] getStartAndEndIdx(int unit,int page);
	//구분에 따른 전체 요소갯수가져오기
	int getTotalElementsByGubun(String gubun);
	int getTotalPagesByGubun(String gubun,int unit);
	//시작인덱스, 끝인덱스로 해당 페이지 가져오기
	List<JejuDto> getStoreElementsPerPage(int startIdx,int endIdx,int page);
	List<ImgDto> getImgElementsPerPage(int startIdx,int endIdx,int page);
	ArrayList<ArrayList<MenuDto>> getMenuListElementsPerPage(int startIdx,int endIdx,int page);
	//구분에 의한 페이징처리
	List<JejuDto> getStoreElementsByGubun(String gubun,int startIdx,int endIdx,int page);
	List<ImgDto> getImgElementsByGubun(String gubun,int startIdx,int endIdx,int page);
}
