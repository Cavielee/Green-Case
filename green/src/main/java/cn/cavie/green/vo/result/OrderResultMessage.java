package cn.cavie.green.vo.result;

public class OrderResultMessage {

	// 跳转地址
	private String url;

	// 信息反馈
	private String msg;
	
	// 订单id
	private int order_id;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	
	
}