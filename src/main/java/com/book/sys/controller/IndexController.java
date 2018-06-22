package com.book.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.book.common.vo.JsonResult;

@RequestMapping("/")
@Controller
public class IndexController {

	@RequestMapping("reader_main")
	public String readerMain() {
		return "reader_main";
	}
	
	@RequestMapping("admin_main")
	public String adminMain() {
		return "admin_main";
	}
	
	@RequestMapping("index")
	public String loginUI() {
		return "index";
	}
	
	

}