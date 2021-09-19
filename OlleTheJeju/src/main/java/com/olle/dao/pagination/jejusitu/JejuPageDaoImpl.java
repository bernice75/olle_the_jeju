package com.olle.dao.pagination.jejusitu;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.biz.etc.ImageBiz;
import com.olle.biz.jejusituation.menu.MenuBiz;
import com.olle.dto.etc.ImgDto;
import com.olle.dto.jejusituation.JejuDto;
import com.olle.dto.pagination.jejusitu.PaginationIdxes;

@Repository
public class JejuPageDaoImpl implements JejuPageDao{
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired
	private MenuBiz mBiz;
	
	@Autowired
	private ImageBiz iBiz;

	@Override
	public int getTotalElements() {
		// TODO Auto-generated method stub
		int tot=0;
		tot=session.selectOne(NAMESPACE+"countTotalElements");
		return tot;
	}

	@Override
	public int getTotalPages(int unit) {
		// TODO Auto-generated method stub
		int tot=getTotalElements();
		tot=(int)Math.ceil((double)tot/unit);
		return tot;
	}



	@Override
	public int[] getStartAndEndIdx(int unit,int page) {
		// TODO Auto-generated method stub
		int[] indexes=new int[2];
		indexes[0]=unit*page-unit+1;
		indexes[1]=unit*page;
		return indexes;
	}

	@Override
	public List<JejuDto> getStoreElementsPerPage(int startIdx, int endIdx, int page) {
		// TODO Auto-generated method stub
		List<JejuDto> list=new ArrayList<JejuDto>();
		PaginationIdxes dto=new PaginationIdxes();
		dto.setStartIdx(startIdx);
		dto.setEndIdx(endIdx);
//		HashMap<String,Integer> map=new HashMap<String,Integer>();
//		map.put("startIdx", startIdx);
//		map.put("endIdx", endIdx);
		list=session.selectList(NAMESPACE+"totalStoreSelect",dto);
		return list;
	}

	@Override
	public List<ImgDto> getImgElementsPerPage(int startIdx, int endIdx, int page) {
		// TODO Auto-generated method stub
		List<ImgDto> list=iBiz.getStoreImg(startIdx, endIdx);
		
		return list;
	}



}
