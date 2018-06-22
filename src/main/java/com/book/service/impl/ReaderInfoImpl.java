package com.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.dao.ReaderInfoDao;
import com.book.domain.ReaderInfo;
import com.book.service.ReaderInfoService;

@Service
public class ReaderInfoImpl implements ReaderInfoService{
	
	@Autowired
	ReaderInfoDao readerInfoDao;

	@Override
	public ReaderInfo quaryReaderInfo(Long readerid) {
		//数据校验
		//进行查询
		ReaderInfo result = readerInfoDao.quaryInfoById(readerid);
		System.out.println(result);
		//返回结果
		return result;
	}

	@Override
	public Integer updateReaderInfo(ReaderInfo readerInfo) {
		//数据校验
		//进行查询
		Integer row = readerInfoDao.updateReaderInfo(readerInfo);
		//返回结果	
		return row;
	}

}
