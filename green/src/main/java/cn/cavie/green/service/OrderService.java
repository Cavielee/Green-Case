package cn.cavie.green.service;

import java.util.HashMap;

import cn.cavie.green.bean.Page;
import cn.cavie.green.po.ReuseOrder;
import cn.cavie.green.vo.OrderList;
import cn.cavie.green.vo.SaveOrderForm;
import cn.cavie.green.vo.User_Order;
import cn.cavie.green.vo.result.OrderResultMessage;
import cn.cavie.green.vo.result.OrderSuccessResult;

public interface OrderService {

	// 添加回收订单
	public OrderResultMessage insertOrder(SaveOrderForm saveOrderForm) throws Exception;

	// 根据order_id查询订单信息
	public OrderSuccessResult findOrderById(int order_id) throws Exception;

	// 根据order_id删除订单
	public int deleteOrderById(int user_id, int order_id) throws Exception;

	// 获得带分页的订单列表
	public Page<OrderList> findUserOrdersWithPage(int pageNum, int pageSize, int user_id) throws Exception;

	// 获得带分页的未处理订单
	public Page<HashMap<String, String>> findUntreatedOrdersWithPage(int pageNum, int pageSize) throws Exception;

	// 查询未处理订单详情
	public HashMap<String, Object> findOrderDetail(User_Order user_order) throws Exception;

	// 订单回收
	public int orderRecycle(int order_id) throws Exception;

	// 订单查重
	public ReuseOrder existeUserOrder(SaveOrderForm savaOrderForm) throws Exception;
}
