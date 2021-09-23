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
public class JejuPageDaoImpl implements JejuPageDao{
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired
	private MenuBiz mBiz;
	
	@Autowired
	private ImgBiz iBiz;

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

	@Override
	public List<JejuDto> getStoreElementsByGubun(String gubun, int startIdx, int endIdx, int page) {
		// TODO Auto-generated method stub
		PaginationIdxes pg=new PaginationIdxes();
		pg.setSitu_gubun(gubun);
		pg.setStartIdx(startIdx);
		pg.setEndIdx(endIdx);
		List<JejuDto> jeju=session.selectList(NAMESPACE+"storeGubunPagination",pg);
		return jeju;
	}

	@Override
	public List<ImgDto> getImgElementsByGubun(String gubun, int startIdx, int endIdx, int page) {
		// TODO Auto-generated method stub
		return iBiz.getStoreImgByGubun(gubun, startIdx, endIdx);
	}

	@Override
	public int getTotalElementsByGubun(String gubun) {
		// TODO Auto-generated method stub
		int tot=session.selectOne(NAMESPACE+"countTotalElementsByGubun",gubun);
		return tot;
	}

	@Override
	public int getTotalPagesByGubun(String gubun,int unit) {
		// TODO Auto-generated method stub
		int tot=getTotalElementsByGubun(gubun);
		//System.out.println(" bef tot: "+tot);
	//	System.out.println(" unit : "+unit);
		double temp=(double)tot/(double)unit;
		tot=(int)Math.ceil(temp);
		//System.out.println("temp: "+temp);
		return tot;
	}

	@Override
	public List<JejuDto> getStoreElementsByKeyword(String keyword, int startIdx, int endIdx, int page) {
		// TODO Auto-generated method stub
		PaginationIdxes pg=new PaginationIdxes();
		pg.setStartIdx(startIdx);
		pg.setEndIdx(endIdx);
		pg.setKeyword(keyword);
		List<JejuDto> list=session.selectList(NAMESPACE+"searchKeywordPaging",pg);
		return list;
	}

	@Override
	public List<ImgDto> getStoreImgElementsByKeyword(String keyword, int startIdx, int endIdx, int page) {
		// TODO Auto-generated method stub
		System.out.println("jeju page dao--keyword list: "+keyword+" "+startIdx+" "+endIdx+" "+page);
		List<ImgDto> list=iBiz.getStoreImgByKeyword(keyword, startIdx, endIdx);
		return list;
	}

	@Override
	public int getTotalElementsByKeyword(String keyword) {
		// TODO Auto-generated method stub
		System.out.println("keyword: "+keyword);
		int tot=session.selectOne(NAMESPACE+"countForKeywordPaging",keyword);
		return tot;
	}

	@Override
	public int getTotalPagesByKeyword(String keyword, int unit) {
		// TODO Auto-generated method stub
		int tot=getTotalElementsByKeyword(keyword);
		//System.out.println(" bef tot: "+tot);
	//	System.out.println(" unit : "+unit);
		double temp=(double)tot/(double)unit;
		tot=(int)Math.ceil(temp);
		//System.out.println("temp: "+temp);
		return tot;
	}



}
