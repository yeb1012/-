package org.yedam.service;



public class MemberVO {
	private String mid;
	private String pass;
	private String name;
	private String phone;
	
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}
	public MemberVO(String mid,String pass,String name, String phone) {
		this.mid = mid;
		this.pass = pass;
		this.name = name;
		this.phone = phone;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
