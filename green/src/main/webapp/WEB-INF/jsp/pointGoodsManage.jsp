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
<link rel="stylesheet" type="text/css" href="css/goodsManage.css">
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
					<h3 class="title">商品管理</h3>
				</div>
			</div>
			<div class="row clearfix">
				<form id="goods">
					<div class="col-xs-12 goods">
						<div>
							<div class="line"></div>
							<h6>商品列表</h6>
							<div class="mybotton">
								<button type="button" onClick="CreateGoods()">添加</button>
								<button type="submit">删除</button>
							</div>
						</div>
						<c:forEach items="${page.list }" var="Goods">
							<div class="col-xs-12 item">
								<div class="checkbox">
									<input name="goodsName" type="checkbox" value="${Goods.name }">
								</div>
								<div class="goodsImg">
									<img src="${Goods.imgUrl }" alt="${Goods.name }" />
								</div>
								<div class="goodsInfo">
									<h3>${Goods.name }</h3>
									<h4>${Goods.intro }</h4>
									<h5>¥${Goods.price }</h5>
								</div>
							</div>
						</c:forEach>
					</div>
				</form>
			</div>
		</div>

		<div id="page">
			<ul>
				<%-- 构建分页导航 --%>
				当前为${page.pageNum}页，共${page.totalPage }页
				<br />
				<a href="pointGoodsManage?pageNum=1"><li class="first_page">首页</li></a>
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
								<a href="pointGoodsManage?pageNum=${i }"><li class="page">${i}</li></a>
							</c:if>
						</c:forEach>
						<a href="pointGoodsManage?pageNum=${page.pageNum+1 }"><li
							class="next_page">下一页</li></a>
					</c:when>
					<%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>
					<c:when test="${page.pageNum > 1 && page.pageNum < page.totalPage}">
						<a href="pointGoodsManage?pageNum=${page.pageNum-1 }"><li
							class="previous_page">上一页</li></a>
						<c:forEach begin="${page.start}" end="${page.end}" step="1"
							var="i">
							<c:if test="${page.pageNum == i}">
								<a><li class="page active">${i}</li></a>
							</c:if>
							<c:if test="${page.pageNum != i}">
								<a href="pointGoodsManage?pageNum=${i }"><li class="page">${i}</li></a>
							</c:if>
						</c:forEach>
						<a href="pointGoodsManage?pageNum=${page.pageNum+1 }"><li
							class="next_page">下一页</li></a>
					</c:when>
					<%--如果当前页是最后一页且总页数大于一时，则只有上一页这个超链接显示，下一页没有 --%>
					<c:when
						test="${page.pageNum == page.totalPage && page.totalPage > 1}">
						<a href="pointGoodsManage?pageNum=${page.pageNum-1 }"><li
							class="previous_page">上一页</li></a>
						<c:forEach begin="${page.start}" end="${page.end}" step="1"
							var="i">
							<c:if test="${page.pageNum == i}">
								<a><li class="page active">${i}</li></a>
							</c:if>
							<c:if test="${page.pageNum != i}">
								<a href="pointGoodsManage?pageNum=${i }"><li class="page">${i}</li></a>
							</c:if>
						</c:forEach>
					</c:when>
				</c:choose>
				<%--尾页 --%>
				<a href="pointGoodsManage?pageNum=${page.totalPage }"><li class="last_page">尾页</li></a>
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
	</div>

	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/jquery.serializejson.min.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/messages_zh.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/pointGoodsManage.js"></script>
	<script src="js/my.js"></script>
</body>
</html>