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
<link rel="stylesheet" type="text/css" href="css/sale.css">
<link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
	<div class="bg">
		<div class="container-fluid">
			<div id="topbar" class="row clearfix">
				<div class="col-xs-2">
					<a href="index"><i class="fa fa-angle-left"></i></a>
				</div>
				<div class="col-xs-8">
					<ul id="btn">
						<a id="active">
							<li class="first">义卖</li>
						</a>
						<a>
							<li class="second">展览</li>
						</a>
						<a href="videoList?pageNum=1">
							<li class="third">制作</li>
						</a>
					</ul>
				</div>
				<div class="col-xs-2">
					<a><i class="fa fa-search"></i></a>
				</div>
			</div>
			<div class="row clearfix">
				<div id="Carousel" class="carousel slide" data-pause="hover"
					data-ride="carousel" data-interval="4500">
					<!-- 轮播（Carousel）指标 -->
					<!--
					<ol class="carousel-indicators">
						<li data-target="#Carousel" data-slide-to="0" class="active"></li>
						<li data-target="#Carousel" data-slide-to="1"></li>
						<li data-target="#Carousel" data-slide-to="2"></li>
					</ol>
      				-->
					<!-- 轮播（Carousel）项目 -->
					<div class="carousel-inner">
						<div class="item active">
							<img src="img/轮播/明信片.jpg" alt="First 明信片">
							<div class="carousel-caption">
								<h3>明信片</h3>
							</div>
						</div>
						<div class="item">
							<img src="img/轮播/广州塔.jpg" alt="Second 广州塔">
							<div class="carousel-caption">
								<h3>广州塔</h3>
							</div>
						</div>
						<div class="item">
							<img src="img/轮播/小镇.jpg" alt="Third 小镇">
							<div class="carousel-caption">
								<h3>小镇</h3>
							</div>
						</div>
					</div>
					<!-- 轮播（Carousel）导航 -->
					<a class="carousel-control left" href="#Carousel" data-slide="prev">&lsaquo;</a>
					<a class="carousel-control right" href="#Carousel"
						data-slide="next">&rsaquo;</a>
				</div>
			</div>
			<!-- 商品 -->
			<div class="row clearfix info">
				<c:forEach items="${page.list }" var="Goods">
					<a href="goodsDetail/${Goods.goods_id }">
						<div class="col-xs-12 item">
							<div class="goodsImg">
								<img src="${Goods.imgUrl }" alt="${Goods.name }" />
							</div>
							<div class="goodsInfo">
								<h3>${Goods.name }</h3>
								<h4>${Goods.intro }</h4>
								<h5>¥${Goods.price }</h5>
							</div>
							<div class="goodsAdd">
								<img src="img/add.svg" alt="add" />
							</div>
						</div>
					</a>
				</c:forEach>
			</div>
		</div>
		<div id="page">
			<ul>
				<%-- 构建分页导航 --%>
				当前为${page.pageNum}页，共${page.totalPage }页
				<br />
				<a href="sale?pageNum=1"><li class="first_page">首页</li></a>
				<c:choose>
					<%--只有一页 --%>
					<c:when test="${page.totalPage ==1}">
						<a><li class="page active">1</li></a>
					</c:when>
					<%--如果当前页为第一页且总页数大于一时，就没有上一页这个超链接显示 --%>
					<c:when test="${page.pageNum ==1 && page.totalPage > 1}">
						<c:forEach begin="${page.start}" end="${page.end}" step="1"
							var="i">
							<c:if test="${page.pageNum == i}">
								<a><li class="page active">${i}</li></a>
							</c:if>
							<c:if test="${page.pageNum != i}">
								<a href="sale?pageNum=${i }"><li class="page">${i}</li></a>
							</c:if>
						</c:forEach>
						<a href="sale?pageNum=${page.pageNum+1 }"><li
							class="next_page">下一页</li></a>
					</c:when>
					<%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>
					<c:when test="${page.pageNum > 1 && page.pageNum < page.totalPage}">
						<a href="sale?pageNum=${page.pageNum-1 }"><li
							class="previous_page">上一页</li></a>
						<c:forEach begin="${page.start}" end="${page.end}" step="1"
							var="i">
							<c:if test="${page.pageNum == i}">
								<a><li class="page active">${i}</li></a>
							</c:if>
							<c:if test="${page.pageNum != i}">
								<a href="sale?pageNum=${i }"><li class="page">${i}</li></a>
							</c:if>
						</c:forEach>
						<a href="sale?pageNum=${page.pageNum+1 }"><li
							class="next_page">下一页</li></a>
					</c:when>
					<%--如果当前页是最后一页且总页数大于一时，则只有上一页这个超链接显示，下一页没有 --%>
					<c:when
						test="${page.pageNum == page.totalPage && page.totalPage > 1}">
						<a href="sale?pageNum=${page.pageNum-1 }"><li
							class="previous_page">上一页</li></a>
						<c:forEach begin="${page.start}" end="${page.end}" step="1"
							var="i">
							<c:if test="${page.pageNum == i}">
								<a><li class="page active">${i}</li></a>
							</c:if>
							<c:if test="${page.pageNum != i}">
								<a href="sale?pageNum=${i }"><li class="page">${i}</li></a>
							</c:if>
						</c:forEach>
					</c:when>
				</c:choose>
				<%--尾页 --%>
				<a href="sale?pageNum=${page.totalPage }"><li class="last_page">尾页</li></a>
			</ul>
		</div>
	</div>
	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/my.js"></script>
	<script src="js/hammer.min.js"></script>
	<script src="js/sale.js"></script>
</body>
</html>