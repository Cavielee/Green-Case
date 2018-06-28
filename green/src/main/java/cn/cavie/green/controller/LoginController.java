package cn.cavie.green.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	// @Autowired
	// private UserService userService;

	// 登录
	@RequestMapping("/login")
	public String toLogin(HttpServletRequest request) throws Exception {
		// 检查是否已登录
		// Cookie[] cookies = request.getCookies();
		// if (cookies != null) {
		// for (Cookie cookie : cookies) {
		// if (cookie.getName().equals("user_id")) {
		// return "redirect:index";
		// }
		// }
		// }
		return "login";
	}

	// // 登录校验
	// @RequestMapping("/checkLogin")
	// public @ResponseBody LoginResultMessage checkLogin(HttpSession session,
	// HttpServletResponse response,
	// @RequestBody @Validated LoginUserForm loginUserForm, BindingResult
	// bindingResult) throws Exception {
	//
	// LoginResultMessage result;
	// // 参数错误跳转到400
	// if (bindingResult.hasErrors()) {
	// result = new LoginResultMessage();
	// result.setUrl("error/400");
	// return result;
	// }
	// // 校验
	// result = userService.checkLogin(loginUserForm);
	//
	// // 保存用户信息
	// if (result.getUser_id() != 0) {
	// session.setAttribute("user_id", result.getUser_id());
	// Cookie cookie = new Cookie("user_id", result.getUser_id() + "");
	// // 生命周期为一天
	// cookie.setMaxAge(24 * 60 * 60);
	// response.addCookie(cookie);
	// }
	//
	// return result;
	//
	// }

}
