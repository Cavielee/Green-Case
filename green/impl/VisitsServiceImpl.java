package cn.cavie.green.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cavie.green.mapper.VisitsMapper;
import cn.cavie.green.service.VisitsService;

@Service("visitsService")
@Transactional
public class VisitsServiceImpl implements VisitsService {

	@Autowired
	private VisitsMapper visitsMapper;

	// 添加访问量
	@Override
	public void addVisits() throws Exception {
		visitsMapper.addVisits();
	}

}
