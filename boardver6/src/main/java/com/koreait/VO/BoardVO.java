package com.koreait.VO;

public class BoardVO {
private int iboard;
private String ctnt;
private String title;
private int iuser;
private String regdt;
private String nm;
private int isFav;
private int sIdx;
private int page;
private String search;
private int recordCnt;

public int getRecordCnt() {
	return recordCnt;
}
public void setRecordCnt(int recordCnt) {
	this.recordCnt = recordCnt;
}
public String getSearch() {
	return search;
}
public void setSearch(String search) {
	this.search = search;
}
public int getsIdx() {
	return sIdx;
}
public void setsIdx(int sIdx) {
	this.sIdx = sIdx;
}
public int getPage() {
	return page;
}
public void setPage(int page) {
	this.page = page;
}
public int getIsFav() {
	return isFav;
}
public void setIsFav(int isFav) {
	this.isFav = isFav;
}
public String getNm() {
	return nm;
}
public void setNm(String nm) {
	this.nm = nm;
}
public int getIboard() {
	return iboard;
}
public void setIboard(int iboard) {
	this.iboard = iboard;
}
public String getCtnt() {
	return ctnt;
}
public void setCtnt(String ctnt) {
	this.ctnt = ctnt;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getIuser() {
	return iuser;
}
public void setIuser(int iuser) {
	this.iuser = iuser;
}
public String getRegdt() {
	return regdt;
}
public void setRegdt(String regdt) {
	this.regdt = regdt;
}
}
