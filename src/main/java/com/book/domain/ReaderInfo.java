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
	@Override
	public String toString() {
		return "ReaderInfo [readerId=" + readerId + ", name=" + name + ", sex=" + sex + ", birth=" + birth
				+ ", address=" + address + ", telcode=" + telcode + "]";
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
