package cn.cavie.green.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cavie.green.bean.Page;
import cn.cavie.green.service.OrderService;
import cn.cavie.green.service.UserService;
import cn.cavie.green.vo.OrderList;
import cn.cavie.green.vo.SaveOrderForm;
import cn.cavie.green.vo.User_Order;
import cn.cavie.green.vo.result.OrderResultMessage;
import cn.cavie.green.vo.result.OrderSuccessResult;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	// 跳转到订单页面
	@RequestMapping("/order")
	private String toOrder() throws Exception {
		return "order";
	}

	// 保存订单
	@RequestMapping("/saveOrder")
	private @ResponseBody OrderResultMessage saveOrder(@RequestBody @Validated SaveOrderForm savaOrderForm,
			BindingResult bindingResult, HttpServletRequest request, HttpSession session) throws Exception {
		OrderResultMessage result = null;

		// 参数绑定错误返回400
		if (bindingResult.hasErrors()) {
			result = new OrderResultMessage();
			result.setUrl("error/400");
			return result;
		}

		// 获取认证用户的id
		savaOrderForm.setUser_id(userService.findAuthenticatedUserId());
		
		// 订单查重
		if (orderService.existeUserOrder(savaOrderForm) != null) {
			result = new OrderResultMessage();
			result.setMsg("订单已存在");
			return result;
		}

		// 订单保存
		result = orderService.insertOrder(savaOrderForm);
		session.setAttribute("order_id", result.getOrder_id());

		return result;
	}

	// 跳转到成功下单页面
	@RequestMapping("/successOrder")
	private String successOrder(HttpServletRequest request, HttpSession session) throws Exception {
		// 获取order_id
		if (session.getAttribute("order_id") == null)
			return "error/failure";
		int order_id = (int) session.getAttribute("order_id");

		// 获取刚下单的信息
		OrderSuccessResult order = orderService.findOrderById(order_id);
		request.setAttribute("order", order);
		
		return "successOrder";
	}

	// 取消订单
	@RequestMapping("/cancelOrder")
	public String cancelOrder(int order_id, HttpSession session) throws Exception {

		// 获取user_id
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		int user_id = userService.findUser_idByUserName(authentication.getName());

		// 删除订单
		int result = orderService.deleteOrderById(user_id, order_id);

		// 删除失败
		if (result == 0) {
			return "error/failure";
		}
		// 删除成功
		session.removeAttribute("order_id");
		return "redirect:order";
	}

	// 订单列表
	@RequestMapping("/orderList")
	private String orderList(int pageNum, HttpServletRequest request, HttpSession session) throws Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		if (username != null) {
			// 页面显示数量
			int pageSize = 5;
			// 获得带分页的订单列表
			Page<OrderList> page = orderService.findUserOrdersWithPage(pageNum, pageSize,
					userService.findUser_idByUserName(username));
			// 判断是否存在当前页
			if (page.getTotalPage() < pageNum) {
				return "error/404";
			}
			request.setAttribute("page", page);
		}

		return "orderList";
	}

	// 未处理订单详情
	@RequestMapping("/userOrderDetail")
	public String userOrderDetail(int order_id, HttpServletRequest request) throws Exception {
		// 获取username
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User_Order user_order = new User_Order(authentication.getName(), order_id);

		// 查询订单详情
		HashMap<String, Object> orderDetail = orderService.findOrderDetail(user_order);
		if (orderDetail.isEmpty()) {
			return "error/404";
		}
		request.setAttribute("orderDetail", orderDetail);

		return "userOrderDetail";
	}

	// 未处理订单
	@RequestMapping("/untreatedOrders")
	public String untreatedOrder(int pageNum, HttpServletRequest request) throws Exception {
		// 页面显示数量
		int pageSize = 4;
		// 获得带分页的未处理订单
		Page<HashMap<String, String>> page = orderService.findUntreatedOrdersWithPage(pageNum, pageSize);
		// 判断是否存在当前页
		if (page.getTotalPage() < pageNum) {
			return "error/404";
		}
		request.setAttribute("page", page);
		return "untreatedOrders";
	}

	// 未处理订单详情
	@RequestMapping("/untreatedOrderDetail")
	public String untreatedOrderDetail(@Validated User_Order user_order, BindingResult bindingResult,
			HttpServletRequest request) throws Exception {
		if (bindingResult.hasErrors()) {
			return "error/400";
		}
		// 查询订单详情
		HashMap<String, Object> orderDetail = orderService.findOrderDetail(user_order);
		if (orderDetail.isEmpty()) {
			return "error/404";
		}
		request.setAttribute("orderDetail", orderDetail);

		return "untreatedOrderDetail";
	}

	// 确认订单回收
	@RequestMapping("/orderRecycle")
	public String orderRecycle(int order_id) throws Exception {
		if (order_id == 0) {
			return "error/400";
		}

		// 确认订单回收
		int result = orderService.orderRecycle(order_id);
		if (result == 0) {
			return "error/failure";
		}

		return "redirect:untreatedOrders?pageNum=1";
	}
}
