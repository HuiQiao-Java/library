package com.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.dao.LoginDao;
import com.book.service.LoginService;

@Service
public class LoginImpl implements LoginService {

	@Autowired
	LoginDao loginDao;

	@Override
	public boolean isAdmin(Integer id, String passwd) {
		return loginDao.isAdmin(id, passwd) > 0;
	}

	@Override
	public boolean isReader(Integer id, String passwd) {
		return loginDao.isReader(id, passwd) > 0;
	}

}
