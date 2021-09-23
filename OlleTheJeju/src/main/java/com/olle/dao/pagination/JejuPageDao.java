package com.olle.dao.pagination;

import java.util.ArrayList;
import java.util.List;

import com.olle.dto.etc.ImgDto;
import com.olle.dto.jejusituation.JejuDto;
import com.olle.dto.jejusituation.MenuDto;

public interface JejuPageDao {
	
		static final String NAMESPACE="jeju.";
	
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
		//구분조건으로 페이징처리
		List<JejuDto> getStoreElementsByGubun(String gubun,int startIdx,int endIdx,int page);
		List<ImgDto> getImgElementsByGubun(String gubun,int startIdx,int endIdx,int page);
	//	ArrayList<ArrayList<MenuDto>> getMenuListElementsPerPage(int startIdx,int endIdx,int page);
		//키워드에 의한 페이징 처리
		//구분에 의한 페이징처리
		int getTotalElementsByKeyword(String keyword);
		int getTotalPagesByKeyword(String keyword,int unit);
		List<JejuDto> getStoreElementsByKeyword(String keyword,int startIdx, int endIdx,int page);
		List<ImgDto> getStoreImgElementsByKeyword(String keyword,int startIdx,int endIdx,int page);
		
}
