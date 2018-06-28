//表单是否已经提交标识，默认为false
var isCommitted = false;
$.validator.setDefaults({
	submitHandler : function(form) {
		// 防止表单重复提交
		if (isCommitted == false) {
			form.submit();
			//提交表单后，将表单是否已经提交标识设置为true
			isCommitted = true;
		}

	}
});
function getQueryString(name) {
	var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
	var r = window.location.search.substr(1).match(reg);
	if (r != null) {
		return unescape(r[2]);
	}
	return null;
}
$().ready(function() {
	if (getQueryString("error") != null)
		alert("用户名不存在或密码错误！");

	$(".regedit").click(function() {
		window.location.href = 'regedit';
	})
	$("#myremember").click(function() {
		$("input[name='remember-me']").click();
	});
	// 提交时验证表单
	var validator = $("#loginForm").validate({
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
			}
		}
	});

});
$("#username").keypress(function() {
	$(".dataResult").hide();
});
$("#password").keypress(function() {
	$(".dataResult").hide();
});