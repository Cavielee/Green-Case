package cn.cavie.green.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

	// 跳转到400
	@PreAuthorize("permitAll()")
	@RequestMapping("/error/400")
	public String to400() throws Exception {
		return "error/400";
	}

	// 跳转到403
	@PreAuthorize("permitAll()")
	@RequestMapping("/error/403")
	public String to403() throws Exception {
		return "error/403";
	}

	// 跳转到404
	@PreAuthorize("permitAll()")
	@RequestMapping("/error/404")
	public String to404() throws Exception {
		return "error/404";
	}

	// 跳转到500
	@PreAuthorize("permitAll()")
	@RequestMapping("/error/500")
	public String to500() throws Exception {
		return "error/500";
	}

	// 未知错误跳转到500
	@PreAuthorize("permitAll()")
	@RequestMapping("/undefined")
	public String undefined() throws Exception {
		return "error/500";
	}
	// 异处登陆过
	@PreAuthorize("permitAll()")
	@RequestMapping("/error/expired")
	public String expired() throws Exception {
		return "error/expired";
	}
}
