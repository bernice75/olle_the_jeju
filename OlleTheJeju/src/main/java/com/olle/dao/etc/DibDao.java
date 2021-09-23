package com.olle.dao.etc;

public interface DibDao {
	String NAMESPACE = "dib.";
	
	//특정 게시물의 찜 개수
	public int countDib(int table_num);
}
