package cn.cavie.green.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cavie.green.bean.Page;
import cn.cavie.green.mapper.GoodsMapper;
import cn.cavie.green.po.Goods;
import cn.cavie.green.service.GoodsService;
import cn.cavie.green.vo.CreateGoodsForm;

@Service("goodsService")
@Transactional
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

	// 获得带分页的订单列表
	@Override
	public Page<Goods> findGoodsWithPage(int pageNum, int pageSize) throws Exception {

		// 查询用户订单总数
		int totalRecord = goodsMapper.countGoods();

		// 创建分页
		Page<Goods> page = new Page<Goods>(pageNum, pageSize, totalRecord);

		HashMap<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("pageSize", pageSize);
		pageMap.put("startIndex", page.getStartIndex());

		List<Goods> list = goodsMapper.findGoodsWithPage(pageMap);
		page.setList(list);

		return page;
	}

	// 随机查询N条商品记录
	@Override
	public List<Goods> findGoodsByRand(int num) throws Exception {
		List<Goods> list = goodsMapper.findGoodsByRand(num);
		return list;
	}

	// 商品名查重
	@Override
	public boolean duplicateChecking(String name) throws Exception {
		if (goodsMapper.duplicateChecking(name) == null) {
			// 商品名不重复
			return false;
		} else {
			// 商品名重复
			return true;
		}
	}

	// 通过id查询商品详细信息
	@Override
	public Goods findGoodsByGoods_id(int goods_id) throws Exception {
		return goodsMapper.findGoodsByGoods_id(goods_id);
	}

	// 添加商品
	@Override
	public int insertGoods(CreateGoodsForm createGoodsForm) throws Exception {
		return goodsMapper.insertGoods(createGoodsForm);
	}

	// 删除商品
	@Override
	public int deleteGoods(String[] goodsName) throws Exception {
		int result = 0;
		// 删除工作人员用户权限
		result = goodsMapper.deleteGoods(goodsName);
		return result;
	}

}
