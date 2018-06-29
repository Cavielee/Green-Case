//表单是否已经提交标识，默认为false
var isCommitted = false;
$().ready(function() {
	// 提交时验证表单

	var validator = $("#orderWork").validate({
		submitHandler : function(form) {
			// 防止表单重复提交
			if (isCommitted == false) {
				//提交表单后，将表单是否已经提交标识设置为true
				isCommitted = true;

				var worksName = $("#orderWork").serialize();
				$.ajax({
					type : 'post',
					url : "deleteWorks",
					data : worksName,
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

			}

		},
		rules : {
			workName : {
				regex : "^[\\w!@#$^\u4E00-\u9FA5]{1,16}$"
			}
		},
		messages : {
			workName : {
				regex : "格式错误"
			}
		}
	});
	var validator = $("#goodsWork").validate({
		submitHandler : function(form) {
			// 防止表单重复提交
			if (isCommitted == false) {
				var worksName = $("#goodsWork").serialize();
				$.ajax({
					type : 'post',
					url : "deleteWorks",
					data : worksName,
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
			workName : {
				regex : "^[\\w!@#$^\u4E00-\u9FA5]{1,16}$"
			}
		},
		messages : {
			workName : {
				regex : "格式错误"
			}
		}
	});

});

function createOrderWork() {
	window.location.href = "toCreateWork";
}

function createGoodsWork() {
	window.location.href = "toCreateWork";
}