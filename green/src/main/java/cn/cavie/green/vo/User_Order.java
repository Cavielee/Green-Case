package cn.cavie.green.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class User_Order {
	// 用户名
	@NotEmpty(message = "用户名不能为空")
	@Length(min = 1, max = 16, message = "长度要在1-16个字符之间")
	@Pattern(regexp = "^[\\w!@#$^*\u4E00-\u9FA5]{1,16}$", message = "含有非法字符")
	private String username;

	// 订单id
	@NotNull
	private int order_id;

	public String getUsername() {
		return username;
	}

	public User_Order() {

	}

	public User_Order(String username, int order_id) {
		super();
		this.username = username;
		this.order_id = order_id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

}
