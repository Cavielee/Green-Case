package cn.cavie.green.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class LoginUserForm {

	// 用户名
	@NotEmpty(message="用户名不能为空")
	@Length(min = 1, max = 16, message = "长度要在1-16个字符之间")
	@Pattern(regexp = "^[\\w!@#$^\u4E00-\u9FA5]{1,16}$", message = "含有非法字符")
	private String username;

	// 用户密码
	@NotEmpty(message="密码不能为空")
	@Length(min = 8, max = 16, message = "长度要在8-16个字符之间")
	@Pattern(regexp = "^[\\w!@#$^]{8,16}$", message = "含有非法字符")
	private String password;

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

}
