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
<link rel="stylesheet" type="text/css" href="css/editInfo.css">
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
					<h3 class="title">添加工作人员</h3>
				</div>
			</div>
			<div class="row clearfix">
				<form id="createWorkForm">
					<div class="col-xs-12">
						<div class="tx">
							<img alt="avatar" src="img/avatar.jpg" /> <input type="file"
								name="img" multiple="multiple" />
						</div>
					</div>
					<div class="col-xs-12">
						<ul>
							<input type="text" id="avatar" name="avatar" pattern="^[^<\/>]+$"
								value="" />
							<li>用户名 <input type="text" id="username" name="username"
								placeholder="请输入用户名" pattern="^[^<\/>]+$" data-toggle="tooltip"
								data-placement="bottom" />

							</li>
							<span for="username"></span>
							<li>密码 <input type="password" id="password" name="password"
								placeholder="请输入密码" pattern="^[^<\/>]+$" data-toggle="tooltip"
								data-placement="bottom" />
							</li>
							<span for="password"></span>
							<li>确认密码 <input type="password" id="apwd" name="apwd"
								placeholder="再次输入密码" pattern="^[^<\/>]+$" data-toggle="tooltip"
								data-placement="bottom" />
							</li>
							<span for="apwd"></span>
							<li>工作人员类型 <select id="type" name="type">
									<option selected>订单工作人员</option>
									<option>商品工作人员</option>
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
	<script src="js/createWork.js"></script>
</body>
</html>