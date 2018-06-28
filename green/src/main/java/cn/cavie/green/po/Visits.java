package cn.cavie.green.po;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Visits {

	// id
	private int visits_id;

	// 访问量
	@NotNull
	@NotEmpty
	private int num;

	public int getVisits_id() {
		return visits_id;
	}

	public void setVisits_id(int visits_id) {
		this.visits_id = visits_id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
