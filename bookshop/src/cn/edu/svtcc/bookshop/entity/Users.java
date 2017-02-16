package cn.edu.svtcc.bookshop.entity;

import java.io.Serializable;

public class Users implements Serializable{

  
private int id;
private String loginId;
  private String loginPwd;
  private String name;
  private String address;
  private String phone;
  private String mail;
  private int userRoleId;
  private int  userStateId;
  
  public Users(String loginId, String loginPwd, String name, String address, String phone, String mail,int userRoleId, int userStateId) {
		super();
		this.loginId = loginId;
		this.loginPwd = loginPwd;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.mail = mail;
		this.userRoleId = userRoleId;
		this.userStateId = userStateId;
	}
public Users(){}
  
public String getLoginId() {
	return loginId;
}
public void setLoginId(String loginId) {
	this.loginId = loginId;
}
public String getLoginPwd() {
	return loginPwd;
}
public void setLoginPwd(String loginPwd) {
	this.loginPwd = loginPwd;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public int getUserRoleId() {
	return userRoleId;
}
public void setUserRoleId(int userRoleId) {
	this.userRoleId = userRoleId;
}
public int getUserStateId() {
	return userStateId;
}
public void setUserStateId(int userStateId) {
	this.userStateId = userStateId;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

  
	
	
	
}
