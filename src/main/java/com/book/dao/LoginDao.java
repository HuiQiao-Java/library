package com.book.dao;

import org.apache.ibatis.annotations.Param;

public interface LoginDao {
	
	Integer isReader(@Param("id")Long id,
					 @Param("passwd")String passwd);
	
	Integer isAdmin(@Param("id")Long id,
					@Param("passwd")String passwd);
}
