package cn.cavie.green.service;

import java.util.HashMap;
import java.util.List;

import cn.cavie.green.bean.Page;
import cn.cavie.green.po.Goods;
import cn.cavie.green.po.PointGoods;
import cn.cavie.green.vo.CreateGoodsForm;
import cn.cavie.green.vo.CreatePointGoodsForm;

public interface GoodsService {

	// 获得带分页的商品列表
	public Page<Goods> findGoodsWithPage(int pageNum, int pageSize) throws Exception;

	// 随机查询N条视频记录
	public List<Goods> findGoodsByRand(int num) throws Exception;

	// 通过id查询商品详细信息
	public Goods findGoodsByGoods_id(int goods_id) throws Exception;

	// 随机查询所有类型N条积分商品记录
	public HashMap<String, List<PointGoods>> findPointGoodsByAllTypeRand(int num) throws Exception;

	// 获得某类型带分页的积分商品列表
	public Page<PointGoods> findPointGoodsWithTypePage(String type, int pageNum, int pageSize) throws Exception;

	// 获得带分页的积分商品列表
	public Page<PointGoods> findPointGoodsWithPage(int pageNum, int pageSize) throws Exception;

	// 商品名查重
	public boolean duplicateCheckingGoods(String name) throws Exception;

	// 积分商品名查重
	public boolean duplicateCheckingPointGoods(String name) throws Exception;

	// 添加商品
	public int insertGoods(CreateGoodsForm createGoodsForm) throws Exception;

	// 添加积分商品
	public int insertPointGoods(CreatePointGoodsForm createPointGoodsForm) throws Exception;

	// 删除商品
	public int deleteGoods(String[] goodsName) throws Exception;

	// 删除积分商品
	public int deletePointGoods(String[] goodsName) throws Exception;

}
