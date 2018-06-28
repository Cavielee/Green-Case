//表单是否已经提交标识，默认为false
var isCommitted = false;
$.validator.setDefaults({
	submitHandler : function(form) {
		// 防止表单重复提交
		if (isCommitted == false) {
			// 下单时间
			var SRV_TIME_FROM = new Date();
			$("input[name='SRV_TIME_FROM']").val(Date.parse(SRV_TIME_FROM));

			// 上门时间
			var date = new Date();
			if ($("input[value='周日']").prop("checked")) {

				// 获取当前时间毫秒值
				var nowtime = Date.parse(date.toDateString());

				switch (date.getDay()) {
				case 0:
					nowtime = nowtime + 86400000 * 7;
					break;
				case 1:
					nowtime = nowtime + 86400000 * 6;
					break;
				case 2:
					nowtime = nowtime + 86400000 * 5;
					break;
				case 3:
					nowtime = nowtime + 86400000 * 4;
					break;
				case 4:
					nowtime = nowtime + 86400000 * 3;
					break;
				case 5:
					nowtime = nowtime + 86400000 * 2;
					break;
				case 6:
					nowtime = nowtime + 86400000 * 1;
					break;

				}

			} else if ($("input[value='周二']").prop("checked")) {
				var date = new Date();
				// 获取当前时间毫秒值
				var nowtime = Date.parse(date.toLocaleDateString());

				switch (date.getDay()) {
				case 0:
					nowtime = nowtime + 86400000 * 2;
					break;
				case 1:
					nowtime = nowtime + 86400000 * 8;
					break;
				case 2:
					nowtime = nowtime + 86400000 * 7;
					break;
				case 3:
					nowtime = nowtime + 86400000 * 6;
					break;
				case 4:
					nowtime = nowtime + 86400000 * 5;
					break;
				case 5:
					nowtime = nowtime + 86400000 * 4;
					break;
				case 6:
					nowtime = nowtime + 86400000 * 3;
					break;

				}

			}
			date = new Date(nowtime);
			if ($("option[value='14:00-15:00']").prop("selected")) {
				date.setHours(14);
			} else if ($("option[value='19:00-20:00']").prop("selected")) {
				date.setHours(19);
			}

			// 设置SRV_TIME_END值
			$("input[name='SRV_TIME_END']").val(Date.parse(date));


			var data = JSON.stringify($('form').serializeJSON());
			$.ajax({
				type : 'post',
				url : "saveOrder",
				contentType : 'application/json;charset=utf-8',
				data : data,
				success : function(data) {
					if (data.msg != null) {
						isCommitted = false;
						alert(data.msg);
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
	// 提交时验证表单

	var validator = $("#orderForm").validate({
		rules : {
			week : {
				required : true,
				regex : "^(周二)|(周日)$"
			},
			hour : {
				required : true,
				regex : "^(14:00-15:00)|(19:00-20:00)$"
			},
		},
		messages : {
			week : {
				required : "星期不能为空",
				regex : "星期格式错误"
			},
			hour : {
				required : "小时不能为空",
				regex : "小时格式错误"
			}
		}
	});

});

//隐藏按钮
$("input[name='SRV_TIME_FROM']").hide();
$("input[name='SRV_TIME_END']").hide();
$(":radio").hide();

// 控制button
$("#Sunday").click(function() {
	$("#Sunday").addClass("select");
	$("#Tuesday").removeClass("select");
	$("input[value='周日']").prop("checked", "true");
});
$("#Tuesday").click(function() {
	$("#Tuesday").addClass("select");
	$("#Sunday").removeClass("select");
	$("input[value='周二']").prop("checked", "true");
});