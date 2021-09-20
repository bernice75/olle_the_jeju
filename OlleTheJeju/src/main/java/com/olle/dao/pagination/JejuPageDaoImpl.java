package com.olle.dao.pagination;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.biz.etc.ImgBiz;
import com.olle.biz.jejusituation.menu.MenuBiz;
import com.olle.dto.etc.ImgDto;
import com.olle.dto.jejusituation.JejuDto;
import com.olle.dto.pagination.PaginationIdxes;

@Repository
public class JejuPageDaoImpl implements JejuPageDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private ImgBiz iBiz;

	@Override
	public int getTotalElements() {
		int tot=0;
		tot=sqlSession.selectOne(NAMESPACE+"countTotalElements");
		return tot;
	}

	@Override
	public int getTotalPages(int unit) {
		int tot=getTotalElements();
		tot=(int)Math.round((double)tot/unit);
		return tot;
	}

	@Override
	public int[] getStartAndEndIdx(int unit,int page) {
		int[] indexes=new int[2];
		indexes[0]=unit*page-unit+1;
		indexes[1]=unit*page;
		return indexes;
	}

	@Override
	public List<JejuDto> getStoreElementsPerPage(int startIdx, int endIdx, int page) {
		List<JejuDto> list=new ArrayList<JejuDto>();
		PaginationIdxes dto=new PaginationIdxes();
		dto.setStartIdx(startIdx);
		dto.setEndIdx(endIdx);
		list=sqlSession.selectList(NAMESPACE+"totalStoreSelect",dto);
		return list;
	}

	@Override
	public List<ImgDto> getImgElementsPerPage(int startIdx, int endIdx, int page) {
		List<ImgDto> list=iBiz.getStoreImg(startIdx, endIdx);
		
		return list;
	}
}
