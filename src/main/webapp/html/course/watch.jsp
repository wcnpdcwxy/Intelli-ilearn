<!--课程播放页面-->
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<title>课程播放页面</title>
		<link href="../../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="../../js/jquery.min.js"></script>
		<script src="../../js/bootstrap.min.js"></script>
	</head>

	<body>
		<div class="container">
			<!--视频播放-->
			<div>
				<video src="${content.vdAddr}" autoplay="autoplay" controls="controls" width="100%" height="">
				</video>
			</div><br />
			<!--评论-->
			<div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">评论</h3>
					</div>
					<c:forEach items="${list}" var="discuss" varStatus="status">
						<div class="panel-body">
							<h6><b>${discuss.nickName}</b>&nbsp;&nbsp;&nbsp;${discuss.time}&nbsp;&nbsp;&nbsp;#${status.count}楼</h6>
							<p>${discuss.content}</p>
						</div>
					</c:foreach>
				</div>
			</div>
		</div>
	</body>

</html>