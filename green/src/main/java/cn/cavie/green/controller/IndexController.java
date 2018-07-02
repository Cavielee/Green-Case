package cn.cavie.green.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cavie.green.po.Goods;
import cn.cavie.green.po.Video;
import cn.cavie.green.service.GoodsService;
import cn.cavie.green.service.VideoService;

@Controller
public class IndexController {

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private VideoService videoService;

	// 跳转到首页
	@PreAuthorize("permitAll()")
	@RequestMapping("/index")
	public String index(HttpServletRequest request) throws Exception {
		// 随机查询4条商品记录
		int goods_num = 4;
		// 随机查询2两视频记录
		int video_num = 2;

		List<Goods> gd_list = goodsService.findGoodsByRand(goods_num);
		request.setAttribute("gd_list", gd_list);

		List<Video> vd_list = videoService.findVideoByRand(video_num);
		request.setAttribute("vd_list", vd_list);

		return "index";
	}
}
