package com.olle.biz.jejusituation;

import java.util.List;

import com.olle.dto.jejusituation.Criteria;
import com.olle.dto.jejusituation.JejuDto;

public interface JejuBiz {
	public List<JejuDto> selectList(Criteria cri);
	public int countTotal();
}
