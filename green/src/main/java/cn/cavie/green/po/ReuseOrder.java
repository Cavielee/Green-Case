package cn.cavie.green.po;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ReuseOrder {
	// 订单id
	private int order_id;

	// 用户id
	@NotNull
	@NotEmpty
	private int user_id;

	// 下单时间
	@NotNull
	@NotEmpty
	private Timestamp SRV_TIME_FROM;

	// 上门回收时间
	@NotNull
	@NotEmpty
	private Timestamp SRV_TIME_END;

	// 状态
	@NotNull
	@NotEmpty
	private int status;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Timestamp getSRV_TIME_FROM() {
		return SRV_TIME_FROM;
	}

	public void setSRV_TIME_FROM(Timestamp sRV_TIME_FROM) {
		SRV_TIME_FROM = sRV_TIME_FROM;
	}

	public Timestamp getSRV_TIME_END() {
		return SRV_TIME_END;
	}

	public void setSRV_TIME_END(Timestamp sRV_TIME_END) {
		SRV_TIME_END = sRV_TIME_END;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
