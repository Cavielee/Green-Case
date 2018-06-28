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
<title>服务器出错</title>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<meta content="IE=edge" http-equiv="X-UA-compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/mistake.css">
<link rel="shortcut icon" href="img/favicon.ico">
</head>
<body class="error">

	<div id="doc_main">
		<h2>500</h2>
		<section class="bd clearfix">
			<div class="module-error">
				<div class="error-main clearfix">
					<div class="label"></div>
					<div class="info">
						<h3 class="title">抱歉，服务器内部错误。</h3>
						<div class="reason">
							<p>可能的原因：</p>
							<p>1.服务器繁忙。</p>
							<p>2.服务器内部出错。</p>
						</div>
						<div class="oper">
							<p>
								<a href="javascript:history.go(-1);">返回上一级页面&gt;</a>
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

	<script src="js/jquery-1.11.2.min.js"></script>
</body>
</html>
