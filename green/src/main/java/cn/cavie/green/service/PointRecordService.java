package cn.cavie.green.service;

import cn.cavie.green.bean.Page;
import cn.cavie.green.vo.PointRecordList;

public interface PointRecordService {
	// 根据用户Id添加积分记录
	public int createOrderPointRecord(int user_id, String description, int point) throws Exception;
	
	// 通过用户id查询积分记录
	public Page<PointRecordList> findPointRecordByUser_id(int pageNum, int pageSize, int user_id) throws Exception;
}
