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
<link rel="stylesheet" type="text/css" href="css/editInfo.css">
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
					<h3 class="title">添加积分商品</h3>
				</div>
			</div>
			<div class="row clearfix">
				<form id="createGoodsForm">
					<div class="col-xs-12">
						<div class="tx">
							<img alt="avatar" src="img/avatar.jpg" /> <input type="file"
								name="img" multiple="multiple" /> <span for="imgUrl"
								id="spanImgUrl"></span>
						</div>
					</div>
					<div class="col-xs-12">
						<ul>
							<input type="text" id="imgUrl" name="imgUrl" pattern="^[^<\/>]+$"
								value="" />
							<li>商品名 <input type="text" id="name" name="name"
								placeholder="请输入商品名" pattern="^[^<\/>]+$" data-toggle="tooltip"
								data-placement="bottom" />

							</li>
							<span for="name"></span>
							<li>商品介绍 <input type="text" id="intro" name="intro"
								placeholder="请输入商品介绍 " pattern="^[^<\/>]+$"
								data-toggle="tooltip" data-placement="bottom" />

							</li>
							<span for="intro"></span>
							<li>商品价格 <input type="text" id="price" name="price"
								placeholder="请输入商品价格" pattern="^[^<\/>]+$" data-toggle="tooltip"
								data-placement="bottom" />

							</li>
							<span for="price"></span>
							<li>商品类型 <select id="type" name="type">
									<option selected>美食</option>
									<option>生活</option>
									<option>电影</option>
									<option>其他</option>
							</select>
							</li>
							<span for="type"></span>
						</ul>
						<ul class="editInfo">
							<button type="submit">确认</button>
						</ul>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/jquery.serializejson.min.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/messages_zh.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/my.js"></script>
	<script src="js/createPointGoods.js"></script>
</body>
</html>