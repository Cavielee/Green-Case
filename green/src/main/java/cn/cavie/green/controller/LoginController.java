package cn.cavie.green.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	// 登录
	@RequestMapping("/login")
	public String toLogin(HttpServletRequest request) throws Exception {
		// 检查是否已登录
		return "login";
	}
}
