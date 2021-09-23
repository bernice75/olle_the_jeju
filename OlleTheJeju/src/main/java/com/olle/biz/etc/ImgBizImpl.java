package com.olle.biz.etc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.etc.ImgDao;
import com.olle.dto.etc.ImgDto;

@Service
public class ImgBizImpl implements ImgBiz {
	
	@Autowired
	private ImgDao dao;
	@Override
	public int selectMaxPK() {
		return dao.selectMaxPK();
	}
	@Override
	public int selectMaxGroupId(int boardNum) {
		return dao.selectMaxGroupId(boardNum);
	}
	@Override
	public int saveStoreImg(ImgDto dto) {
		return dao.saveStoreImg(dto);
	}

	@Override
	public List<ImgDto> getStoreImg(int startIdx, int endIdx) {
		return dao.getStoreImg(startIdx, endIdx);
	}
	
	@Override
	public List<ImgDto> getStoreImgByKeyword(String keyword, int startIdx, int endIdx) {
		return dao.getStoreImgByKeyword(keyword, startIdx, endIdx);
	}

	@Override
	public ImgDto getDetailImage(int situ_num) {
		return dao.getDetailImage(situ_num);
	}
	
	@Override
	public int cusInsert(ImgDto dto) {
		return dao.cusInsert(dto);
	}
	@Override
	public List<ImgDto> selectList(int board_num) {
		return dao.selectList(board_num);
	}
	@Override
	public List<ImgDto> getStoreImgByGubun(String gubun, int startIdx, int endIdx) {
		return dao.getStoreImgByGubun(gubun, startIdx, endIdx);
	}
}
