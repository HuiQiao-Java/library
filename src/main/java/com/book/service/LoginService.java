package com.book.service;

public interface LoginService {
	
	boolean isAdmin(Integer id,String passwd);
	
	boolean isReader(Integer id,String passwd);
}
