package cn.cavie.green.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cavie.green.bean.Page;
import cn.cavie.green.mapper.VideoMapper;
import cn.cavie.green.po.Video;
import cn.cavie.green.service.VideoService;

@Service("videoService")
@Transactional
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VideoMapper videoMapper;

	// 查询带分页的商品列表
	@Override
	public Page<Video> findVideoWithPage(int pageNum, int pageSize) throws Exception {
		// 查询视频总数
		int totalRecord = videoMapper.countVideo();

		// 创建分页
		Page<Video> page = new Page<Video>(pageNum, pageSize, totalRecord);
		
		HashMap<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("pageSize", pageSize);
		pageMap.put("startIndex", page.getStartIndex());

		// 查询所有视频信息
		List<Video> list = videoMapper.findVideoListWithPage(pageMap);
		page.setList(list);

		return page;
	}

	// 根据id查询视频信息
	public Video findVideoByVideo_id(int video_id) throws Exception {
		return videoMapper.findVideoByVideo_id(video_id);
	}

	// 随机查询N条视频记录
	@Override
	public List<Video> findVideoByRand(int num) throws Exception {
		List<Video> list = videoMapper.findVideoByRand(num);
		return list;
	}

}
