package com.olle.dao.etc;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dto.etc.ImgDto;
import com.olle.dto.pagination.jejusitu.PaginationIdxes;

@Repository
public class ImgDaoImpl implements ImgDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ImgDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImgDto selectOne(int img_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ImgDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ImgDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int img_num) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int selectMaxPK() {
		// TODO Auto-generated method stub
		int max=0;
		max=sqlSession.selectOne(NAMESPACE+"selectMaxPK");

		return max;
	}

	@Override
	public int selectMaxGroupId(int boardNum) {
		// TODO Auto-generated method stub
		int res=0;
		res=sqlSession.selectOne(NAMESPACE+"selectMaxGroupId",boardNum);
		return res;
	}

	@Override
	public int saveStoreImg(ImgDto dto) {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"insert",dto);
	}

	@Override
	public List<ImgDto> getStoreImg(int startIdx, int endIdx) {
		// TODO Auto-generated method stub
		PaginationIdxes pg=new PaginationIdxes();
		pg.setStartIdx(startIdx);
		pg.setEndIdx(endIdx);
		List<ImgDto> list=sqlSession.selectList(NAMESPACE+"storeImg",pg);
		return list;
	}

//	@Override
//	public ImgDto getStoreImg(int table_num) {
//		// TODO Auto-generated method stub
//		ImgDto dto=sqlSession.selectOne(NAMESPACE+"storeImg",table_num);
//		return dto;
//	}

}
