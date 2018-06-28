// 是否提交状态
var isCommitted = false;
$.validator.setDefaults({
	submitHandler : function(form) {
		// 防止表单重复提交
		if (isCommitted == false) {
			var data = JSON.stringify($('form').serializeJSON());
			$.ajax({
				type : 'post',
				url : "createGoods",
				contentType : 'application/json;charset=utf-8',
				data : data,
				success : function(data) {
					if (data.msg != null) {
						isCommitted = false;
						$("span[for='name']").append("<span class='myerror dataResult'>" + data.msg + "</span>");
					} else {
						window.location.href = data.url;
					}
				}
			});
			//提交表单后，将表单是否已经提交标识设置为true
			isCommitted = true;
		}
	}
});
$().ready(function() {
	$("input[type='file']").hide();
	$("input[name='avatar']").hide();
	// 提交时验证表单

	var validator = $("#createGoodsForm").validate({
		errorPlacement : function(error, element) {
			$(element)
				.closest("form")
				.find("span[for='" + element.attr("id") + "']")
				.append(error);
		},
		errorClass : "myerror",
		errorElement : "span",
		rules : {
			name : {
				required : true,
				rangelength : [ 1, 16 ],
				regex : "^[\\w-—!（）@#$^\u4E00-\u9FA5]{1,16}$"
			},
			intro : {
				required : true,
				regex : "^[\\w-—!（）@#$^.\u4E00-\u9FA5]*$"
			},
			price : {
				required : true,
				minNumber : $("input[name='price']").val(),
				min : 0.01
			},
			imgUrl : {
				required : true,
				regex : "^[\\w.-]*$"
			}
		},
		messages : {
			name : {
				required : "商品名不能为空",
				rangelength : "长度要在1-16个字符之间",
				regex : "含有非法字符"
			},
			intro : {
				required : "商品介绍不能为空",
				regex : "含有非法字符"
			},
			price : {
				required : "商品价格不能为空",
				min : "最小价格为0.01",
			},
			imgUrl : {
				required : "商品图片不能为空",
				regex : "格式错误"
			}
		}
	});

});
$("#username").keypress(function() {
	$(".dataResult").hide();
});
$("img[alt='avatar']").click(function() {
	$("input[type='file']").click();
})
$("input[type='file']").on('change', function() {
	var files = this.files[0];
	var formData = new FormData();
	formData.append('img', files);
	$.ajax({
		type : 'post',
		url : "uploadImage",
		data : formData,
		processData : false,
		contentType : false,
		success : function(data) {
			if (data.msg != null) {
				$("input[name='imgUrl']").val(data.msg);
				var path = data.msg;
				$("img[alt='avatar']").attr('src', path);
			}
		}
	});
});