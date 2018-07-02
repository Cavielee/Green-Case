package cn.cavie.green.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cavie.green.bean.Page;
import cn.cavie.green.po.Goods;
import cn.cavie.green.service.GoodsService;
import cn.cavie.green.vo.CreateGoodsForm;
import cn.cavie.green.vo.result.ResultMessage;

@Controller
public class SaleController {
	@Autowired
	private GoodsService goodsService;

	// 显示商品列表
	@PreAuthorize("permitAll()")
	@RequestMapping("/sale")
	public String toSale(int pageNum, HttpServletRequest request) throws Exception {
		// 页面显示数量
		int pageSize = 5;
		// 获得带分页的商品列表
		Page<Goods> page = goodsService.findGoodsWithPage(pageNum, pageSize);
		// 判断是否存在当前页
		if (page.getTotalPage() < pageNum) {
			return "error/404";
		}
		request.setAttribute("page", page);
		return "sale";
	}

	// 查看商品详细信息
	@PreAuthorize("permitAll()")
	@RequestMapping("/goodsDetail/{goods_id}")
	public String goodsDetail(@PathVariable int goods_id, HttpServletRequest request) throws Exception {
		if (goods_id == 0) {
			return "error/400";
		}
		// 通过id查询商品详细信息
		Goods goods = goodsService.findGoodsByGoods_id(goods_id);

		request.setAttribute("goods", goods);
		return "goodsDetail";
	}

	// 跳转到添加商品页面
	@PreAuthorize("hasAnyRole('ADMIN','GOODSWORK')")
	@RequestMapping("/toCreateGoods")
	public String toCreateGoods() throws Exception {
		return "createGoods";
	}

	// 查看商品管理列表
	@PreAuthorize("hasAnyRole('ADMIN','GOODSWORK')")
	@RequestMapping("/goodsManage")
	public String goodsManage(int pageNum, HttpServletRequest request) throws Exception {
		// 页面显示数量
		int pageSize = 6;

		// 获得带分页的商品列表
		Page<Goods> page = goodsService.findGoodsWithPage(pageNum, pageSize);
		// 判断是否存在当前页
		if (page.getTotalPage() < pageNum) {
			return "error/404";
		}
		request.setAttribute("page", page);
		return "goodsManage";
	}

	// 添加商品
	@PreAuthorize("hasAnyRole('ADMIN','GOODSWORK')")
	@RequestMapping("/createGoods")
	public @ResponseBody ResultMessage createGoods(@RequestBody @Validated CreateGoodsForm createGoodsForm,
			BindingResult bindingResult) throws Exception {
		ResultMessage resultMessage = new ResultMessage();
		// 参数错误放回400
		if (bindingResult.hasErrors()) {
			resultMessage.setUrl("error/400");
			return resultMessage;
		}
		// 商品名查重
		if (goodsService.duplicateCheckingGoods(createGoodsForm.getName()) == true) {
			resultMessage.setMsg("商品已存在");
			return resultMessage;
		}

		if (goodsService.insertGoods(createGoodsForm) == 0) {
			resultMessage.setUrl("error/failure");
			return resultMessage;
		}
		resultMessage.setUrl("goodsManage?pageNum=1");
		return resultMessage;
	}

	// 删除商品
	@PreAuthorize("hasAnyRole('ADMIN','GOODSWORK')")
	@RequestMapping("/deleteGoods")
	public @ResponseBody ResultMessage deleteGoods(String[] goodsName) throws Exception {
		ResultMessage resultMessage = new ResultMessage();
		// 判断是否为空
		if (goodsName == null) {
			return resultMessage;
		}
		// 删除商品
		if (goodsService.deleteGoods(goodsName) == 0) {
			resultMessage.setUrl("error/failure");
			return resultMessage;
		}
		return resultMessage;
	}
}
