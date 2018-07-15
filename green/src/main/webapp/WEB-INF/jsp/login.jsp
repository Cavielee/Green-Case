<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<title>盒你益起</title>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<meta content="IE=edge" http-equiv="X-UA-compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/sharestyle.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
	<div class="bg">
		<div class="container">
			<div class="row clearfix">
				<div class="col-xs-4">
					<a href="javascript:history.go(-1)"><i class="fa fa-angle-left"></i></a>
				</div>
				<div class="col-xs-4">
					<h3 class="title">登录</h3>
				</div>

			</div>
			<div class="row clearfix">
				<div class="col-xs-12">
					<img class="avatar" alt="avatar" src="img/avatar.jpg" />
				</div>
			</div>
			<div class="row clearfix form">
				<div class="col-xs-10 col-xs-offset-1">
					<c:url value="/check_login" var="loginUrl" />
					<form id="loginForm" action="${loginUrl }" method="post" accept-charset="UTF-8">
						<div class="form_bg">
							<i class="fa fa-user fa-2x"></i> <input type="text" id="username"
								name="username" placeholder="请输入用户名" pattern="^[^<\/>]+$"
								data-toggle="tooltip" data-placement="bottom" title="请勿输入<\/>]$" />
						</div>
						<span for="username"></span>
						<div class="form_bg">
							<i class="fa fa-lock fa-2x"></i> <input type="password"
								id="password" name="password" autocomplete="off" placeholder="请输入密码"
								pattern="^[^<\/>]+$" data-toggle="tooltip"
								data-placement="bottom" title="请勿输入<\/>]$" />
						</div>
						<span for="password"></span>
						<div class="row clearfix">
							<div class="col-xs-12">
								<div class="remember">
									<input type="checkbox" name="remember-me" />
									<button type="button" id="myremember">自动登录</button>
								</div>
							</div>
						</div>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<div class="row clearfix">
							<div class="col-xs-12">
								<input type="submit" class="login" value="登录" />
							</div>
						</div>
					</form>
					<div class="row clearfix">
						<div class="col-xs-12">
							<button class="regedit">注册账号</button>
						</div>
						<div class="col-xs-12">
							<span class="forget">忘记密码？</span>
						</div>
					</div>
				</div>
			</div>

			<div class="row clearfix">
				<div class="col-xs-4 ">
					<div class="line"></div>
				</div>
				<div class="col-xs-4 company">
					<span>Green Case</span>
				</div>
				<div class="col-xs-4">
					<div class="line"></div>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-xs-5 ">
					<i class="fa fa-qq fa-2x" style="float: right"></i>
				</div>
				<div class="col-xs-2"></div>
				<div class="col-xs-5">
					<i class="fa fa-wechat fa-2x"></i>
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
	<script src="js/login.js"></script>
</body>
</html>