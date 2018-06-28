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
					<a href="userInfo"><i class="fa fa-angle-left"></i></a>
				</div>
				<div class="col-xs-6">
					<h3 class="title">编辑资料</h3>
				</div>
			</div>
			<div class="row clearfix">
				<form id="editForm">
					<div class="col-xs-12">
						<div class="tx">
							<img alt="avatar" src="${userInfo.avatar }" /> <input
								type="file" name="img" multiple="multiple" />
						</div>
					</div>
					<div class="col-xs-12">
						<ul>
							<input type="text" id="avatar" name="avatar" pattern="^[^<\/>]+$"
								value="" />
							<li>用户名 <input type="text" id="username" name="username"
								placeholder="请输入用户名" pattern="^[^<\/>]+$" data-toggle="tooltip"
								data-placement="bottom" value="${userInfo.username }" />

							</li>
							<span for="username"></span>
							<li>真实姓名 <input type="text" id="realname" name="realname"
								placeholder="请输入真实姓名" pattern="^[^<\/>]+$" data-toggle="tooltip"
								data-placement="bottom" value="${userInfo.realname }" />
							</li>
							<span for="realname"></span>
							<li>校区 <select id="school" name="school">
									<option>天河校区</option>
									<option>白云校区</option>
							</select>
							</li>
							<span for="school"></span>
							<li>楼栋 <select id="floor" name="floor">
									<option>1栋</option>
									<option>2栋</option>
							</select>
							</li>
							<span for="floor"></span>
							<li>宿舍 <select id="dormitory" name="dormitory">
									<option>101</option>
									<option>102</option>
							</select>
							</li>
							<span for="dormitory"></span>
							<li>电话 <input type="text" id="phone" name="phone"
								placeholder="请输入手机号码" pattern="^[^<\/>]+$" data-toggle="tooltip"
								data-placement="bottom" value="${userInfo.phone }" />
							</li>
							<span for="phone"></span>
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
	<script src="js/editInfo.js"></script>
	<script type="text/javascript">
		$("#school option").each(function() {
			if ($(this).val() == "${userInfo.school }") {
				$(this).prop("selected", true);
			}
		});
		$("#floor option").each(function() {
			if ($(this).val() == "${userInfo.floor }") {
				$(this).prop("selected", true);
			}
		});
		$("#dormitory option").each(function() {
			if ($(this).val() == "${userInfo.dormitory }") {
				$(this).prop("selected", true);
			}
		});
	</script>
</body>
</html>