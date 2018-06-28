package cn.cavie.green.mapper;

import java.util.HashMap;
import java.util.List;

import cn.cavie.green.po.Goods;
import cn.cavie.green.vo.CreateGoodsForm;

public interface GoodsMapper {

	// 查询所有商品信息
	public List<Goods> findGoodsWithPage(HashMap<String, Integer> pageMap) throws Exception;

	// 随机查询N条商品记录
	public List<Goods> findGoodsByRand(int num) throws Exception;

	// 商品名查重
	public Goods duplicateCheckingGoods(String name) throws Exception;

	// 通过id查询商品详细信息
	public Goods findGoodsByGoods_id(int goods_id) throws Exception;

	// 添加商品
	public int insertGoods(CreateGoodsForm createGoodsForm) throws Exception;

	// 查询商品总数
	public int countGoods() throws Exception;

	// 删除商品
	public int deleteGoods(String[] goodsName) throws Exception;

}
