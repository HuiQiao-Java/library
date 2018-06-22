package com.book.sys.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.common.vo.JsonResult;
import com.book.domain.ReaderInfo;
import com.book.service.ReaderInfoService;

@RequestMapping("/user")
@Controller
public class ReaderController {
	@Autowired
	private ReaderInfoService readerinfo;
	
	
	@RequestMapping("/listUI")
	public String ListUI() {
		return "reader_info_ajax";
	}
	
	@RequestMapping("/readerinfo")
	@ResponseBody
	public JsonResult readerInfo(Long readerid) {
		ReaderInfo result = readerinfo.quaryReaderInfo(readerid);
		System.out.println(result);
		JsonResult jsonResult = new JsonResult(result);
		System.out.println(jsonResult);
		return new JsonResult(result);
	}
	
	@RequestMapping("/updateUserInfo")
	@ResponseBody
	public JsonResult updateUserInfo(ReaderInfo readerInfo) {
//		System.out.println(readerInfo);
		readerinfo.updateReaderInfo(readerInfo);
		return new JsonResult("update ok");
	}
}
