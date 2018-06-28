package cn.cavie.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

	// 跳转到400
	@RequestMapping("/error/400")
	public String to400() throws Exception {
		return "error/400";
	}

	// 跳转到403
	@RequestMapping("/error/403")
	public String to403() throws Exception {
		return "error/403";
	}

	// 跳转到404
	@RequestMapping("/error/404")
	public String to404() throws Exception {
		return "error/404";
	}

	// 跳转到500
	@RequestMapping("/error/500")
	public String to500() throws Exception {
		return "error/500";
	}

	// 未知错误跳转到500
	@RequestMapping("/undefined")
	public String undefined() throws Exception {
		return "error/500";
	}
	// 异处登陆过
	@RequestMapping("/error/expired")
	public String expired() throws Exception {
		return "error/expired";
	}
}
