package cn.cavie.green.exception;

public class CustomException extends Exception {

	private static final long serialVersionUID = 2250870931652736439L;

	public CustomException(String message) {
		super(message);
		this.message = message;
	}

	// 异常信息
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
