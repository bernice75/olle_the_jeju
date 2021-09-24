package com.olle.dao.jejusituation;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olle.biz.etc.ImgBiz;
import com.olle.biz.jejusituation.JejuBiz;
import com.olle.biz.jejusituation.menu.MenuBiz;
import com.olle.dto.jejusituation.JejuDto;

@Repository
public class JejuDaoImpl implements JejuDao{
	
	@Autowired
	private JejuBiz jejuBiz;

	@Autowired
	private MenuBiz menuBiz;
	
	@Autowired
	private ImgBiz imgBiz;
	
	public static int primaryKey;
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int getMaxJejuDtoNum() {
		// TODO Auto-generated method stub
		int maxPk=0;
		maxPk=session.selectOne(NAMESPACE+"olleSituStoreMaxPk");
		return maxPk;
	}

	@Override
	public int saveStore(JejuDto dto) {
		// TODO Auto-generated method stub
		int res=0;
		try {
			session.insert(NAMESPACE+"insertSit",dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.setMaxPkFromSelectKey(dto.getSitu_num());
			res=this.getMaxPkFromSelectKey();
		}
		return res;
	}

	@Override
	public int getMaxPkFromSelectKey() {
		// TODO Auto-generated method stub
		return this.primaryKey;
	}

	@Override
	public void setMaxPkFromSelectKey(int primaryKey) {
		// TODO Auto-generated method stub
		this.primaryKey=primaryKey;
	}

	@Override
	public JejuDto getOurStoreInfo(int situ_num) {
		// TODO Auto-generated method stub
		JejuDto dto=session.selectOne(NAMESPACE+"selectOne",situ_num);
		return dto;
	}

//	@Transactional
//	@Override
//	public int saveStore(JejuDto dto, ImgDto img, HashMap<String,Object> map) {
//		// TODO Auto-generated method stub
//		int res=0;
//		int r1,r2,r3;
//		r1=jejuBiz.saveStore(dto);
//		r2=menuBiz.saveMenu(map);
//		r3=imgBiz.saveStoreImg(img);
//		
//		if(r1>0&&r2>0 &&r3>0) {
//			res=3;
//		}else {
//			res=-1;
//		}
//		
//		
//		return res;
//	}

}
