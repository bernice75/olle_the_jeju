package com.olle.dao.etc;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dto.etc.ImgDto;
import com.olle.dto.pagination.PaginationIdxes;

@Repository
public class ImgDaoImpl implements ImgDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int selectMaxPK() {
		int max=0;
		max=sqlSession.selectOne(NAMESPACE+"selectMaxPK");

		return max;
	}
	
	@Override
	public int selectMaxGroupId(int boardNum) {
		int res=0;
		res=sqlSession.selectOne(NAMESPACE+"selectMaxGroupId",boardNum);
		return res;
	}

	@Override
	public int saveStoreImg(ImgDto dto) {
		return sqlSession.insert(NAMESPACE+"insert",dto);
	}

	@Override
	public List<ImgDto> getStoreImg(int startIdx, int endIdx) {
		PaginationIdxes pg=new PaginationIdxes();
		pg.setStartIdx(startIdx);
		pg.setEndIdx(endIdx);
		List<ImgDto> list=sqlSession.selectList(NAMESPACE+"storeImg",pg);
		return list;
	}
	
	@Override
	public List<ImgDto> getStoreImgByGubun(String gubun, int startIdx, int endIdx) {
		PaginationIdxes pg=new PaginationIdxes();
		pg.setSitu_gubun(gubun);
		pg.setStartIdx(startIdx);
		pg.setEndIdx(endIdx);
		List<ImgDto> list=sqlSession.selectList(NAMESPACE+"storeImgByGubun",pg);
		return list;
	}
	
	@Override
	public List<ImgDto> getStoreImgByKeyword(String keyword, int startIdx, int endIdx) {
		PaginationIdxes pg=new PaginationIdxes();
		pg.setKeyword(keyword);
		pg.setStartIdx(startIdx);
		pg.setEndIdx(endIdx);
		System.out.println("keyword--imgdao---: "+pg);
		List<ImgDto> list=sqlSession.selectList(NAMESPACE+"searchKeywordImgPaging",pg);
		return list;
	}

	@Override
	public ImgDto getDetailImage(int situ_num) {
		ImgDto dto=sqlSession.selectOne(NAMESPACE+"selectOneFromJejuDetail",situ_num);
		return dto;
	}

	@Override
	public int cusInsert(ImgDto dto) {
		return sqlSession.insert(NAMESPACE + "customInsert", dto);
	}

	@Override
	public List<ImgDto> selectList(int board_num) {
		return sqlSession.selectList(NAMESPACE + "selectList", board_num);
	}
	@Override
	public List<ImgDto> selectDetailList(int plan_num) {
		
		List<ImgDto> dto = new ArrayList<ImgDto>();
		
		try {
			dto = sqlSession.selectList(NAMESPACE+"selectDetailList",plan_num);
		} catch (Exception e) {
			System.out.println("[error] : 나만의 일정 디테일 이미지 불러오기 실패");
			e.printStackTrace();
		}
		
		return dto;
	}
	@Override
	public int delete(int plan_num) {
		
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE + "delete",plan_num);
		} catch (Exception e) {
			System.out.println("[error] : 나만의 일정 이미지 삭제 실패");
			e.printStackTrace();
		}
		
		return res;
	}
}
