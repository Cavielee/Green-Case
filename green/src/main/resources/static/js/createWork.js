//表单是否已经提交标识，默认为false
var isCommitted = false;
$.validator.setDefaults({
	submitHandler : function(form) {
		//		var formData = new FormData($("#createWorkForm")[0]);
		// 防止表单重复提交
		if (isCommitted == false) {
			//提交表单后，将表单是否已经提交标识设置为true
			isCommitted = true;

			var data = JSON.stringify($('form').serializeJSON());
			$.ajax({
				type : 'post',
				url : "createWork",
				contentType : 'application/json;charset=utf-8',
				data : data,
				success : function(data) {
					if (data.msg != null) {
						isCommitted = false;
						$("span[for='username']").append("<span class='myerror dataResult'>" + data.msg + "</span>");
					} else {
						window.location.href = data.url;
					}
				}
			});

		}

	}
});

$().ready(function() {
	$("input[type='file']").hide();
	$("input[name='avatar']").hide();
	// 提交时验证表单

	var validator = $("#createWorkForm").validate({
		errorPlacement : function(error, element) {
			$(element)
				.closest("form")
				.find("span[for='" + element.attr("id") + "']")
				.append(error);
		},
		errorClass : "myerror",
		errorElement : "span",
		rules : {
			username : {
				required : true,
				rangelength : [ 1, 16 ],
				// 只允许字母、数字和汉字  
				regex : "^[\\w!@#$^\u4E00-\u9FA5]{1,16}$"
			},
			password : {
				required : true,
				rangelength : [ 8, 16 ],
				regex : "^[\\w!@#$^]{8,16}$"
			},
			apwd : {
				required : true,
				equalTo : "#password"
			},
			type : {
				required : true,
				regex : "^(订单工作人员)|(商品工作人员)$"
			},
			avatar : {
				regex : "^[\\w.-]*$"
			}
		},
		messages : {
			username : {
				required : "用户名不能为空",
				rangelength : "长度要在1-16个字符之间",
				regex : "含有非法字符"
			},
			password : {
				required : "密码不能为空",
				rangelength : "长度要在8-16个字符之间",
				regex : "含有非法字符"
			},
			apwd : {
				required : "密码不能为空",
				equalTo : "两次密码不相同"
			},
			type : {
				required : "类型不能为空",
				regex : "类型格式错误"
			},
			avatar : {
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
				$("input[name='avatar']").val(data.msg);
				var path = data.msg;
				$("img[alt='avatar']").attr('src', path);
			}
		}
	});
});