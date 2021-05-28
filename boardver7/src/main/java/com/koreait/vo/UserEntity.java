package com.koreait.vo;

public class UserEntity {
	private int iuser;
	private String id;
	private String pw;
	private int gender;
	private String nm;
	private String profileImg;

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public int getIuser() {
		return iuser;
	}

	public void setIuser(int iuser) {
		this.iuser = iuser;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}
}
