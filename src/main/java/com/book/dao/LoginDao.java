package com.book.dao;

import org.apache.ibatis.annotations.Param;

public interface LoginDao {
	
	Integer isReader(@Param("id")Integer id,
					 @Param("passwd")String passwd);
	
	Integer isAdmin(@Param("id")Integer id,
					@Param("passwd")String passwd);
}
