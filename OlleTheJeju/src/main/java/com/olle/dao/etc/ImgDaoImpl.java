package com.olle.dao.etc;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.dto.etc.ImgDto;

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
		try {
			max=sqlSession.selectOne(NAMESPACE+"selectMaxPK");
		}catch(Exception e) {
			max=0;
		}finally {
			max++;
		}

		return max;
	}

	@Override
	public int selectMaxGroupId(int boardNum) {
		// TODO Auto-generated method stub
		int res=0;
		
		try {
			res=sqlSession.selectOne(NAMESPACE+"selectMaxGroupId",boardNum);
		}catch(Exception e) {
			res=0;//null일 때
		}finally {
			res++;
		}
		return res;
	}

	@Override
	public int saveStoreImg(ImgDto dto) {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"insert",dto);
	}

}
