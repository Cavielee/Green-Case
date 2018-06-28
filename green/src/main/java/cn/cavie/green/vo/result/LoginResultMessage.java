package cn.cavie.green.vo.result;

public class LoginResultMessage {

	// 跳转地址
	private String url;

	// 信息反馈
	private String msg;
	
	// 用户id
	private int user_id;

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

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	
}