package cn.cavie.green.mapper;

import java.util.HashMap;

public interface User_AuthoritiesMapper {

	// 根据用户Id添加权限记录
	public int insertDefaultAuthorities(int user_id) throws Exception;

	// 根据用户Id添加工作人员权限记录
	public int insertWorkAuthorities(HashMap<String, Integer> user_authorities) throws Exception;

	// 删除工作人员用户权限
	public int deleteWorksAuthorities(String[] worksName) throws Exception;
}
