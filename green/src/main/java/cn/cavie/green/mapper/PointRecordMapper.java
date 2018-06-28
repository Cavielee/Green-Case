package cn.cavie.green.mapper;

import java.util.HashMap;
import java.util.List;

import cn.cavie.green.po.PointRecord;

public interface PointRecordMapper {
	// 添加积分记录
	public int insertPointRecord(PointRecord pointRecord) throws Exception;

	// 通过用户id查询积分记录
	public List<PointRecord> findPointRecordByUser_id(HashMap<String, Integer> pageMap) throws Exception;

	// 查询用户积分记录总数
	public int countUserPointRecord(int user_id) throws Exception;
}
