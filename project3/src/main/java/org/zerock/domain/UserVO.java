package org.zerock.domain;

import java.util.Date;

public class UserVO {

	
	private String username;
	private String birth;
	private String id;
	private String pw;
	private String pwcheck;
	private String address1;
	private String address2;
	private String address3;
	private String mobilenum;
	private String email;
	private Integer follownum;
	private Integer evalgrade;
	private Integer balance;
	private Integer gamecnt;
	

	public Integer getGamecnt() {
		return gamecnt;
	}

	public void setGamecnt(Integer gamecnt) {
		this.gamecnt = gamecnt;
	}

	private Date regdate;
	private Date updatedate;
	
	
	
	  
//	@Override
//	public String toString() {
//		System.out.println("\t\t- id("+id+")");
//		System.out.println("\t\t- pw("+pw+")");
//		
//		return super.toString();
//	}

//	public UserVO(String username) {
//		this.username = username;
//	}
	
//	public UserVO(String id, String pw, String username) {
//		this.id = id;
//		this.pw = pw;
//		this.username = username;
//	}
//	

	public String getUsername() {
		return username;
	}
	
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getPwcheck() {
		return pwcheck;
	}
	public void setPwcheck(String pwcheck) {
		this.pwcheck = pwcheck;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getMobilenum() {
		return mobilenum;
	}
	public void setMobilenum(String mobilenum) {
		this.mobilenum = mobilenum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getFollownum() {
		return follownum;
	}
	public void setFollownum(Integer follownum) {
		this.follownum = follownum;
	}
	public Integer getEvalgrade() {
		return evalgrade;
	}
	public void setEvalgrade(Integer evalgrade) {
		this.evalgrade = evalgrade;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	@Override
	public String toString() {
		return "UserVO [username=" + username + ", birth=" + birth + ", id=" + id + ", pw=" + pw + ", pwcheck="
				+ pwcheck + ", address1=" + address1 + ", address2=" + address2 + ", address3=" + address3
				+ ", mobilenum=" + mobilenum + ", email=" + email + ", follownum=" + follownum + ", evalgrade="
				+ evalgrade + ", balance=" + balance + ", gamecnt=" + gamecnt + ", regdate=" + regdate + ", updatedate="
				+ updatedate + "]";
	}





	
	
	
}
