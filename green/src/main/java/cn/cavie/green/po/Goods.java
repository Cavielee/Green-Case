package cn.cavie.green.po;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Goods {

	// 商品id
	private int goods_id;
	
	// 商品名称
	@NotNull
	@NotEmpty
	private String name;
	
	// 商品介绍
	private String intro;
	
	// 商品价格
	@NotNull
	@NotEmpty
	private float price;
	
	// 商品图片
	@NotNull
	@NotEmpty
	private String imgUrl;

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
}
