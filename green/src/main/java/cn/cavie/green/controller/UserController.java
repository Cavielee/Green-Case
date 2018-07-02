package cn.cavie.green.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.cavie.green.bean.Page;
import cn.cavie.green.service.UserService;
import cn.cavie.green.vo.CreateWorkForm;
import cn.cavie.green.vo.EditInfoForm;
import cn.cavie.green.vo.UserInfo;
import cn.cavie.green.vo.result.ResultMessage;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	// 获取用户信息
	@PreAuthorize("permitAll()")
	@RequestMapping("/user")
	public String user(HttpServletRequest request, HttpSession session) throws Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getPrincipal().equals("anonymousUser") == false) {
			String username = authentication.getName();
			if (username != null) {
				UserInfo userInfo = userService.getUserInfoByUserName(username);
				request.setAttribute("userInfo", userInfo);
				return "user";
			}
		}

		return "user";
	}

	// 获取用户详细资料
	@PreAuthorize("hasRole('USER')")
	@RequestMapping("/userInfo")
	public String userInfo(HttpServletRequest request, HttpSession session) throws Exception {
		String username = userService.findAuthenticatedUserName();

		// 获取用户详细资料
		UserInfo userInfo = userService.getUserInfoByUserName(username);
		request.setAttribute("userInfo", userInfo);

		return "userInfo";

	}

	// 编辑用户资料
	@PreAuthorize("hasRole('USER')")
	@RequestMapping("/editInfo")
	public String editInfo(HttpServletRequest request, HttpSession session) throws Exception {
		String username = userService.findAuthenticatedUserName();

		// 获取用户详细资料
		UserInfo userInfo = userService.getUserInfoByUserName(username);
		request.setAttribute("userInfo", userInfo);
		return "editInfo";

	}

	// 更新用户资料
	@PreAuthorize("hasRole('USER')")
	@RequestMapping("/updateUserInfo")
	public @ResponseBody ResultMessage updateUserInfo(@RequestBody @Validated EditInfoForm editInfoForm,
			BindingResult bindingResult) throws Exception {

		ResultMessage result = new ResultMessage();
		// 参数错误放回400
		if (bindingResult.hasErrors()) {
			result.setUrl("error/400");
			return result;
		}
		String username = userService.findAuthenticatedUserName();
		// 用户名查重
		if (!username.equals(editInfoForm.getUsername())) {
			if (userService.findUserByUserName(editInfoForm.getUsername()) != null) {
				result.setMsg("用户名已存在");
				return result;
			}
		}

		editInfoForm.setUser_id(userService.findUser_idByUserName(username));

		// 更新用户信息
		if (userService.updateUserInfo(editInfoForm) == 0) {
			result.setUrl("error/failure");
			return result;
		}
		result.setUrl("userInfo");
		// 如果修改用户名则重新认证
		if (!username.equals(editInfoForm.getUsername())) {
			result.setMsg("请重新登录");
			result.setUrl("logout");
		}
		return result;
	}

	// 上传图片
	@PreAuthorize("hasAnyRole('ADMIN','ORDERWORK','GOODSWORK','USER')")
	@RequestMapping("/uploadImage")
	public @ResponseBody ResultMessage uploadImage(MultipartFile img) throws Exception {
		ResultMessage resultMessage = null;
		// 修改用户头像
		// 判断图片大小(小于5M)且非空
		if (img != null && (img.getSize() <= 5242880)) {
			// 原始图片名称
			String originalFileName = img.getOriginalFilename();

			if (originalFileName != null && originalFileName.length() > 0) {
				// 存储图片的物理路径
				String avatar_path = "H:\\upload\\pic\\";
				// 新文件名称
				String newFileName = UUID.randomUUID().toString()
						+ originalFileName.substring(originalFileName.lastIndexOf("."));
				// 上传图片
				File uploadAvatar = new java.io.File(avatar_path + newFileName);

				if (!uploadAvatar.exists()) {
					uploadAvatar.mkdirs();
				}
				// 向磁盘写文件
				img.transferTo(uploadAvatar);

				resultMessage = new ResultMessage();
				resultMessage.setMsg(newFileName);
				// editInfoForm.setAvatar(newFileName);
			}
		}
		return resultMessage;
	}

	// 显示订单工作人员
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping("/orderWorks")
	public String orderWorks(int pageNum, HttpServletRequest request) throws Exception {
		// 页面显示数量
		int pageSize = 11;
		// 获得带分页的订单工作人员列表
		Page<String> page = userService.findOrderWorks(pageNum, pageSize);
		// 判断是否存在当前页
		if (page.getTotalPage() < pageNum) {
			return "error/404";
		}
		request.setAttribute("page", page);
		return ("orderWorks");
	}

	// 显示商品工作人员
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping("/goodsWorks")
	public String goodsWorks(int pageNum, HttpServletRequest request) throws Exception {
		// 页面显示数量
		int pageSize = 11;
		// 获得带分页的商品工作人员列表
		Page<String> page = userService.findGoodsWorks(pageNum, pageSize);
		// 判断是否存在当前页
		if (page.getTotalPage() < pageNum) {
			return "error/404";
		}
		request.setAttribute("page", page);
		return ("goodsWorks");
	}

	// 删除工作人员
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping("/deleteWorks")
	public @ResponseBody ResultMessage deleteWorks(String[] worksName) throws Exception {
		ResultMessage resultMessage = new ResultMessage();
		// 判断是否为空
		if (worksName == null) {
			return resultMessage;
		}
		// 删除工作人员用户及权限
		if (userService.deleteWorks(worksName) == 0) {
			resultMessage.setUrl("error/failure");
			return resultMessage;
		}
		return resultMessage;
	}

	// 跳转到创建工作人员用户页面
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping("/toCreateWork")
	public String toCreateWork() throws Exception {
		return "createWork";
	}

	// 创建工作人员用户
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping("/createWork")
	public @ResponseBody ResultMessage createWork(@RequestBody @Validated CreateWorkForm createWorkForm,
			BindingResult bindingResult, MultipartFile user_avatar) throws Exception {
		ResultMessage resultMessage = new ResultMessage();
		// 参数错误放回400
		if (bindingResult.hasErrors()) {
			resultMessage.setUrl("error/400");
			return resultMessage;
		}
		String username = userService.findAuthenticatedUserName();
		// 用户名查重
		if (!username.equals(createWorkForm.getUsername())) {
			if (userService.findUserByUserName(createWorkForm.getUsername()) != null) {
				resultMessage.setMsg("用户名已存在");
				return resultMessage;
			}
		}

		// 添加用户
		if (userService.insertWork(createWorkForm) == 0) {
			resultMessage.setUrl("error/failure");
			return resultMessage;
		}
		if (createWorkForm.getType().equals("订单工作人员")) {
			resultMessage.setUrl("orderWorks?pageNum=1");
		} else {
			resultMessage.setUrl("goodsWorks?pageNum=1");
		}
		return resultMessage;
	}
}
