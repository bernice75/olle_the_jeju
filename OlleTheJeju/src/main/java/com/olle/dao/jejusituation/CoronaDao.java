package com.olle.dao.jejusituation;

import java.util.List;

import com.olle.dto.jejusituation.CoronaDto;

public interface CoronaDao {
	static final String NAMESPACE="corona.";
	void searchData(List<CoronaDto> list);//데이터 저장 or update==>merge
}
