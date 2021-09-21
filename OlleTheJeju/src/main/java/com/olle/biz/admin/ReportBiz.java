package com.olle.biz.admin;

import java.util.List;

import com.olle.dto.admin.ReportDto;

public interface ReportBiz {
	public List<ReportDto> selectList();
	public int delete(int rep_num);
}
