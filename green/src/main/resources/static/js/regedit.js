//表单是否已经提交标识，默认为false
var isCommitted = false;
$.validator.setDefaults({
	submitHandler : function() {
		// 防止表单重复提交
		if (isCommitted == false) {
			//提交表单后，将表单是否已经提交标识设置为true
			isCommitted = true;
			
			var data = JSON.stringify($('form').serializeJSON());
			$.ajax({
				type : 'POST',
				url : "regeditUser",
				contentType: "application/json; charset=utf-8",
	            dataType: "json",
				data : data,
				success : function(data) {
					if (data.msg != null) {
						isCommitted = false;
						$("img[alt='vdCode']").attr('src', 'createValidateCode?' + Math.random());
						if (data.msg == "用户名已存在") {
							$("span[for='username']").append("<span class='myerror dataResult'>" + data.msg + "</span>");
						} else if (data.msg == "验证码错误") {
							$("span[for='vdcode']").append("<span class='myerror dataResult'>" + data.msg + "</span>");
						} else {
							alert(data.msg);
						}
					} else {
						window.location.href = data.url;
					}
				}
			});
		}

	}
});

$().ready(function() {
	// 提交时验证表单

	var validator = $("#regeditForm").validate({
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
			realname : {
				required : true,
				rangelength : [ 1, 16 ],
				// 只允许字母、数字和汉字  
				regex : "^[\\w\u4E00-\u9FA5]{1,16}$"
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
			school : {
				required : true,
				regex : "^(天河校区)|(白云校区)$"
			},
			floor : {
				required : true,
				regex : "^(1栋)|(2栋)$"
			},
			dormitory : {
				required : true,
				regex : "^(101)|(102)$"
			},
			phone : {
				required : true,
				regex : "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$"
			},
			vdcode : {
				required : true,
				regex : "^[\\w]{4}$",
			}
		},
		messages : {
			username : {
				required : "用户名不能为空",
				rangelength : "长度要在1-16个字符之间",
				regex : "含有非法字符"
			},
			realname : {
				required : "真实姓名不能为空",
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
			school : {
				required : "校区不能为空",
				regex : "校区格式错误"
			},
			floor : {
				required : "楼栋不能为空",
				regex : "楼栋格式错误"
			},
			dormitory : {
				required : "宿舍不能为空",
				regex : "宿舍格式错误"
			},
			phone : {
				required : "电话号码不能为空",
				regex : "电话号码格式错误"
			},
			vdcode : {
				required : "验证码不能为空",
				regex : "验证码格式错误"
			}
		}
	});

});
$("#username").keypress(function() {
	$(".dataResult").hide();
});
$("#vdcode").keypress(function() {
	$(".dataResult").hide();
});
$("img[alt='vdCode']").click(function() {
	$("img[alt='vdCode']").attr('src', 'createValidateCode?' + Math.random());
})