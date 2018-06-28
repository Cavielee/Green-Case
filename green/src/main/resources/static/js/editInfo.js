//表单是否已经提交标识，默认为false
var isCommitted = false;
$.validator.setDefaults({
	submitHandler : function(form) {
		//		form.submit();
		//		var data = $('form').serialize();
		//		var data = $('form').serialize();
		//		var formData = new FormData($("#editForm")[0]);
		// 防止表单重复提交
		if (isCommitted == false) {
			if ($("input[name='avatar']").val() == "") {
				var path = $("img[alt='avatar']").attr('src');
				path = path.match(/(\S*)/)[1];
				$("input[name='avatar']").val(path);
			}
			var data = JSON.stringify($('form').serializeJSON());
			$.ajax({
				type : 'post',
				url : "updateUserInfo",
				contentType : 'application/json;charset=utf-8',
				data : data,
				success : function(data) {
					if (data.msg != null) {
						isCommitted = false;
						if (data.msg == "用户名已存在") {
							$("span[for='username']").append("<span class='myerror dataResult'>" + data.msg + "</span>");
						} else if (data.msg == "请重新登录") {
							alert(data.msg);
							window.location.href = data.url;
						}
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

	var validator = $("#editForm").validate({
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
			phone : {
				required : true,
				regex : "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$"
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
			realname : {
				required : "真实姓名不能为空",
				rangelength : "长度要在1-16个字符之间",
				regex : "含有非法字符"
			},
			phone : {
				required : "电话号码不能为空",
				regex : "电话号码格式错误"
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