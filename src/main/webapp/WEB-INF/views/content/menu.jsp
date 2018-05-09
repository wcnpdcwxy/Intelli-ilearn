<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("ctx", path);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
	<head>
		<title>导航页面</title>
        <link href="../../../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="../../../js/jquery.min.js"></script>
		<script src="../../../js/bootstrap.min.js"></script>
	</head>
	<body>
		<ul class="nav nav-pills">
			<li role="presentation" class="active"><a href="intro.jsp" target="main_frame">Home</a></li>
			<li role="presentation"><a href="vedioMenu.jsp" target="main_frame">Profile</a></li>
		</ul>
	</body>
</html>
