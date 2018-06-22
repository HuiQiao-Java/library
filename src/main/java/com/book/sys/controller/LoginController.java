package com.book.sys.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.common.vo.JsonResult;
import com.book.service.LoginService;

@RequestMapping("/api")
@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/loginCheck")
	@ResponseBody
	public JsonResult loginCheck(Integer id ,String passwd,HttpServletRequest request) {
//		System.out.println("id="+id+",password="+passwd);
		boolean isAdmin = loginService.isAdmin(id, passwd);
		boolean isReader = loginService.isReader(id, passwd);
//		System.out.println(request);
		HashMap<String,Object> result = new HashMap<>();
		if(!isAdmin&&!isReader) {
			result.put("stateCode", 0);
			result.put("message","账号或用户名不存在，请重新输入");
		}else if(isAdmin) {
			result.put("stateCode", 1);
			result.put("message","登陆成功，正在跳转");
		}else if(isReader) {
			result.put("stateCode", 2);
			result.put("message","登陆成功，正在跳转");
			request.getSession().setAttribute("readerCard","______");
		}
		return new JsonResult(result);
	}
}
