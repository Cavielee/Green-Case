package cn.cavie.green.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cavie.green.bean.Page;
import cn.cavie.green.mapper.OrderMapper;
import cn.cavie.green.po.ReuseOrder;
import cn.cavie.green.service.OrderService;
import cn.cavie.green.service.PointRecordService;
import cn.cavie.green.service.UserService;
import cn.cavie.green.vo.OrderList;
import cn.cavie.green.vo.SaveOrderForm;
import cn.cavie.green.vo.result.OrderResultMessage;
import cn.cavie.green.vo.result.OrderSuccessResult;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private UserService userService;

	@Autowired
	private PointRecordService pointRecordService;

	// 插入order
	@Override
	public OrderResultMessage insertOrder(SaveOrderForm saveOrderForm) throws Exception {
		OrderResultMessage result = new OrderResultMessage();
		ReuseOrder reuseOrder = new ReuseOrder();
		BeanUtils.copyProperties(saveOrderForm, reuseOrder);
		int inserResult = orderMapper.insertOrder(reuseOrder);
		if (inserResult == 0) {
			result.setMsg("操作失败");
			result.setUrl("error/failure");
		} else {
			result.setOrder_id(reuseOrder.getOrder_id());
			result.setUrl("successOrder");
		}
		return result;
	}

	// 根据order_id查询订单信息
	@Override
	public OrderSuccessResult findOrderById(int order_id) throws Exception {
		OrderSuccessResult result = new OrderSuccessResult();
		ReuseOrder order = orderMapper.findOrderById(order_id);
		result.setSRV_TIME_END(order.getSRV_TIME_END().getTime());
		result.setOrder_id(order.getOrder_id());
		return result;
	}

	// 根据order_id删除订单
	@Override
	public int deleteOrderById(int user_id, int order_id) throws Exception {
		HashMap<String, Integer> user_order = new HashMap<String, Integer>();
		user_order.put("user_id", user_id);
		user_order.put("order_id", order_id);
		return orderMapper.deleteOrderById(user_order);
	}

	// 获得带分页的订单列表
	@Override
	public Page<OrderList> findUserOrdersWithPage(int pageNum, int pageSize, int user_id) throws Exception {
		// 查询用户订单总数
		int totalRecord = orderMapper.countUserOrders(user_id);

		// 创建分页
		Page<OrderList> page = new Page<OrderList>(pageNum, pageSize, totalRecord);

		// 查询用户订单信息
		List<OrderList> orders = new ArrayList<OrderList>();

		HashMap<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("user_id", user_id);
		pageMap.put("pageSize", pageSize);
		pageMap.put("startIndex", page.getStartIndex());

		List<ReuseOrder> reuseOrders = orderMapper.findUserOrdersWithPage(pageMap);
		for (ReuseOrder order : reuseOrders) {
			OrderList orderResult = new OrderList();
			BeanUtils.copyProperties(order, orderResult);
			DateFormat format_from = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
			DateFormat format_end = new SimpleDateFormat("yyyy年MM月dd日");
			orderResult.setSRV_TIME_FROM(format_from.format(order.getSRV_TIME_FROM()));
			Calendar cal = Calendar.getInstance();
			cal.setTime(order.getSRV_TIME_END());
			orderResult.setSRV_TIME_END(format_end.format(order.getSRV_TIME_END()) + " " + cal.get(Calendar.HOUR_OF_DAY)
					+ ":00 -" + (cal.get(Calendar.HOUR_OF_DAY) + 1) + ":00");
			orders.add(orderResult);
		}
		page.setList(orders);

		return page;
	}

	// 获得带分页的未处理订单
	@Override
	public Page<HashMap<String, String>> findUntreatedOrdersWithPage(int pageNum, int pageSize) throws Exception {
		// 查询未处理订单总数
		int totalRecord = orderMapper.countUntreatedOrders();

		// 创建分页
		Page<HashMap<String, String>> page = new Page<HashMap<String, String>>(pageNum, pageSize, totalRecord);

		HashMap<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("pageSize", pageSize);
		pageMap.put("startIndex", page.getStartIndex());

		List<HashMap<String, String>> list = orderMapper.findUntreatedOrdersWithPage(pageMap);

		page.setList(list);

		return page;
	}

	@Override
	public HashMap<String, Object> findOrderDetail(int order_id, String username) throws Exception {

		HashMap<String, Object> orderDetail = orderMapper.findOrderDetail(order_id, username);

		return orderDetail;
	}

	// 订单回收
	@Override
	public int orderRecycle(int order_id) throws Exception {
		// 更新订单状态为已回收
		int result = orderMapper.updateOrderStatus(order_id);
		if (result == 0) {
			return 0;
		}
		// 获取user_id
		int user_id = orderMapper.findUser_idByOrder_id(order_id);

		// 添加积分记录
		result = pointRecordService.createOrderPointRecord(user_id, "回收纸盒成功", 100);
		if (result == 0) {
			return 0;
		}

		// 更新用户积分
		result = userService.updateUserPoint(user_id, 100);
		if (result == 0) {
			return 0;
		}
		return result;
	}

	// 订单查重
	@Override
	public ReuseOrder existeUserOrder(SaveOrderForm savaOrderForm) throws Exception {

		return orderMapper.findUserOrderBySRV_TIME_END(savaOrderForm);
	}

}
