<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>盒你益起</title>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/sharestyle.css">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">
<link rel="stylesheet" type="text/css" href="css/green.css">
<link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
	<div class="bg">
		<div class="container">
			<div class="row clearfix">
				<div class="col-xs-offset-3 col-xs-6">
					<div class="logo"></div>
					<h3>盒你益起</h3>
					<h5>盒你环保，益起梦行</h5>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row clearfix">
				<div class="col-xs-10 col-xs-offset-1">
					<button class="regedit">注册账号</button>
					<button class="login">登录</button>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row clearfix">
				<div class="col-xs-5">
					<div class="qq">
						<i class="fa fa-qq"></i>
					</div>
				</div>
				<div class="col-xs-5 col-xs-offset-2">
					<div class="wechat">
						<i class="fa fa-wechat fa-2x"></i>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/my.js"></script>
	<script type="text/javascript">
		$(".login").click(function() {
			window.location.href = 'login';
		})
		$(".regedit").click(function() {
			window.location.href = 'regedit';
		})
	</script>
</body>
</html>