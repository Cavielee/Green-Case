<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
<link rel="stylesheet" type="text/css" href="css/user.css">
<link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
	<div class="bg">

		<div>
			<c:choose>
				<c:when test="${userInfo == null }">
					<div class="tx">
						<img alt="avatar" src="img/avatar.jpg" />
					</div>
					<a href="login">
						<div class="info">
							<h3>点击登录</h3>
						</div>
					</a>
				</c:when>
				<c:otherwise>
					<div class="tx">
						<img alt="avatar" src="${userInfo.avatar }" />
					</div>
					<div class="info">
						<h4>${userInfo.username }</h4>
						<h5>${userInfo.floor }${userInfo.dormitory }</h5>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="clear"></div>
		<div class="ahover">
			<ul>
				<sec:authorize access="hasAnyRole('USER','ANONYMOUS')">
					<a href="userInfo"><li>我的资料<i class="fa fa-angle-right"></i></li></a>
					<a href="pointRecord?pageNum=1"><li>积分记录<i
							class="fa fa-angle-right"></i></li></a>
					<a href="orderList?pageNum=1"><li>预约记录<i
							class="fa fa-angle-right"></i></li></a>
					<li>奖品记录<i class="fa fa-angle-right"></i></li>
				</sec:authorize>
				<sec:authorize access="hasAnyRole('ADMIN','ORDERWORK')">
					<a href="untreatedOrders?pageNum=1"><li>未处理订单<i
							class="fa fa-angle-right"></i></li></a>
				</sec:authorize>
				<sec:authorize access="hasAnyRole('ADMIN','GOODSWORK')">
					<a href="goodsManage?pageNum=1"><li>管理商品<i
							class="fa fa-angle-right"></i></li></a>
					<a href="pointGoodsManage?pageNum=1"><li>管理积分商品<i
							class="fa fa-angle-right"></i></li></a>
				</sec:authorize>
				<sec:authorize access="hasRole('ADMIN')">
					<a href="#"><li>添加视频<i
							class="fa fa-angle-right"></i></li></a>
				</sec:authorize>
				<sec:authorize access="hasRole('ADMIN')">
					<a href="orderWorks?pageNum=1"><li>子管理员<i
							class="fa fa-angle-right"></i></li></a>
				</sec:authorize>
			</ul>
			<ul>
				<c:choose>
					<c:when test="${userInfo==null }">
						<a href="login" class="login"><li>登录</li></a>
					</c:when>
					<c:otherwise>
						<a href="logout" class="logoff"><li>注销</li></a>
					</c:otherwise>
				</c:choose>

			</ul>
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
		<script src="js/jquery-1.11.2.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/my.js"></script>
</body>
</html>
