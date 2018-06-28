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
<link rel="stylesheet" type="text/css" href="css/index.css">
<link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
	<div class="bg">
		<div class="container-fluid" id="search">
			<div class="row clearfix">
				<div class="col-xs-8 col-xs-offset-2">
					<button class="search">
						<i class="fa fa-search"></i>搜索
					</button>
				</div>
			</div>
		</div>
		<div>
			<div class="container-fluid">
				<div class="row clearfix" id="nav">
					<a href="point">
						<div class="col-xs-3">
							<img class="bar-item" src="img/point.svg" alt="point">
							<h6>积分</h6>
						</div>
					</a> <a href="orderList?pageNum=1">
						<div class="col-xs-3">
							<img class="bar-item" src="img/orderList.svg" alt="orderList">
							<h6>预约订单</h6>
						</div>
					</a>
					<div class="col-xs-3">
						<img class="bar-item" src="img/prize.svg" alt="prize">
						<h6>奖品记录</h6>
					</div>
					<div class="col-xs-3">
						<img class="bar-item" src="img/shop.svg" alt="shop">
						<h6>积分兑换</h6>
					</div>
				</div>
			</div>
		</div>
		<div class="info">
			<div class="title">
				<div class="line"></div>
				<h6>义卖</h6>
			</div>
			<div class="container">
				<div class="row clearfix">
					<c:forEach items="${gd_list }" var="goods">
						<a href="goodsDetail/${goods.goods_id }">
							<div class="col-xs-6 item">
								<div class="img">
									<img src="${goods.imgUrl }" alt="${goods.name }" />
								</div>
								<div class="text">
									<h4>${goods.name }</h4>
									<h3>¥${goods.price }</h3>
								</div>
							</div>
						</a>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="info box">
			<div class="title">
				<div class="line"></div>
				<h6>纸箱重塑</h6>
			</div>
			<div class="container">
				<div class="row clearfix">
					<c:forEach items="${vd_list }" var="video">
						<a href="video/${video.video_id }">
							<div class="col-xs-6 video">
								<img src="${video.imgUrl }" alt="${video.name }" />
								<h4>${video.name }</h4>
								<h5>
									<i class="fa fa-user"></i>${video.visits }人
								</h5>
							</div>
						</a>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="foot">——我可是有底线的——</div>
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
</body>
</html>