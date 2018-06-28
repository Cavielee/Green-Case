package cn.cavie.green.service;

import java.util.List;

import cn.cavie.green.bean.Page;
import cn.cavie.green.po.Video;

public interface VideoService {
	// 查询带分页的商品列表
	public Page<Video> findVideoWithPage(int pageNum, int pageSize) throws Exception;

	// 根据id查询视频信息
	public Video findVideoByVideo_id(int video_id) throws Exception;
	
	// 随机查询N条商品记录
	public List<Video> findVideoByRand(int num) throws Exception;
}
