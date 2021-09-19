package com.olle.biz.jejusituation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.jejusituation.JejuDao;
import com.olle.dto.jejusituation.Criteria;
import com.olle.dto.jejusituation.JejuDto;

@Service
public class JejuBizImpl implements JejuBiz {
	@Autowired
	private JejuDao dao;
	
	public List<JejuDto> selectList(Criteria cri) {
		return dao.selectList(cri);
	}

	@Override
	public int countTotal() {
		return dao.countTotal();
	}
}
