package com.olle.biz.pagination;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.pagination.JejuPageDao;
import com.olle.dto.etc.ImgDto;
import com.olle.dto.jejusituation.JejuDto;
import com.olle.dto.jejusituation.MenuDto;

@Service
public class JejuPageBizImpl implements JejuPageBiz {
	@Autowired
	private JejuPageDao dao;
	
	@Override
	public int getTotalElements() {
		return dao.getTotalElements();
	}

	@Override
	public int getTotalPages(int unit) {
		return dao.getTotalPages(unit);
	}

	@Override
	public int[] getStartAndEndIdx(int unit, int page) {
		return dao.getStartAndEndIdx(unit, page);
	}

	@Override
	public List<JejuDto> getStoreElementsPerPage(int startIdx, int endIdx, int page) {
		return dao.getStoreElementsPerPage(startIdx, endIdx, page);
	}

	@Override
	public List<ImgDto> getImgElementsPerPage(int startIdx, int endIdx, int page) {
		return dao.getImgElementsPerPage(startIdx, endIdx, page);
	}

	@Override
	public ArrayList<ArrayList<MenuDto>> getMenuListElementsPerPage(int startIdx, int endIdx, int page) {
		return null;
	}

	@Override
	public List<JejuDto> getStoreElementsByGubun(String gubun, int startIdx, int endIdx, int page) {
		return dao.getStoreElementsByGubun(gubun, startIdx, endIdx, page);
	}

	@Override
	public List<ImgDto> getImgElementsByGubun(String gubun, int startIdx, int endIdx, int page) {
		return dao.getImgElementsByGubun(gubun, startIdx, endIdx, page);
	}

	@Override
	public int getTotalElementsByGubun(String gubun) {
		return dao.getTotalElementsByGubun(gubun);
	}

	@Override
	public int getTotalPagesByGubun(String gubun,int unit) {
		return dao.getTotalPagesByGubun(gubun,unit);
	}

	@Override
	public List<JejuDto> getStoreElementsByKeyword(String keyword, int startIdx, int endIdx, int page) {
		return dao.getStoreElementsByKeyword(keyword, startIdx, endIdx, page);
	}

	@Override
	public List<ImgDto> getStoreImgElementsByKeyword(String keyword, int startIdx, int endIdx, int page) {
		return dao.getStoreImgElementsByKeyword(keyword, startIdx, endIdx, page);
	}

	@Override
	public int getTotalElementsByKeyword(String keyword) {
		return dao.getTotalElementsByKeyword(keyword);
	}

	@Override
	public int getTotalPagesByKeyword(String keyword, int unit) {
		return dao.getTotalPagesByKeyword(keyword, unit);
	}
}
