package cn.cavie.green.po;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class User_Authorities {

	// 权限表id
	@NotNull
	@NotEmpty
	private int authorities_id;

	// 用户id
	@NotNull
	@NotEmpty
	private int user_id;

	public int getAuthorities_id() {
		return authorities_id;
	}

	public void setAuthorities_id(int authorities_id) {
		this.authorities_id = authorities_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}
