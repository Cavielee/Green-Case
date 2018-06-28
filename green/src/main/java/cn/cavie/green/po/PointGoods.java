package cn.cavie.green.po;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

// 积分商品
public class PointGoods {
	// 商品id
	private int point_goods_id;

	// 商品名称
	@NotNull
	@NotEmpty
	private String name;

	// 商品介绍
	private String intro;

	// 商品价格
	@NotNull
	@NotEmpty
	private int price;

	// 商品图片
	@NotNull
	@NotEmpty
	private String imgUrl;

	// 商品类型
	@NotNull
	@NotEmpty
	private String type;

	public int getPoint_goods_id() {
		return point_goods_id;
	}

	public void setPoint_goods_id(int point_goods_id) {
		this.point_goods_id = point_goods_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
