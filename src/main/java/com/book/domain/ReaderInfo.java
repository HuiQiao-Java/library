package com.book.domain;

import java.io.Serializable;
import java.util.Date;

import com.book.common.vo.DateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


public class ReaderInfo implements Serializable {

	private static final long serialVersionUID = -977116290514911175L;
	private Long readerId;
	private String name;
	private String sex;
	private String birth;
	private String address;
	private String telcode;
	private String password;
	private byte roletype;
	private String salt;
	private byte permmission;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "ReaderInfo [readerId=" + readerId + ", name=" + name + ", sex=" + sex + ", birth=" + birth
				+ ", address=" + address + ", telcode=" + telcode + ", password=" + password + ", roletype=" + roletype
				+ ", salt=" + salt + ", permmission=" + permmission + "]";
	}
	public byte getRoletype() {
		return roletype;
	}
	public void setRoletype(byte roletype) {
		this.roletype = roletype;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public byte getPermmission() {
		return permmission;
	}
	public void setPermmission(byte permmission) {
		this.permmission = permmission;
	}
	public void setReaderId(Long readerId) {
		this.readerId = readerId;
	}
	public Long getReaderId() {
		return readerId;
	}
	public void setReaderId(long readerId) {
		this.readerId = readerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelcode() {
		return telcode;
	}
	public void setTelcode(String telcode) {
		this.telcode = telcode;
	}


	

}
