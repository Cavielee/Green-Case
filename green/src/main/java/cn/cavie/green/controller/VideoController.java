package cn.cavie.green.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.cavie.green.bean.Page;
import cn.cavie.green.po.Video;
import cn.cavie.green.service.VideoService;
import cn.cavie.green.vo.result.ResultMessage;

@Controller
public class VideoController {
	@Autowired
	private VideoService videoService;

	// 观看视频
	@PreAuthorize("permitAll")
	@RequestMapping("/video/{video_id}")
	public String video(@PathVariable int video_id, HttpServletRequest request) throws Exception {
		if (video_id == 0) {
			return "error/400";
		}
		Video video = videoService.findVideoByVideo_id(video_id);
		if (video == null) {
			return "error/400";
		}
		request.setAttribute("video", video);
		return "video";
	}

	// 视频列表
	@PreAuthorize("permitAll")
	@RequestMapping("/videoList")
	public String videoList(int pageNum, HttpServletRequest request) throws Exception {
		// 页面显示数量
		int pageSize = 6;
		// 获得带分页的视频列表
		Page<Video> page = videoService.findVideoWithPage(pageNum, pageSize);
		// 判断是否存在当前页
		if (page.getTotalPage() < pageNum) {
			return "error/404";
		}
		request.setAttribute("page", page);
		return "videoList";
	}

	// 上传图片
	@RequestMapping("/uploadVideo")
	public @ResponseBody ResultMessage uploadVideo(MultipartFile video) throws Exception {
		ResultMessage resultMessage = null;
		// 判断非空
		if (video != null) {
			// 原始视频名称
			String originalFileName = video.getOriginalFilename();

			if (originalFileName != null && originalFileName.length() > 0) {
				// 存储视频的物理路径
				String avatar_path = "H:\\upload\\video\\";
				// 新文件名称
				String newFileName = UUID.randomUUID().toString()
						+ originalFileName.substring(originalFileName.lastIndexOf("."));
				// 上传视频
				File uploadVideo = new java.io.File(avatar_path + newFileName);

				if (!uploadVideo.exists()) {
					uploadVideo.mkdirs();
				}
				// 向磁盘写文件
				video.transferTo(uploadVideo);

				resultMessage = new ResultMessage();
				resultMessage.setMsg(newFileName);
				// editInfoForm.setAvatar(newFileName);
			}
		}
		return resultMessage;
	}
}
