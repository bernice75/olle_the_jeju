package com.olle.biz.jejusituation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.jejusituation.JejuDao;
import com.olle.dto.jejusituation.JejuDto;

@Service
public class JejuBizImpl implements JejuBiz{
	
	@Autowired
	private JejuDao dao;
	
	



	@Override
	public int getMaxJejuDtoNum() {
		// TODO Auto-generated method stub
		return dao.getMaxJejuDtoNum();
	}


	@Override
	public int saveStore(JejuDto dto) {
		// TODO Auto-generated method stub
		return dao.saveStore(dto);
	}


	@Override
	public void setMaxPkFromSelectKey(int primaryKey) {
		// TODO Auto-generated method stub
		dao.setMaxPkFromSelectKey(primaryKey);
	}


	@Override
	public int getMaxPkFromSelectKey() {
		// TODO Auto-generated method stub
		return dao.getMaxPkFromSelectKey();
	}


	@Override
	public JejuDto getOurStoreInfo(int situ_num) {
		// TODO Auto-generated method stub
		return dao.getOurStoreInfo(situ_num);
	}


//	@Override
//	public int saveStore(JejuDto dto, ImgDto img, HashMap<String,Object> map) {
//		// TODO Auto-generated method stub
//		return dao.saveStore(dto, img, map);
//	}

}
