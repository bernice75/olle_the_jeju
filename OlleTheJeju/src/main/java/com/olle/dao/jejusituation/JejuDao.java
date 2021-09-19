package com.olle.dao.jejusituation;

import java.util.List;

import com.olle.dto.jejusituation.Criteria;
import com.olle.dto.jejusituation.JejuDto;

public interface JejuDao {
	
	String NAMESPACE = "jeju.";
	
	public List<JejuDto> selectList(Criteria cri);
	public int countTotal();
}
