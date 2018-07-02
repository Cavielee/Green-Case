package cn.cavie.green.mapper;

import java.util.HashMap;
import java.util.List;

import cn.cavie.green.po.User;
import cn.cavie.green.vo.CreateWorkForm;
import cn.cavie.green.vo.EditInfoForm;

public interface UserMapper {

	// 根据用户id查询用户
	public User findUserById(int user_id) throws Exception;

	// 根据用户名查询用户
	public User findUserByUserName(String username) throws Exception;

	// 根据用户名查询用户id
	public Integer findUser_idByUserName(String username) throws Exception;

	// 查询订单工作人员总数
	public Integer countOrderWorks() throws Exception;

	// 查询商品工作人员总数
	public Integer countGoodsWorks() throws Exception;

	// 查询order工作人员用户名
	public List<String> findOrderWorks(HashMap<String, Integer> pageMap) throws Exception;

	// 查询goods工作人员用户名
	public List<String> findGoodsWorks(HashMap<String, Integer> pageMap) throws Exception;

	// 注册用户
	public int insertUser(User user) throws Exception;

	// 根据用户id查询用户积分
	public Integer findPointByUser_id(int user_id) throws Exception;

	// 注册工作人员用户
	public int insertWork(CreateWorkForm createWorkForm) throws Exception;

	// 更新用户积分
	public int updateUserPoint(User user) throws Exception;

	// 更新用户信息
	public int updateUserInfo(EditInfoForm editInfoForm) throws Exception;

	// 删除工作人员用户
	public int deleteWorks(String[] worksName) throws Exception;
}
