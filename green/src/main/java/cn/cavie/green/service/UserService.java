package cn.cavie.green.service;

import cn.cavie.green.bean.Page;
import cn.cavie.green.po.User;
import cn.cavie.green.vo.CreateWorkForm;
import cn.cavie.green.vo.EditInfoForm;
import cn.cavie.green.vo.LoginUserForm;
import cn.cavie.green.vo.UserInfo;
import cn.cavie.green.vo.result.LoginResultMessage;

public interface UserService {
	// 根据用户id查询用户
	public User findUserById(int user_id) throws Exception;

	// 根据用户名查询用户
	public User findUserByUserName(String username) throws Exception;

	// 根据用户名查询用户id
	public int findUser_idByUserName(String username) throws Exception;

	// 登录校验
	public LoginResultMessage checkLogin(LoginUserForm loginUserForm) throws Exception;

	// 注册用户
	public int insertUser(User user) throws Exception;

	// 注册工作人员
	public int insertWork(CreateWorkForm createWorkForm) throws Exception;

	// 通过用户id获取用户信息
	public UserInfo getUserInfoById(int user_id) throws Exception;

	// 通过用户名获取用户信息
	public UserInfo getUserInfoByUserName(String username) throws Exception;

	// 根据用户id查询用户积分
	public int findPointByUser_id(int user_id) throws Exception;

	// 更新用户积分
	public int updateUserPoint(int user_id, int point) throws Exception;

	// 更新用户信息
	public int updateUserInfo(EditInfoForm editInfoForm) throws Exception;

	// 删除工作人员用户
	public int deleteWorks(String[] worksName) throws Exception;

	// 获得带分页的订单工作人员列表
	public Page<String> findOrderWorks(int pageNum, int pageSize) throws Exception;

	// 获得带分页的商品工作人员列表
	public Page<String> findGoodsWorks(int pageNum, int pageSize) throws Exception;
}
