package cn.cavie.green.vo.result;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class OrderSuccessResult {

	// 订单id
	private int order_id;

	// 上门回收时间
	@NotNull
	@NotEmpty
	private long SRV_TIME_END;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public long getSRV_TIME_END() {
		return SRV_TIME_END;
	}

	public void setSRV_TIME_END(long sRV_TIME_END) {
		SRV_TIME_END = sRV_TIME_END;
	}

}
