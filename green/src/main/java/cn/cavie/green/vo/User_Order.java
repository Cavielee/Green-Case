package cn.cavie.green.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class User_Order {
	// 鐢ㄦ埛鍚�
	@NotEmpty(message = "鐢ㄦ埛鍚嶄笉鑳戒负绌�")
	@Length(min = 1, max = 16, message = "闀垮害瑕佸湪1-16涓瓧绗︿箣闂�")
	@Pattern(regexp = "^[\\w!@#$^*\u4E00-\u9FA5]{1,16}$", message = "鍚湁闈炴硶瀛楃")
	private String username;

	// 璁㈠崟id
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
