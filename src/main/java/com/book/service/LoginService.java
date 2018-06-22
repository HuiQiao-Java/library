package com.book.service;

public interface LoginService {
	
	boolean isAdmin(Long id,String passwd);
	
	boolean isReader(Long id,String passwd);
}
