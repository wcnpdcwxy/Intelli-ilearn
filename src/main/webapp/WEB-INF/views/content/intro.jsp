<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>课程介绍页面</title>
        <link href="../../../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="../../../js/jquery.min.js"></script>
		<script src="../../../js/bootstrap.min.js"></script>
    </head>
    <body>
		<div style="padding-left: 20px">
			<h3><b>适用人群</b></h3><br />
			<p>${detail.course.intro1}</p><br />
			<h3><b>课程概述</b></h3><br />
			<p>${detail.course.intro2}</p><br />
			<h3><b>联系方式</b></h3><br />
			<p>${detail.course.intro3}</p><br />
		</div>
 	</body>
</html>