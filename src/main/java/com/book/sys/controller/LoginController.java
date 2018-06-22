package com.book.sys.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.common.vo.JsonResult;
import com.book.domain.ReaderInfo;
import com.book.service.LoginService;
import com.book.service.ReaderInfoService;

@RequestMapping("/api")
@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	@Autowired
	ReaderInfoService readerInfoService;
	
	@RequestMapping("/loginCheck")
	@ResponseBody
	public JsonResult loginCheck(Long id ,String passwd,HttpServletRequest request) {
//		System.out.println("id="+id+",password="+passwd);
		//判断账号密码是管理员还是读者
		boolean isAdmin = loginService.isAdmin(id, passwd);
		boolean isReader = loginService.isReader(id, passwd);
		//创建封装数据的map集合
		HashMap<String,Object> result = new HashMap<>();
		if(!isAdmin&&!isReader) {
			result.put("stateCode", 0);
			result.put("message","账号或用户名不存在，请重新输入");
		}else if(isAdmin) {
			result.put("stateCode", 1);
			result.put("message","登陆成功，正在跳转");
			//根据id查询管理员信息
			ReaderInfo adminInfo = readerInfoService.quaryReaderInfo(id);
			//将数据绑定在session中,在页面跳转之后进行数据的显示
			request.getSession().setAttribute("admin", adminInfo);
		}else if(isReader) {
			result.put("stateCode", 2);
			result.put("message","登陆成功，正在跳转");
			//根据id查询用户信息
			ReaderInfo readerinfo = readerInfoService.quaryReaderInfo(id);
			//将数据绑定在session中，在页面跳转之后进行数据的显示
			request.getSession().setAttribute("reader",readerinfo);
		}
		return new JsonResult(result);
	}
}
