package cn.cavie.green.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class PointRecordList {

	// 积分
	@NotNull
	private int point;

	// 记录描述
	@NotNull
	@NotEmpty
	private String description;

	// 记录时间
	private String created;

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

}
