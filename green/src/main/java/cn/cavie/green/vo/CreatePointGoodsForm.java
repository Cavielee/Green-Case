package cn.cavie.green.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class CreatePointGoodsForm {

	// 商品id
	private int point_goods_id;

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

	// 类型
	@NotNull
	@NotEmpty
	@Pattern(regexp = "^(美食)|(生活)|(电影)|(其他)$", message = "类型格式错误")
	private String type;

	public int getPoint_goods_id() {
		return point_goods_id;
	}

	public void setPoint_goods_id(int point_goods_id) {
		this.point_goods_id = point_goods_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
