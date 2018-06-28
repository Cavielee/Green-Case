package cn.cavie.green.service;

public interface User_AuthoritiesService {

	// 根据用户Id添加权限记录
	public int insertDefaultAuthorities(int user_id) throws Exception;
}
