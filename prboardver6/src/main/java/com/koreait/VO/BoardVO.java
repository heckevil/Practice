package com.koreait.VO;

public class BoardVO {
	private int iboard;
	private String ctnt;
	private String title;
	private int iuser;
	private String regdt;
	private String nm;
	private int sidx;
	private int page;
	private String search;

	

	public void setNm(String nm) {
		this.nm = nm;
	}

	public int getSidx() {
		return sidx;
	}

	public void setSidx(int sidx) {
		this.sidx = sidx;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getNm() {
		return nm;
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