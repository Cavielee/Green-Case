package cn.cavie.green.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cavie.green.po.PointGoods;
import cn.cavie.green.vo.CreatePointGoodsForm;

public interface PointGoodsMapper {

	// 随机查询N条类型相同积分商品记录
	public List<PointGoods> findPointGoodsByTypeRand(@Param("type") String type, @Param("num") int num)
			throws Exception;

	// 查询某类型带分页的积分商品
	public List<PointGoods> findPointGoodsWithTypePage(@Param("type") String type, @Param("pageSize") int pageSize,
			@Param("startIndex") int startIndex) throws Exception;

	// 查询带分页的积分商品
	public List<PointGoods> findPointGoodsPage(@Param("pageSize") int pageSize, @Param("startIndex") int startIndex)
			throws Exception;

	// 查询某类积分商品总数
	public int countPointGoodsWithType(String type) throws Exception;

	// 查询积分商品总数
	public int countPointGoods() throws Exception;

	// 积分商品名查重
	public PointGoods duplicateCheckingPointGoods(String name) throws Exception;

	// 添加积分商品
	public int insertPointGoods(CreatePointGoodsForm createPointGoodsForm) throws Exception;

	// 删除积分商品
	public int deletePointGoods(String[] goodsName) throws Exception;
}
