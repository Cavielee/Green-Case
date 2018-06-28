//表单是否已经提交标识，默认为false
var isCommitted = false;
$().ready(function() {
	// 提交时验证表单
	var validator = $("#goods").validate({
		submitHandler : function(form) {
			// 防止表单重复提交
			if (isCommitted == false) {
				var goodsName = $("#goods").serialize();
				$.ajax({
					type : 'post',
					url : "deletePointGoods",
					data : goodsName,
					success : function(data) {
						if (data.msg != null) {
							isCommitted = false;
							alert(data.msg);
						} else {
							if (data.url != null) {
								window.location.href = data.url;
							} else {
								window.location.reload();
							}
						}
					}
				});
				//提交表单后，将表单是否已经提交标识设置为true
				isCommitted = true;
			}
		},
		rules : {
			name : {
				regex : "^[\\w-—!（）@#$^\u4E00-\u9FA5]{1,16}$"
			}
		},
		messages : {
			name : {
				regex : "格式错误"
			}
		}
	});

});

function CreateGoods() {
	window.location.href = "toCreatePointGoods";
}