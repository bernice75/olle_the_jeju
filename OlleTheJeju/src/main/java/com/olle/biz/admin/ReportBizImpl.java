package com.olle.biz.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.admin.ReportDao;
import com.olle.dto.admin.ReportDto;

@Service
public class ReportBizImpl implements ReportBiz {
	
	@Autowired
	private ReportDao dao;

	@Override
	public List<ReportDto> selectList() {
		return dao.selectList();
	}

	@Override
	public int delete(int rep_num) {
		return dao.delete(rep_num);
	}

}
