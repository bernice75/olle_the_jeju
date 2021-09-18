package com.olle.biz.pagination.jejusit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.pagination.jejusitu.JejuPageDao;
import com.olle.dto.etc.ImgDto;
import com.olle.dto.jejusituation.JejuDto;
import com.olle.dto.jejusituation.menu.MenuDto;

@Service
public class JejuPageBizImpl implements JejuPageBiz{

	@Autowired
	private JejuPageDao dao;
	
	@Override
	public int getTotalElements() {
		// TODO Auto-generated method stub
		return dao.getTotalElements();
	}

	@Override
	public int getTotalPages(int unit) {
		// TODO Auto-generated method stub
		return dao.getTotalPages(unit);
	}

	@Override
	public int[] getStartAndEndIdx(int unit, int page) {
		// TODO Auto-generated method stub
		return dao.getStartAndEndIdx(unit, page);
	}

	@Override
	public List<JejuDto> getStoreElementsPerPage(int startIdx, int endIdx, int page) {
		// TODO Auto-generated method stub
		return dao.getStoreElementsPerPage(startIdx, endIdx, page);
	}

	@Override
	public List<ImgDto> getImgElementsPerPage(int startIdx, int endIdx, int page) {
		// TODO Auto-generated method stub
		return dao.getImgElementsPerPage(startIdx, endIdx, page);
	}

	@Override
	public ArrayList<ArrayList<MenuDto>> getMenuListElementsPerPage(int startIdx, int endIdx, int page) {
		// TODO Auto-generated method stub
		return null;
	}



}
