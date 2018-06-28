$("li[name='order_id']").hide();
$("form").hide();
function orderDetail(element) {
	var username = $(element).find("p[name='username']").text();
	var order_id = parseInt($(element).find("li[name='order_id']").text());
	$("input[name='username']").val(username);
	$("input[name='order_id']").val(order_id);
	$("form").submit();
}