package com.olle.dto.pagination.jejusitu;

public class PaginationIdxes {
	private int startIdx;
	private int endIdx;
	public PaginationIdxes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaginationIdxes(int startIdx, int endIdx) {
		super();
		this.startIdx = startIdx;
		this.endIdx = endIdx;
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
	@Override
	public String toString() {
		return "PaginationIdxes [startIdx=" + startIdx + ", endIdx=" + endIdx + "]";
	}
	
	
}
