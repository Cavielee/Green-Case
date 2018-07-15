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
<link rel="stylesheet" type="text/css" href="css/userInfo.css">
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
					<h3 class="title">用户资料</h3>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-xs-12">
					<div class="tx">
						<c:choose>
							<c:when test="${userInfo.avatar == 'img/avatar.jpg' }">
								<img alt="avatar" src="${userInfo.avatar }" />
							</c:when>
							<c:otherwise>
								<img alt="avatar" src="${userInfo.avatar }" />
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="col-xs-12">
					<ul>
						<a class="foucs" href="editInfo">
							<li>用户名
								<p>${userInfo.username }</p> <i class="fa fa-angle-right"></i>
						</li>
						</a>
						<a class="pointRecord" href="editInfo">
							<li>我的积分
								<p>${userInfo.point }</p> <i class="fa fa-angle-right"></i>
						</li>
						</a>
						<a class="foucs" href="editInfo">
							<li>真实姓名
								<p>${userInfo.realname }</p> <i class="fa fa-angle-right"></i>
						</li>
						</a>
						<a class="foucs" href="editInfo">
							<li>地址
								<p>${userInfo.school }${userInfo.floor }${userInfo.dormitory }</p>
								<i class="fa fa-angle-right"></i>
						</li>
						</a>
						<a class="foucs" href="editInfo">
							<li>电话
								<p>${userInfo.phone }</p> <i class="fa fa-angle-right"></i>
						</li>
						</a>
					</ul>
					<ul class="editInfo">
						<a href="editInfo"><li>编辑资料</li></a>
					</ul>
				</div>
			</div>

		</div>
	</div>

	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/my.js"></script>
</body>
</html>