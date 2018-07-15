<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" type="text/css" href="css/regedit.css">
<link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
	<div class="bg">
		<div class="container">
			<div class="row clearfix">
				<div class="col-xs-3">
					<a href="javascript:history.go(-1)"><i class="fa fa-angle-left"></i></a>
				</div>
				<div class="col-xs-6">
					<h3 class="title">用户注册</h3>
				</div>
			</div>
			<div class="row clearfix form">
				<div class="col-xs-10 col-xs-offset-1">
					<form id="regeditForm" method="post">
						<div class="form_bg">
							<i class="fa fa-user fa-2x"></i> <input type="text" id="username"
								name="username" placeholder="请输入用户名" pattern="^[^<\/>]+$"
								data-toggle="tooltip" data-placement="bottom" />
						</div>
						<span for="username"></span>
						<div class="form_bg">
							<i class="fa fa-user fa-2x"></i> <input type="text" id="realname"
								name="realname" placeholder="请输入真实姓名" pattern="^[^<\/>]+$"
								data-toggle="tooltip" data-placement="bottom" />
						</div>
						<span for="realname"></span>
						<div class="form_bg">
							<i class="fa fa-lock fa-2x"></i> <input type="password"
								id="password" name="password" autocomplete="off" placeholder="请输入密码"
								pattern="^[^<\/>]+$" data-toggle="tooltip"
								data-placement="bottom" />
						</div>
						<span for="password"></span>
						<div class="form_bg">
							<i class="fa fa-lock fa-2x"></i> <input type="password" id="apwd"
								name="apwd" autocomplete="off" placeholder="再次输入密码" pattern="^[^<\/>]+$"
								data-toggle="tooltip" data-placement="bottom" />
						</div>
						<span for="apwd"></span>
						<div class="my_select">
							<ul>
								<li>校区 <select id="school" name="school">
										<option selected>天河校区 </option>
										<option>白云校区 </option>
								</select>
								</li>
								<span for="school"></span>
								<br />
								<li>楼栋 <select id="floor" name="floor">
										<option selected>1栋 </option>
										<option>2栋 </option>
								</select>
								</li>
								<span for="floor"></span>
								<li>宿舍 <select id="dormitory" name="dormitory">
										<option selected>101 </option>
										<option>102 </option>
								</select>
								</li>
								<span for="dormitory"></span>
							</ul>
						</div>
						<div class="form_bg">
							<i class="fa fa-phone fa-2x"></i> <input type="text" id="phone"
								name="phone" placeholder="请输入手机号码" pattern="^[^<\/>]+$"
								data-toggle="tooltip" data-placement="bottom" />
						</div>
						<span for="phone"></span>
						<div class="row clearfix form">
							<div class="col-xs-8">
								<div class="form_bg">
									<input type="text" name="vdcode" id="vdcode"
										placeholder="请输入验证码" pattern="^[^<\/>]+$"
										data-toggle="tooltip" data-placement="bottom" />
								</div>
								<span for="vdcode"></span>
							</div>
							<div class="col-xs-4">
<!-- 								<button class="getvdcode" type="button">获取验证码</button> -->
									<img src="createValidateCode" alt="vdCode">
							</div>
						</div>
						<div class="row clearfix">
							<div class="col-xs-12">
								<input class="regedit" type="submit" value="完成" />
							</div>
						</div>
						<div class="row clearfix">
							<div class="col-xs-12">
								<a href="login" class="login">已有账号，直接登录&gt;</a>
							</div>
						</div>

					</form>
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
		</div>
	</div>

	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/jquery.serializejson.min.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/messages_zh.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/my.js"></script>
	<script src="js/regedit.js"></script>
</body>
</html>