package cn.cavie.green.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class OrderList {

	// 订单id
	private int order_id;

	// 下单时间
	@NotNull
	@NotEmpty
	private String SRV_TIME_FROM;

	// 上门回收时间
	@NotNull
	@NotEmpty
	private String SRV_TIME_END;

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

	public String getSRV_TIME_FROM() {
		return SRV_TIME_FROM;
	}

	public void setSRV_TIME_FROM(String sRV_TIME_FROM) {
		SRV_TIME_FROM = sRV_TIME_FROM;
	}

	public String getSRV_TIME_END() {
		return SRV_TIME_END;
	}

	public void setSRV_TIME_END(String sRV_TIME_END) {
		SRV_TIME_END = sRV_TIME_END;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
