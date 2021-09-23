package com.olle.dto.pagination;

public class PaginationIdxes {
	private int startIdx;
	private int endIdx;
	//구분 조건
	private String situ_gubun;
	//키워드 조건
	private String keyword;
	
	public PaginationIdxes() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PaginationIdxes(int startIdx, int endIdx, String situ_gubun, String keyword) {
		super();
		this.startIdx = startIdx;
		this.endIdx = endIdx;
		this.situ_gubun = situ_gubun;
		this.keyword = keyword;
	}


	public int getStartIdx() {
		return startIdx;
	}


	public void setStartIdx(int startIdx) {
		this.startIdx = startIdx;
	}


	public int getEndIdx() {
		return endIdx;
	}


	public void setEndIdx(int endIdx) {
		this.endIdx = endIdx;
	}


	public String getSitu_gubun() {
		return situ_gubun;
	}


	public void setSitu_gubun(String situ_gubun) {
		this.situ_gubun = situ_gubun;
	}


	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	@Override
	public String toString() {
		return "PaginationIdxes [startIdx=" + startIdx + ", endIdx=" + endIdx + ", situ_gubun=" + situ_gubun
				+ ", keyword=" + keyword + "]";
	}



}
