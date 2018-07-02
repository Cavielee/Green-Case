package cn.cavie.green.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cavie.green.po.ReuseOrder;
import cn.cavie.green.vo.SaveOrderForm;

public interface OrderMapper {
	// 添加回收订单
	public int insertOrder(ReuseOrder reuseOrder) throws Exception;

	// 根据order_id查询订单信息
	public ReuseOrder findOrderById(int order_id) throws Exception;

	// 根据order_id查询user_id
	public int findUser_idByOrder_id(int order_id) throws Exception;

	// 根据order_id删除订单
	public int deleteOrderById(HashMap<String, Integer> user_order) throws Exception;

	// 通过分页查询用户所有订单信息
	public List<ReuseOrder> findUserOrdersWithPage(HashMap<String, Integer> pageMap) throws Exception;

	// 通过分页查询所有未处理订单信息
	public List<HashMap<String, String>> findUntreatedOrdersWithPage(HashMap<String, Integer> pageMap) throws Exception;

	// 查询未处理订单详情
	public HashMap<String, Object> findOrderDetail(@Param("order_id") int order_id, @Param("username") String username)
			throws Exception;

	// 确认订单已回收
	public int updateOrderStatus(int order_id) throws Exception;

	// 查询用户订单总数
	public int countUserOrders(int user_id) throws Exception;

	// 查询未处理订单总数
	public int countUntreatedOrders() throws Exception;

	// 根据SRV_TIME_END查询用户订单
	public ReuseOrder findUserOrderBySRV_TIME_END(SaveOrderForm savaOrderForm) throws Exception;
}
