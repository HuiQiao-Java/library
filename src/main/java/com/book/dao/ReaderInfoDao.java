package com.book.dao;

import com.book.domain.ReaderInfo;

public interface ReaderInfoDao {
	
	 ReaderInfo	quaryInfoById(Long readerid);
	 
	 Integer updateReaderInfo(ReaderInfo readerInfo);
}
