package cn.cavie.green.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cavie.green.mapper.User_AuthoritiesMapper;
import cn.cavie.green.service.User_AuthoritiesService;

@Service("user_AuthoritiesService")
@Transactional
public class User_AuthoritiesServiceImpl implements User_AuthoritiesService {

	@Autowired
	private User_AuthoritiesMapper user_AuthoritiesMapper;

	@Override
	public int insertDefaultAuthorities(int user_id) throws Exception {

		return user_AuthoritiesMapper.insertDefaultAuthorities(user_id);
	}

}
