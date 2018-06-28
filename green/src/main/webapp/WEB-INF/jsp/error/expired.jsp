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
<title>异处已登录</title>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<meta content="IE=edge" http-equiv="X-UA-compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="static/css/mistake.css">
<link rel="shortcut icon" href="static/img/favicon.ico">
</head>
<body class="error">

	<div id="doc_main">
		<h2>异处已登录</h2>
		<section class="bd clearfix">
			<div class="module-error">
				<div class="error-main clearfix">
					<div class="label"></div>
					<div class="info">
						<h3 class="title">抱歉，您的账号在异处登录，请重新登录。</h3>
						<div class="reason">
							
						</div>
						<div class="oper">
							<p>
								<a href="login">登录页面&gt;</a>
							</p>
							<p>
								<a href="index">回到网站首页&gt;</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>

	<script src="static/js/jquery-1.11.2.min.js"></script>
</body>
</html>
