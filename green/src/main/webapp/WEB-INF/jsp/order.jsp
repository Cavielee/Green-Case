<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>盒你益起</title>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<meta content="IE=edge" http-equiv="X-UA-compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/sharestyle.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/order.css">
<link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
	<div class="bg">
		<div class="container" id="topbar">
			<div class="row clearfix">
				<div class="col-xs-3">
					<a href="javascript:history.go(-1)"><i class="fa fa-angle-left"></i></a>
				</div>
				<div class="col-xs-6">
					<h3 class="title">预约上门</h3>
				</div>
				<div class="col-xs-3">
					<div class="ruler">说明</div>
				</div>
			</div>
		</div>
		<div class="container order">
			<div class="row clearfix">
				<div class="col-xs-12 ordertitle">请求上门时间</div>

			</div>
			<form id="orderForm">
				<div class="row clearfix">
					<div class="col-xs-6 line">
						<button type="button" class="orderweek select" id="Sunday">本周日</button>
						<input type="radio" name="week" value="周日" checked />
					</div>
					<div class="col-xs-6">
						<button type="button" class="orderweek" id="Tuesday">下周二</button>
						<input type="radio" name="week" value="周二" />
					</div>
					<input type="text" name="SRV_TIME_FROM" value="" /> <input
						type="text" name="SRV_TIME_END" value="" />
				</div>
				<div class="row clearfix">
					<div class="col-xs-4 col-xs-offset-4">
						<select class="ordertime" name="hour">
							<option selected value="14:00-15:00">14:00-15:00</option>
							<option value="19:00-20:00">19:00-20:00</option>
						</select>
					</div>
					
				</div>
				<div class="row clearfix bgcolor">
					<div class="col-xs-12">
						<input type="submit" class="ordersubmit" value="预约下单" />
					</div>

				</div>
			</form>
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
	<script src="js/jquery.serializejson.min.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/messages_zh.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/my.js"></script>
	<script src="js/order.js"></script>
</body>
</html>