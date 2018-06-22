package com.book.service;

import com.book.domain.ReaderInfo;

public interface ReaderInfoService {
	public ReaderInfo quaryReaderInfo(Long readerid);
	
	public Integer updateReaderInfo(ReaderInfo readerInfo);
}
