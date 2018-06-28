package cn.cavie.green.mapper;

import java.util.HashMap;
import java.util.List;

import cn.cavie.green.po.Video;

public interface VideoMapper {

	// 查询带分页的所有视频信息
	public List<Video> findVideoListWithPage(HashMap<String, Integer> pageMap) throws Exception;

	// 根据id查询视频信息
	public Video findVideoByVideo_id(int video_id) throws Exception;

	// 随机查询N条视频记录
	public List<Video> findVideoByRand(int num) throws Exception;

	// 查询视频总数
	public int countVideo() throws Exception;
}
