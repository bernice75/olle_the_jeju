package com.olle.dao.etc;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.olle.dto.etc.ImgDto;

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

}
