<!--课程详情页面-->
<!DOCTYPE html>
<html>
    <head>
        <title>课程详情页面</title>
        <link href="../../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        
        <meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="../../js/jquery.min.js"></script>
    </head>
    <body>
    	<div class="container">
    		<!--上方课程介绍区域-->
    		<div>
    			<!--左半边图片区域-->
    			<div>
    				<img id="course_pic" src="${course.picAddr}"  />
    			</div>
    			<!--右半边详情区域-->
    			<div>
    				<!--上25%-->
    				<div>
    					<!--左80%-->
    					<div>
    						<!--上75%-->
    						<div>
    							<font>
    								${course.courseName}
    							</font>
    						</div>
    						<div>
    							<!--打分mark-->
    							<!--讲师-->
    							<font>
    								讲师：${course.nickName}
    								上传时间：${course.time}
    							</font>
    						</div>
    					</div>
    					<!--右20%-->
    					<div>
    						<!--收藏等功能-->
    					</div>
    				</div>
    				<!--下20%-->
    				<div>
    					<!--橘黄色按钮单击触发方法-->
    					<button >
    						开始学习
    					</button>
    				</div>
    			</div>
    		</div>
    		<!--下方展示区域-->
    		<div>
    			<frameset cols="*,*">
					<frame src="menu.html">
					<frame src="main.html" name="main_frame">
				</frameset> 
    		</div>
    	</div>	
 	</body>
</html>