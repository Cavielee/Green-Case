package cn.cavie.green.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cavie.green.bean.CreateImageCode;
import cn.cavie.green.po.User;
import cn.cavie.green.service.UserService;
import cn.cavie.green.vo.RegeditUserForm;
import cn.cavie.green.vo.result.ResultMessage;

@Controller
public class RegeditController {

	@Autowired
	private UserService userService;

	// 跳转到注册页面
	@PreAuthorize("anonymous")
	@RequestMapping("/regedit")
	public String toRegedit() throws Exception {
		return "regedit";
	}

	// 生成验证码
	@PreAuthorize("anonymous")
	@RequestMapping("/createValidateCode")
	public void createValidateCode(HttpSession session, HttpServletResponse response) throws Exception {
		// 设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		/**
		 * width:100 height:42 4个字符 10条干扰线
		 */
		CreateImageCode vCode = new CreateImageCode(100, 42, 4, 10);
		session.setAttribute("code", vCode.getCode());
		vCode.write(response.getOutputStream());
	}

	// 注册用户
	@PreAuthorize("anonymous")
	@RequestMapping("/regeditUser")
	public @ResponseBody ResultMessage regeditUser(HttpSession session,
			@RequestBody @Validated RegeditUserForm regeditUserForm, BindingResult bindingResult) throws Exception {

		ResultMessage result = new ResultMessage();
		// 参数错误放回400
		if (bindingResult.hasErrors()) {
			result.setUrl("error/400");
			return result;
		}
		// 验证验证码
		if ( !session.getAttribute("code").equals(regeditUserForm.getVdcode())) {
			result.setMsg("验证码错误");
			return result;
		}
		
		// 用户名查重
		if (userService.findUserByUserName(regeditUserForm.getUsername()) != null) {
			result.setMsg("用户名已存在");
			return result;
		}

		// 添加用户及用户权限
		User user = new User();
		BeanUtils.copyProperties(regeditUserForm, user);
		int userResult = userService.insertUser(user);

		// 判断是否成功
		if (userResult == 0) {
			result.setMsg("注册失败");
			result.setUrl("regedit");
			return result;
		}
		result.setUrl("login");
		return result;

	}
}
