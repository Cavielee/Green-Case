package cn.cavie.green.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cavie.green.bean.Page;
import cn.cavie.green.mapper.UserMapper;
import cn.cavie.green.mapper.User_AuthoritiesMapper;
import cn.cavie.green.po.User;
import cn.cavie.green.service.UserService;
import cn.cavie.green.vo.CreateWorkForm;
import cn.cavie.green.vo.EditInfoForm;
import cn.cavie.green.vo.LoginUserForm;
import cn.cavie.green.vo.UserInfo;
import cn.cavie.green.vo.result.LoginResultMessage;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private User_AuthoritiesMapper user_AuthoritiesMapper;

	@Override
	// 根据用户id查询用户
	public User findUserById(int user_id) throws Exception {
		return userMapper.findUserById(user_id);
	}

	@Override
	// 根据用户名查询用户
	public User findUserByUserName(String username) throws Exception {
		return userMapper.findUserByUserName(username);
	}

	@Override
	// 登录校验
	public LoginResultMessage checkLogin(LoginUserForm loginUserForm) throws Exception {

		LoginResultMessage result = new LoginResultMessage();
		User user = userMapper.findUserByUserName(loginUserForm.getUsername());
		if (user != null) {
			if (user.getPassword().equals(loginUserForm.getPassword())) {
				result.setUrl("index");
				result.setUser_id(user.getUser_id());
			} else {
				result.setMsg("密码不正确");
			}
		} else {
			result.setMsg("用户不存在");
		}

		return result;

	}

	@Override
	// 用户注册
	public int insertUser(User user) throws Exception {
		// md5加密
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		user.setPassword(md5.encodePassword(user.getPassword(), null));
		// 添加用户
		int result = userMapper.insertUser(user);
		if (result != 0) {
			// 添加用户权限
			result = user_AuthoritiesMapper.insertDefaultAuthorities(user.getUser_id());
		}
		return result;
	}

	@Override
	// 用户注册
	public int insertWork(CreateWorkForm createWorkForm) throws Exception {
		// md5加密
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		createWorkForm.setPassword(md5.encodePassword(createWorkForm.getPassword(), null));
		// 添加工作人员用户
		int result = userMapper.insertWork(createWorkForm);
		if (result != 0) {
			// 添加工作人员用户权限
			HashMap<String, Integer> user_authorities = new HashMap<String, Integer>();
			user_authorities.put("user_id", createWorkForm.getUser_id());
			if (createWorkForm.getType().equals("订单工作人员")) {
				user_authorities.put("authorities_id", 3);
			} else if (createWorkForm.getType().equals("商品工作人员")) {
				user_authorities.put("authorities_id", 4);
			}
			result = user_AuthoritiesMapper.insertWorkAuthorities(user_authorities);
		}

		return result;
	}

	// 通过用户id获取用户信息
	@Override
	public UserInfo getUserInfoById(int user_id) throws Exception {
		UserInfo userInfo = new UserInfo();
		User user = userMapper.findUserById(user_id);
		BeanUtils.copyProperties(user, userInfo);
		return userInfo;
	}

	// 通过用户名获取用户信息
	@Override
	public UserInfo getUserInfoByUserName(String username) throws Exception {
		UserInfo userInfo = new UserInfo();
		User user = userMapper.findUserByUserName(username);
		BeanUtils.copyProperties(user, userInfo);
		return userInfo;
	}

	// 通过用户名获取用户id
	@Override
	public int findUser_idByUserName(String username) throws Exception {
		return userMapper.findUser_idByUserName(username);
	}

	@Override
	public int findPointByUser_id(int user_id) throws Exception {
		return userMapper.findPointByUser_id(user_id);
	}

	@Override
	public int updateUserPoint(int user_id, int point) throws Exception {
		User user = new User();
		user.setUser_id(user_id);
		user.setPoint(point);
		return userMapper.updateUserPoint(user);
	}

	// 更新用户信息
	@Override
	public int updateUserInfo(EditInfoForm editInfoForm) throws Exception {

		return userMapper.updateUserInfo(editInfoForm);
	}

	// 删除工作人员用户
	@Override
	public int deleteWorks(String[] worksName) throws Exception {
		int result = 0;
		// 删除工作人员用户权限
		if (user_AuthoritiesMapper.deleteWorksAuthorities(worksName) != 0) {
			// 删除工作人员用户
			result = userMapper.deleteWorks(worksName);
		}
		return result;
	}

	// 获得带分页的订单工作人员列表
	@Override
	public Page<String> findOrderWorks(int pageNum, int pageSize) throws Exception {

		// 查询用户订单总数
		int totalRecord = userMapper.countOrderWorks();

		// 创建分页
		Page<String> page = new Page<String>(pageNum, pageSize, totalRecord);

		HashMap<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("pageSize", pageSize);
		pageMap.put("startIndex", page.getStartIndex());

		List<String> list = userMapper.findOrderWorks(pageMap);

		page.setList(list);

		return page;
	}

	// 获得带分页的商品工作人员列表
	@Override
	public Page<String> findGoodsWorks(int pageNum, int pageSize) throws Exception {

		// 查询用户订单总数
		int totalRecord = userMapper.countGoodsWorks();

		// 创建分页
		Page<String> page = new Page<String>(pageNum, pageSize, totalRecord);

		HashMap<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("pageSize", pageSize);
		pageMap.put("startIndex", page.getStartIndex());

		List<String> list = userMapper.findGoodsWorks(pageMap);
		page.setList(list);

		return page;
	}

	// 获取认证用户的id
	@Override
	public int findAuthenticatedUserId() throws Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		return this.findUser_idByUserName(username);
	}
}
