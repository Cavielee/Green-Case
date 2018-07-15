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
	href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/goodsDetail.css">
<link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
	<div class="bg">
		<div class="container">
			<div class="row clearfix" id="topbar">
				<div class="col-xs-3">
					<a href="user"><i class="fa fa-angle-left"></i></a>
				</div>
				<div class="col-xs-6">
					<h3 class="title">商品详情</h3>
				</div>
			</div>
			
			<div class="row clearfix goodsImg">
				<div class="col-xs-12">
					<img src="${goods.imgUrl }" alt="${goods.name }"/>
				</div>
			</div>
			
			<div class="row clearfix">
				<div class="col-xs-12">
					<ul>
						<li>商品名：<h3>${goods.name }</h3></li>
						<li>商品介绍：<h4>${goods.intro }</h4></li>
						<li>价格：<h5>¥${goods.price }</h5></li>
					</ul>
				</div>
			</div>
			
			<div class="row clearfix">
				<div class="col-xs-12 recycle">
					<a href="#">购买</a>
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