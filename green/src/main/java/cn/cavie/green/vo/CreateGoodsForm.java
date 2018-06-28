package cn.cavie.green.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class CreateGoodsForm {

	// 商品id
	private int goods_id;

	// 商品名称
	@NotNull
	@NotEmpty
	@Pattern(regexp = "^[\\w-—!（）@#$^\u4E00-\u9FA5]{1,16}$", message = "含有非法字符")
	private String name;

	// 商品介绍
	@NotNull
	@NotEmpty
	@Pattern(regexp = "^[\\w-—!（）@#$^.\u4E00-\u9FA5]*$", message = "含有非法字符")
	private String intro;

	// 商品价格
	@NotNull
	private float price;

	// 商品图片
	@NotNull
	@NotEmpty
	@Pattern(regexp = "^[\\w.-]*$", message = "含有非法字符")
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
