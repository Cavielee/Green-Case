package cn.cavie.green.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cavie.green.bean.Page;
import cn.cavie.green.mapper.GoodsMapper;
import cn.cavie.green.mapper.PointGoodsMapper;
import cn.cavie.green.po.Goods;
import cn.cavie.green.po.PointGoods;
import cn.cavie.green.service.GoodsService;
import cn.cavie.green.vo.CreateGoodsForm;
import cn.cavie.green.vo.CreatePointGoodsForm;

@Service("goodsService")
@Transactional
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

	// 积分商品
	@Autowired
	private PointGoodsMapper pointGoodsMapper;

	// 获得带分页的商品列表
	@Override
	public Page<Goods> findGoodsWithPage(int pageNum, int pageSize) throws Exception {

		// 查询商品总数
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

	// 通过id查询商品详细信息
	@Override
	public Goods findGoodsByGoods_id(int goods_id) throws Exception {
		return goodsMapper.findGoodsByGoods_id(goods_id);
	}

	// 随机查询所有类型N条积分商品记录
	@Override
	public HashMap<String, List<PointGoods>> findPointGoodsByAllTypeRand(int num) throws Exception {
		HashMap<String, List<PointGoods>> map = new HashMap<String, List<PointGoods>>();
		if (num == 0)
			return map;
		// 查询各种类商品
		List<PointGoods> life = pointGoodsMapper.findPointGoodsByTypeRand("生活", num);
		List<PointGoods> food = pointGoodsMapper.findPointGoodsByTypeRand("美食", num);
		List<PointGoods> movie = pointGoodsMapper.findPointGoodsByTypeRand("电影", num);
		List<PointGoods> other = pointGoodsMapper.findPointGoodsByTypeRand("其他", num);
		// 放入map
		map.put("life", life);
		map.put("food", food);
		map.put("movie", movie);
		map.put("other", other);

		return map;
	}

	// 获得某类型带分页的积分商品列表
	@Override
	public Page<PointGoods> findPointGoodsWithTypePage(String type, int pageNum, int pageSize) throws Exception {
		// 查询该类型积分商品总数
		int totalRecord = pointGoodsMapper.countPointGoodsWithType(type);

		// 创建分页
		Page<PointGoods> page = new Page<PointGoods>(pageNum, pageSize, totalRecord);

		// 获取该页的的积分商品
		List<PointGoods> list = pointGoodsMapper.findPointGoodsWithTypePage(type, pageSize, page.getStartIndex());
		page.setList(list);

		return page;
	}

	// 获得带分页的积分商品列表
	@Override
	public Page<PointGoods> findPointGoodsWithPage(int pageNum, int pageSize) throws Exception {

		// 查询积分商品总数
		int totalRecord = pointGoodsMapper.countPointGoods();

		// 创建分页
		Page<PointGoods> page = new Page<PointGoods>(pageNum, pageSize, totalRecord);

		// 获取该页的的积分商品
		List<PointGoods> list = pointGoodsMapper.findPointGoodsPage(pageSize, page.getStartIndex());
		page.setList(list);

		return page;
	}

	// 商品名查重
	@Override
	public boolean duplicateCheckingGoods(String name) throws Exception {
		if (goodsMapper.duplicateCheckingGoods(name) == null) {
			// 商品名不重复
			return false;
		} else {
			// 商品名重复
			return true;
		}
	}

	// 积分商品名查重
	@Override
	public boolean duplicateCheckingPointGoods(String name) throws Exception {
		if (pointGoodsMapper.duplicateCheckingPointGoods(name) == null) {
			// 商品名不重复
			return false;
		} else {
			// 商品名重复
			return true;
		}
	}

	// 添加商品
	@Override
	public int insertGoods(CreateGoodsForm createGoodsForm) throws Exception {
		return goodsMapper.insertGoods(createGoodsForm);
	}

	// 添加积分商品
	@Override
	public int insertPointGoods(CreatePointGoodsForm createPointGoodsForm) throws Exception {
		return pointGoodsMapper.insertPointGoods(createPointGoodsForm);
	}

	// 删除商品
	@Override
	public int deleteGoods(String[] goodsName) throws Exception {
		// 删除商品
		int result = goodsMapper.deleteGoods(goodsName);
		return result;
	}

	// 删除积分商品
	@Override
	public int deletePointGoods(String[] goodsName) throws Exception {
		// 删除积分商品
		int result = pointGoodsMapper.deletePointGoods(goodsName);
		return result;
	}

}
