package com.olle.dto.jejusituation;

public class CoronaDto {
	private String createDt;
	private String updateDt;
	private int deathCnt;
	private int defCnt;
	private String gubun;
	private String gubunCn;
	private String gubunEn;
	private int incDec;
	private int isolClearCnt;
	private int localOccCnt;
	private int overFlowCnt;
	private String qurRate;
	private Long seq;
	private String stdDay;
	
	public CoronaDto() {
		super();
	}
	public CoronaDto(String createDt, String updateDt, int deathCnt, int defCnt, String gubun, String gubunCn,
			String gubunEn, int incDec, int isolClearCnt, int localOccCnt, int overFlowCnt, String qurRate, Long seq,
			String stdDay) {
		super();
		this.createDt = createDt;
		this.updateDt = updateDt;
		this.deathCnt = deathCnt;
		this.defCnt = defCnt;
		this.gubun = gubun;
		this.gubunCn = gubunCn;
		this.gubunEn = gubunEn;
		this.incDec = incDec;
		this.isolClearCnt = isolClearCnt;
		this.localOccCnt = localOccCnt;
		this.overFlowCnt = overFlowCnt;
		this.qurRate = qurRate;
		this.seq = seq;
		this.stdDay = stdDay;
	}
	
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	public String getUpdateDt() {
		return updateDt;
	}
	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}
	public int getDeathCnt() {
		return deathCnt;
	}
	public void setDeathCnt(int deathCnt) {
		this.deathCnt = deathCnt;
	}
	public int getDefCnt() {
		return defCnt;
	}
	public void setDefCnt(int defCnt) {
		this.defCnt = defCnt;
	}
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public String getGubunCn() {
		return gubunCn;
	}
	public void setGubunCn(String gubunCn) {
		this.gubunCn = gubunCn;
	}
	public String getGubunEn() {
		return gubunEn;
	}
	public void setGubunEn(String gubunEn) {
		this.gubunEn = gubunEn;
	}
	public int getIncDec() {
		return incDec;
	}
	public void setIncDec(int incDec) {
		this.incDec = incDec;
	}
	public int getIsolClearCnt() {
		return isolClearCnt;
	}
	public void setIsolClearCnt(int isolClearCnt) {
		this.isolClearCnt = isolClearCnt;
	}
	public int getLocalOccCnt() {
		return localOccCnt;
	}
	public void setLocalOccCnt(int localOccCnt) {
		this.localOccCnt = localOccCnt;
	}
	public int getOverFlowCnt() {
		return overFlowCnt;
	}
	public void setOverFlowCnt(int overFlowCnt) {
		this.overFlowCnt = overFlowCnt;
	}
	public String getQurRate() {
		return qurRate;
	}
	public void setQurRate(String qurRate) {
		this.qurRate = qurRate;
	}
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public String getStdDay() {
		return stdDay;
	}
	public void setStdDay(String stdDay) {
		this.stdDay = stdDay;
	}
	@Override
	public String toString() {
		return "CoronaDto [createDt=" + createDt + ", updateDt=" + updateDt + ", deathCnt=" + deathCnt + ", defCnt="
				+ defCnt + ", gubun=" + gubun + ", gubunCn=" + gubunCn + ", gubunEn=" + gubunEn + ", incDec=" + incDec
				+ ", isolClearCnt=" + isolClearCnt + ", localOccCnt=" + localOccCnt + ", overFlowCnt=" + overFlowCnt
				+ ", qurRate=" + qurRate + ", seq=" + seq + ", stdDay=" + stdDay + "]";
	}
	
	
}