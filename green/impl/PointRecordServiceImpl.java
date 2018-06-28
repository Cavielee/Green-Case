package cn.cavie.green.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cavie.green.bean.Page;
import cn.cavie.green.mapper.PointRecordMapper;
import cn.cavie.green.po.PointRecord;
import cn.cavie.green.service.PointRecordService;
import cn.cavie.green.vo.PointRecordList;

@Service("pointRecordService")
@Transactional
public class PointRecordServiceImpl implements PointRecordService {

	@Autowired
	private PointRecordMapper pointMapper;

	// 根据用户Id添加积分记录
	@Override
	public int createOrderPointRecord(int user_id, String description, int point) throws Exception {

		PointRecord pointRecord = new PointRecord();
		pointRecord.setUser_id(user_id);
		pointRecord.setDescription(description);
		pointRecord.setPoint(point);

		return pointMapper.insertPointRecord(pointRecord);
	}

	// 通过用户id查询积分记录
	@Override
	public Page<PointRecordList> findPointRecordByUser_id(int pageNum, int pageSize, int user_id) throws Exception {
		// 查询用户订单总数
		int totalRecord = pointMapper.countUserPointRecord(user_id);

		// 创建分页
		Page<PointRecordList> page = new Page<PointRecordList>(pageNum, pageSize, totalRecord);
		
		HashMap<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("pageSize", pageSize);
		pageMap.put("startIndex", page.getStartIndex());
		pageMap.put("user_id", user_id);
		
		List<PointRecord> pointRecordsPo = pointMapper.findPointRecordByUser_id(pageMap);
		List<PointRecordList> pointRecordsVo = new ArrayList<PointRecordList>();

		// 将po复制为vo
		for (PointRecord pointRecord : pointRecordsPo) {
			PointRecordList pointRecordList = new PointRecordList();
			BeanUtils.copyProperties(pointRecord, pointRecordList);
			DateFormat myFormat = new SimpleDateFormat("yyyy年MM月dd日  HH时");
			pointRecordList.setCreated(myFormat.format(pointRecord.getCreated()));
			pointRecordsVo.add(pointRecordList);
		}
		page.setList(pointRecordsVo);
		
		return page;
	}
}
