package com.olle.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.olle.biz.jejusituation.CoronaBiz;

@Service
@EnableScheduling
public class CoronaScheduling{

	@Autowired
	private CoronaBiz biz;
	
	//0 30 10 * * *  :매일 오전 10시 30분에 업데이트
	@Scheduled(cron="0 30 10 * * * ")
	public void saveData() {
		biz.searchData();
		System.out.println("scheduling");
	}
	

	
}
