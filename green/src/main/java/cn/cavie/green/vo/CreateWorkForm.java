package cn.cavie.green.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class CreateWorkForm {

	// 用户id
	private int user_id;

	// 用户名
	@NotEmpty(message = "用户名不能为空")
	@Length(min = 1, max = 16, message = "长度要在1-16个字符之间")
	@Pattern(regexp = "^[\\w!@#$^\u4E00-\u9FA5]{1,16}$", message = "含有非法字符")
	private String username;

	// 用户密码
	@NotEmpty(message = "密码不能为空")
	@Length(min = 8, max = 16, message = "长度要在8-16个字符之间")
	@Pattern(regexp = "^[\\w!@#$^]{8,16}$", message = "含有非法字符")
	private String password;

	// 用户头像
	@Pattern(regexp = "^[\\w.-]*$", message = "含有非法字符")
	private String avatar;

	// 类型
	@NotNull
	@NotEmpty
	@Pattern(regexp = "^(订单工作人员)|(商品工作人员)$", message = "类型格式错误")
	private String type;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
