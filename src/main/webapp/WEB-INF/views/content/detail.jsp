<!--课程详情页面-->
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>课程详情页面</title>
        <link href="../../../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="../../css/jquery.raty.css" rel="stylesheet" type="text/css" media="all" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="../../../js/jquery.min.js"></script>
        <script src="../../js/jquery.raty.js"></script>
    </head>
    <body style="background-color: antiquewhite">
    	<div class="container" >
    		<!--上方课程介绍区域-->
    		<div style="width: 100%;height: 290px;background-color: white;">
    			<div style="width: 100%;height: 250px;padding-top: 20px;padding-left: 20px">
                    <!--左半边图片区域-->
                    <div style="width: 35%;height:250px;float: left;">
                        <img id="course_pic" src="${detail.course.picAddr}" style="height: 100%;width: 100%;"/>
                    </div>
                    <!--右半边详情区域-->
                    <div style="float: left;width: 60%;height: 250px;margin-left: 20px;">
                        <!--上25%-->
                        <div style="height: 30%">
                            <!--左80%-->
                            <div style="width: 80%">
                                <!--上75%-->
                                <div style="height: 70%">
                                    <h2>
                                        ${detail.course.courseName}
                                    </h2>
                                </div>
                                <div style="height: 20%;">
                                    <!--打分mark-->
                                    <div style="padding-top: 7px;float: left;">
                                        <div id="star" data-score="${detail.course.mark}"></div>
                                    </div>
                                    <!--讲师-->
                                    <div style="float: left;margin-left: 10px">
                                        <h5>
                                            讲师：${detail.course.userNickName} &nbsp;
                                            上传时间：${detail.course.time}
                                        </h5>
                                    </div>
                                </div>
                            </div>
                            <!--右20%-->
                            <div>
                                <!--收藏等功能-->
                            </div>
                        </div>
                        <!--下20%-->
                        <div style="height: 32%">
                            <span>
                                <h2 style="color: red">
                                    免费
                                </h2>
                            </span>
                        </div>
                        <div style="height: 22%">
                            <!--橘黄色按钮单击触发方法-->
                            <div style="width: 160px;height: 54px;background-color: darkorange;color: white">
                                <span>
                                    <h2 style="margin-top: 0px;text-align: center;padding-top: 10px">
                                        开始学习
                                    </h2>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
    		</div>
    		<!--下方展示区域-->
    		<div>
                <div style="background-color: whitesmoke">
                    <ul class="nav nav-pills">
                        <li role="presentation"><a href="toIntro" target="main_frame">课程介绍</a></li>
                        <li role="presentation"><a href="toVedioMenu" target="main_frame">课程目录</a></li>
                    </ul>
                </div>
                <div style="height: 20px;background-color: antiquewhite"></div>
                <div style="width: 100%;height: 1000px;">
                    <iframe src="toIntro" name="main_frame" frameborder="0" scrolling="no" id="external-frame" onload="setIframeHeight(this)" style="width: 100%"></iframe>
                </div>
    		</div>
    	</div>	
 	</body>
    <script>
        $('#star').raty({
            number: 5,
            readOnly: true,
            half: true,
        });

        function setIframeHeight(iframe) {
            if (iframe) {
                var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
                if (iframeWin.document.body) {
                    iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
                }
            }
        };

        window.onload = function () {
            setIframeHeight(document.getElementById('external-frame'));
        };
    </script>
</html>