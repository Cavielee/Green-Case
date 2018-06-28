<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">
<link rel="stylesheet" type="text/css" href="css/orderDetail.css">
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
					<h3 class="title">订单详情</h3>
				</div>
			</div>
			<div class="row clearfix order_item">
				<div class="col-xs-12 untreated">
					<img src="img/untreatedOrder.png" alt="untreated" />
				</div>
				<div class="col-xs-12">
					<div class="row clearfix">
						<div class="col-xs-1 img-address">
							<img src="img/地址.svg" alt="地址" />
						</div>
						<div class="col-xs-11 text">
							<h4>
								用户名：
								<p>${orderDetail.user.username }</p>
							</h4>
							<h4>
								真实姓名：
								<p>${orderDetail.user.realname }</p>
							</h4>
							<h4>
								地址：
								<p>${orderDetail.user.school } ${orderDetail.user.floor } ${orderDetail.user.dormitory }</p>
							</h4>
							<h4>
								联系电话：
								<p>${orderDetail.user.phone }</p>
							</h4>
						</div>
					</div>
				</div>
			</div>

			<div class="row clearfix order_item">
				<div class="col-xs-12">
					<div class="row clearfix">
						<div class="col-xs-1 img-order">
							<img src="img/ordersmall.svg" alt="订单" />
						</div>
						<div class="col-xs-11 text">
							<h4>
								下单时间：
								<p>${orderDetail.order.SRV_TIME_FROM }</p>
							</h4>
							<h4>
								上门时间：
								<p>${orderDetail.order.SRV_TIME_END }</p>
							</h4>
						</div>
					</div>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-xs-12 recycle">
					<a href="orderRecycle?order_id=${orderDetail.order.order_id }">确认订单已回收</a>
				</div>
			</div>

		</div>
	</div>

	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/my.js"></script>
</body>
</html>