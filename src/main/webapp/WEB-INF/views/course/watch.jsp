<!--课程播放页面-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<title>课程播放页面</title>
		<link href="../../../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="../../../js/jquery.min.js"></script>
		<script src="../../../js/bootstrap.min.js"></script>
	</head>

	<body style="background-color: antiquewhite">
		<div class="container">
			<!--视频播放-->
			<div style="background-color: black">
                <%--${Vdetail.content.vdAddr}--%>
				<video src="${Vdetail.content.vdAddr}" autoplay="autoplay" controls="controls" width="100%" height="600px">
				</video>
			</div>
            <div style="height: 20px;background-color: antiquewhite"></div>

			<!--评论-->
			<div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">评论</h3>
					</div>
					<c:forEach items="${Vdetail.list}" var="discuss" varStatus="status">
						<div class="panel-body">
                            <div style="height: 5px;">
                                <h4 style="margin-top: 0px;"><b>${discuss.userNickName}:</b></h4>
                            </div>
                            <div style="margin-top: 20px;padding-left: 20px;">
							    <p>&nbsp;&nbsp;&nbsp;&nbsp;${discuss.content}</p>
                                <div style="float: right;margin-right: 10px">
                                    <h6>${discuss.time}&nbsp;&nbsp;&nbsp;#${status.count}楼</h6>
                                </div>
                            </div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</body>

</html>