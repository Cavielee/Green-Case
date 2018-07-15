<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html>
<head>
<title>盒你益起</title>
<base href="<%=basePath%>">
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<meta content="IE=edge" http-equiv="X-UA-compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/sharestyle.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/successOrder.css">
<link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
	<div class="bg">
		<div class="container">
			<div class="row clearfix" id="topbar">
				<div class="col-xs-3">
					<a href="javascript:history.go(-1)"><i class="fa fa-angle-left"></i></a>
				</div>
				<div class="col-xs-6">
					<h3 class="title">预约成功</h3>
				</div>
			</div>
			<div class="row clearfix success-img">
				<div class="col-xs-4 col-xs-offset-4">
					<img class="bar-item" src="img/success.svg" alt="success">
				</div>
			</div>
			<div class="row clearfix success-text">
				<div class="col-xs-8 col-xs-offset-2">
					<p>哎呦，不错哦！</p>
					<p>动动手指又为环保出了一份力！</p>
					<p>垃圾分类就应该从源头开始。</p>
					<p>感谢您的支持，我们会尽快上门回收</p>
				</div>
			</div>
			<div class="row clearfix success-time">
				<div class="col-xs-8 col-xs-offset-2">
					<span>预约上门时间</span>
					<p id="date"></p>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-xs-4 col-xs-offset-4">
					<button type="button" id="cancelOrder">取消订单</button>
				</div>
			</div>
			<div class="row clearfix bgcolor">
				<div class="col-xs-12">
					<button class="orderHistory">我的记录</button>
				</div>
			</div>
		</div>
		<div class="container" id="bar">
			<div class="row clearfix">
				<div class="col-xs-3">
					<a href="index">
						<div>
							<img class="bar-item" src="img/home-green.svg" alt="home">
							<h6>首页</h6>
						</div>
					</a>
				</div>
				<div class="col-xs-3">
					<a href="order">
						<div>
							<img class="bar-item" src="img/box-green.svg" alt="box">
							<h6>预约</h6>
						</div>
					</a>
				</div>
				<div class="col-xs-3">
					<a href="sale?pageNum=1">
						<div>
							<img class="bar-item" src="img/live-green.svg" alt="sale">
							<h6>义卖</h6>
						</div>
					</a>
				</div>
				<div class="col-xs-3">
					<a href="user">
						<div>
							<img class="bar-item" src="img/user-green.svg" alt="user">
							<h6>个人</h6>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/my.js"></script>
	<script>
		$().ready(function() {
			var date = new Date(${order.SRV_TIME_END});
			var year = date.getFullYear();
			var month = date.getMonth() + 1;
			var day = date.getDate();
			var hours = date.getHours();
			var week;
			switch (date.getDay()) {
			case 0:
				week = "周日"
				break;
			case 1:
				week = "周一"
				break;
			case 2:
				week = "周二"
				break;
			case 3:
				week = "周三"
				break;
			case 4:
				week = "周四"
				break;
			case '5':
				week = "周五"
				break;
			case 0:
				week = "周日"
				break;
			case 6:
				week = "周六"
				break;
			}
			;
			if (month < 10) {
				month = "0" + month;
			}
			if (day < 10) {
				day = "0" + day;
			}
			if (hours < 10) {
				hours = "0" + hours;
			}
			$("#date").html(year + "年" + month + "月" + day + "日 " + week + " " + hours + ":00 -" + (hours+1) + ":00");
		
		
			$("#cancelOrder").click(function() {
				window.location.href = 'cancelOrder?order_id=${order.order_id }';
			});
			
			$(".orderHistory").click(function() {
				window.location.href = 'orderList?pageNum=1';
			});
		});
	</script>

</body>
</html>