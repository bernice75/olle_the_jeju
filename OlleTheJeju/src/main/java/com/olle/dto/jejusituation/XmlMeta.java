package com.olle.dto.jejusituation;

public class XmlMeta {
	private int numOfRows;//한 페이지에 출력되는 컨텐츠수
	private int totalCount;//전체 컨텐츠 수
	
	public XmlMeta() {
		super();
		// TODO Auto-generated constructor stub
	}
	public XmlMeta(int numOfRows, int totalCount) {
		super();
		this.numOfRows = numOfRows;
		this.totalCount = totalCount;
	}
	public int getNumOfRows() {
		return numOfRows;
	}
	public void setNumOfRows(int numOfRows) {
		this.numOfRows = numOfRows;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	@Override
	public String toString() {
		return "XmlMeta [numOfRows=" + numOfRows + ", totalCount=" + totalCount + "]";
	}

	
}
