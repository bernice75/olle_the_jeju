package com.olle.biz.suggest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olle.dao.suggest.SuggestDao;
import com.olle.dto.etc.DibDto;
import com.olle.dto.etc.HashtagDto;
import com.olle.dto.suggest.SuggestDto;

@Service
public class SuggestBizImpl implements SuggestBiz {

	@Autowired
	private SuggestDao sd;
	
	
	@Override
	public List<SuggestDto> selectList(String kategorie, int page) {
		return sd.selectList(kategorie, page);
	}

	@Override
	public SuggestDto selectOne(int sug_num) {
		return sd.selectOne(sug_num);
	}

	@Override
	public int insert(SuggestDto dt) {
		return sd.insert(dt);
	}

	@Override
	public int update(SuggestDto dt) {
		return sd.update(dt);
	}

	@Override
	public int delete(int sug_num) {
		return sd.delete(sug_num);
	}

	@Override
	public int getAllCount(String kate) {
		return sd.getAllCount(kate);
	}

	@Override
	public String DateFormat(Date date) {
		return sd.DateFormat(date);
	}

	@Override
	public int insertDibs(int sug_num, String user_id) {
		return sd.insertDibs(sug_num,user_id);
	}
	
	@Override
	public List<SuggestDto> DibList(List<SuggestDto> list, String user_id) {
		return sd.DibList(list, user_id);
	}

	@Override
	public void likeUpdate(int trip_num) {
		sd.likeUpdate(trip_num);
	}



	/*
	 * @Override public int insert_ht(HashtagDto hdt) { return sd.insert_ht(hdt); }
	 */

}
