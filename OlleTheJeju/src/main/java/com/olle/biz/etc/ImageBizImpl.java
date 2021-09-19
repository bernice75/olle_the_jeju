package com.olle.biz.etc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.etc.ImgDao;
import com.olle.dto.etc.ImgDto;

@Service
public class ImageBizImpl implements ImageBiz{
	
	@Autowired
	private ImgDao dao;

	@Override
	public int selectMaxPK() {
		// TODO Auto-generated method stub
		return dao.selectMaxPK();
	}

	@Override
	public int selectMaxGroupId(int boardNum) {
		// TODO Auto-generated method stub
		return dao.selectMaxGroupId(boardNum);
	}



	@Override
	public int saveStoreImg(ImgDto dto) {
		// TODO Auto-generated method stub
		return dao.saveStoreImg(dto);
	}

	@Override
	public List<ImgDto> getStoreImg(int startIdx, int endIdx) {
		// TODO Auto-generated method stub
		return dao.getStoreImg(startIdx, endIdx);
	}

//	@Override
//	public ImgDto getStoreImg(int table_num) {
//		// TODO Auto-generated method stub
//		return dao.getStoreImg(table_num);
//	}

}
