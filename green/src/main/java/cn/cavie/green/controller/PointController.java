package cn.cavie.green.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cavie.green.bean.Page;
import cn.cavie.green.po.PointGoods;
import cn.cavie.green.service.GoodsService;
import cn.cavie.green.service.PointRecordService;
import cn.cavie.green.service.UserService;
import cn.cavie.green.vo.CreatePointGoodsForm;
import cn.cavie.green.vo.PointRecordList;
import cn.cavie.green.vo.result.ResultMessage;

@Controller
public class PointController {

	@Autowired
	private PointRecordService pointRecordService;

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private UserService userService;

	@RequestMapping("/point")
	public String toPoint(HttpServletRequest request) throws Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getPrincipal().equals("anonymousUser") == false) {
			String username = authentication.getName();
			if (username != null) {
				request.setAttribute("point",
						userService.findPointByUser_id(userService.findUser_idByUserName(username)));
			}
		}
		// 查询积分商品数量
		int point_goods_num = 2;
		// 随机查询每种类型N个积分商品
		HashMap<String, List<PointGoods>> gd_map = goodsService.findPointGoodsByAllTypeRand(point_goods_num);
		request.setAttribute("gd_map", gd_map);
		return "point";
	}

	// 查看积分商品管理列表
	@RequestMapping("/pointGoodsManage")
	public String pointGoodsManage(int pageNum, HttpServletRequest request) throws Exception {
		// 页面显示数量
		int pageSize = 6;

		// 获得带分页的积分商品列表
		Page<PointGoods> page = goodsService.findPointGoodsWithPage(pageNum, pageSize);
		// 判断是否存在当前页
		if (page.getTotalPage() < pageNum) {
			return "error/404";
		}
		request.setAttribute("page", page);
		return "pointGoodsManage";
	}

	// 查看某类的积分商品列表
	@RequestMapping("/pointGoodsList/{type}")
	public String pointGoodsList(@PathVariable String type, int pageNum, HttpServletRequest request) throws Exception {
		// 页面显示数量
		int pageSize = 5;
		// 获得带分页的商品列表
		Page<PointGoods> page = goodsService.findPointGoodsWithTypePage(type, pageNum, pageSize);
		// 判断是否存在当前页
		if (page.getTotalPage() < pageNum) {
			return "error/404";
		}
		request.setAttribute("page", page);
		return "pointGoodsList";
	}

	// 添加商品
	@RequestMapping("/createPointGoods")
	public @ResponseBody ResultMessage createPointGoods(@RequestBody @Validated CreatePointGoodsForm createPointGoodsForm,
			BindingResult bindingResult) throws Exception {
		ResultMessage resultMessage = new ResultMessage();
		// 参数错误放回400
		if (bindingResult.hasErrors()) {
			resultMessage.setUrl("error/400");
			return resultMessage;
		}
		// 商品名查重
		if (goodsService.duplicateCheckingPointGoods(createPointGoodsForm.getName()) == true) {
			resultMessage.setMsg("商品已存在");
			return resultMessage;
		}

		if (goodsService.insertPointGoods(createPointGoodsForm) == 0) {
			resultMessage.setUrl("error/failure");
			return resultMessage;
		}
		resultMessage.setUrl("pointGoodsManage?pageNum=1");
		return resultMessage;
	}

	// 删除积分商品
	@RequestMapping("/deletePointGoods")
	public @ResponseBody ResultMessage deletePointGoods(String[] goodsName) throws Exception {
		ResultMessage resultMessage = new ResultMessage();
		// 判断是否为空
		if (goodsName == null) {
			return resultMessage;
		}
		// 删除商品
		if (goodsService.deletePointGoods(goodsName) == 0) {
			resultMessage.setUrl("error/failure");
			return resultMessage;
		}
		return resultMessage;
	}

	// 积分记录
	@RequestMapping("/pointRecord")
	public String pointRecord(int pageNum, HttpServletRequest request) throws Exception {
		// 页面显示数量
		int pageSize = 17;

		// 获得带分页的商品列表
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Page<PointRecordList> page = pointRecordService.findPointRecordByUser_id(pageNum, pageSize,
				userService.findUser_idByUserName(username));

		request.setAttribute("page", page);

		return "pointRecord";
	}

	// 跳转到添加商品页面
	@RequestMapping("/toCreatePointGoods")
	public String toCreatePointGoods() throws Exception {
		return "createPointGoods";
	}
}
