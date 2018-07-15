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
<link rel="stylesheet" type="text/css" href="css/point.css">
<link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
	<div class="bg">
		<div class="container-fluid" id="search">
			<div class="row clearfix">
				<div class="col-xs-2">
					<a href="index"><i class="fa fa-angle-left"></i></a>
				</div>
				<div class="col-xs-8">
					<button class="search">
						<i class="fa fa-search"></i>搜索
					</button>
				</div>
			</div>
		</div>
		<div>
			<div class="container">
				<div class="row clearfix" id="nav">
					<a href="pointGoodsList/美食?pageNum=1">
						<div class="col-xs-3">
							<img class="bar-item" src="img/food.svg" alt="food">
							<h6>美食</h6>
						</div>
					</a> <a href="pointGoodsList/生活?pageNum=1">
						<div class="col-xs-3">
							<img class="bar-item" src="img/orderList.svg" alt="orderList">
							<h6>生活</h6>
						</div>
					</a> <a href="pointGoodsList/电影?pageNum=1">
						<div class="col-xs-3">
							<img class="bar-item" src="img/prize.svg" alt="prize">
							<h6>电影</h6>
						</div>
					</a> <a href="pointGoodsList/其他?pageNum=1">
						<div class="col-xs-3">
							<img class="bar-item" src="img/shop.svg" alt="shop">
							<h6>其他</h6>
						</div>
					</a>
				</div>
			</div>
		</div>
		<div class="info">
			<div class="title">
				<div class="line"></div>
				<h6>美食</h6>
			</div>
			<div class="container">
				<div class="row clearfix">
					<c:forEach items="${gd_map.food }" var="goods">
						<a href="#">
							<div class="col-xs-12 item">
								<div class="goods col-xs-3">
									<img src="${goods.imgUrl }" alt="item" />
								</div>
								<div class="col-xs-6">
									<h3>${goods.name }</h3>
									<h4>${goods.intro }</h4>
									<h5>${goods.price }积分</h5>
								</div>
								<div class="col-xs-3">
									<img class="add" src="img/add.svg" alt="add" />
								</div>
							</div>
						</a>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="info">
			<div class="title">
				<div class="line"></div>
				<h6>生活</h6>
			</div>
			<div class="container">
				<div class="row clearfix">
					<c:forEach items="${gd_map.life }" var="goods">
						<a href="#">
							<div class="col-xs-12 item">
								<div class="goods col-xs-3">
									<img src="${goods.imgUrl }" alt="item" />
								</div>
								<div class="col-xs-6">
									<h3>${goods.name }</h3>
									<h4>${goods.intro }</h4>
									<h5>${goods.price }积分</h5>
								</div>
								<div class="col-xs-3">
									<img class="add" src="img/add.svg" alt="add" />
								</div>
							</div>
						</a>
					</c:forEach>
				</div>
			</div>
		</div>

		<div class="info">
			<div class="title">
				<div class="line"></div>
				<h6>电影</h6>
			</div>
			<div class="container">
				<div class="row clearfix">
					<c:forEach items="${gd_map.movie }" var="goods">
						<a href="#">
							<div class="col-xs-12 item">
								<div class="goods col-xs-3">
									<img src="${goods.imgUrl }" alt="item" />
								</div>
								<div class="col-xs-6">
									<h3>${goods.name }</h3>
									<h4>${goods.intro }</h4>
									<h5>${goods.price }积分</h5>
								</div>
								<div class="col-xs-3">
									<img class="add" src="img/add.svg" alt="add" />
								</div>
							</div>
						</a>
					</c:forEach>
				</div>
			</div>
		</div>

		<div class="info">
			<div class="title">
				<div class="line"></div>
				<h6>其他</h6>
			</div>
			<div class="container">
				<div class="row clearfix">
					<c:forEach items="${gd_map.other }" var="goods">
						<a href="#">
							<div class="col-xs-12 item">
								<div class="goods col-xs-3">
									<img src="${goods.imgUrl }" alt="item" />
								</div>
								<div class="col-xs-6">
									<h3>${goods.name }</h3>
									<h4>${goods.intro }</h4>
									<h5>${goods.price }积分</h5>
								</div>
								<div class="col-xs-3">
									<img class="add" src="img/add.svg" alt="add" />
								</div>
							</div>
						</a>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="foot">——我可是有底线的——</div>
		<div class="container" id="bar">
			<div class="row clearfix">
				<div class="col-xs-8">
					<div>
						<h5>
							<c:choose>
								<c:when test="${point!=null }">
									我的积分：${point }
								</c:when>
								<c:when test="${point==null }">
									<a href="login">请登录，亲</a>
								</c:when>
							</c:choose>
						</h5>
					</div>
				</div>
				<div class="col-xs-4 shop">
					<div>
						<img src="img/shop.svg" alt="shop">
						<h4>兑换</h4>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/my.js"></script>
</body>
</html>