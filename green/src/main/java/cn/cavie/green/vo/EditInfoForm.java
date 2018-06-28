package cn.cavie.green.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class EditInfoForm {

	// 用户id
	private int user_id;

	// 用户名
	@NotEmpty(message = "用户名不能为空")
	@Length(min = 1, max = 16, message = "长度要在1-16个字符之间")
	@Pattern(regexp = "^[\\w!@#$^\u4E00-\u9FA5]{1,16}$", message = "含有非法字符")
	private String username;

	// 真实姓名
	@NotEmpty(message = "真实姓名不能为空")
	@Length(min = 1, max = 16, message = "长度要在8-16个字符之间")
	@Pattern(regexp = "^[\\w\u4E00-\u9FA5]{1,16}$", message = "含有非法字符")
	private String realname;

	// 用户头像
	@NotEmpty(message = "用户头像不能为空")
	@Pattern(regexp = "^[\\w.-]*$", message = "含有非法字符")
	private String avatar;

	// 电话号码
	@NotNull
	@NotEmpty
	@Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$", message = "电话格式错误")
	private String phone;

	// 学校
	@NotNull
	@NotEmpty
	@Pattern(regexp = "^(天河校区)|(白云校区)$", message = "校区格式错误")
	private String school;

	// 楼栋
	@NotNull
	@NotEmpty
	@Pattern(regexp = "^(1栋)|(2栋)$", message = "楼栋格式错误")
	private String floor;

	// 宿舍
	@NotNull
	@NotEmpty
	@Pattern(regexp = "^(101)|(102)$", message = "宿舍格式错误")
	private String dormitory;

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

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getDormitory() {
		return dormitory;
	}

	public void setDormitory(String dormitory) {
		this.dormitory = dormitory;
	}

}
