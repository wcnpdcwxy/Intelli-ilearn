<%@ page import="com.edu360.ilearn.Vo.PageVo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("ctx", path);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<title>个人信息页面</title>

		<!-- Bootstrap core CSS -->
		<link href="../../../css/bootstrap.css" rel="stylesheet">
		<link href="../../../css/font-awesome.min.css" rel="stylesheet">

		<!-- Custom styles for this template -->
		<link href="../../../css/main.css" rel="stylesheet">


        <script src="../../../js/jquery.js"></script>
        <script src="../../../js/bootstrap.min.js"></script>
        <script src="../../../js/demoad.js"></script>
	</head>

	<body>

		<div class="container">
			<div class="col-lg-10 col-lg-offset-1">

				<!-- ===== vCard Navigation ===== -->
				<div class="row w">
					<div class="col-md-4">
						<img class="img-responsive" src="../../../images/avatar.jpg" alt="">
						<ul class="nav nav-tabs nav-stacked" id="myTab">
							<li>
								<a href="#profile">用户管理</a>
							</li>
                            <li>
                                <a href="#portfolio">课程管理</a>
                            </li>
						</ul>
					</div>
					<!-- col-md-4 -->

					<!-- ===== vCard Content ===== -->
					<div class="col-md-8">
						<div class="tab-content">
							<!-- ===== Second Tab ===== -->
							<div class="tab-pane centered" id="profile">
                                <div style="height:500px; width: 100%;">
                                    <iframe src="toUserManager" name="secondTab" id="secondTab" style="width: 100%;height: 100%;border: none;"></iframe>
                                </div>
							</div>
							<!-- Tab Profile -->

							<!-- ===== Third Tab ===== -->
							<div class="tab-pane" id="portfolio">
                                <div style="height:500px; width: 100%;">
                                    <iframe src="toCourseManager" name="thirdTab" id="thirdTab" style="width: 100%;height: 100%;border: none;"></iframe>
                                </div>
							</div>
							<!-- /Tab Portfolio -->
						</div>
						<!-- Tab Content -->
					</div>
					<!-- col-md-8 -->
				</div>
				<!-- row w -->
			</div>
			<!-- col-lg-6 -->
		</div>
		<!-- /.container -->


        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">修改密码</h4>
                    </div>
                    <div class="modal-body">
                        <form name="pdAction" action="/password" method="post">
                            <div style="padding-left: 30px">
                                <table>
                                    原密码:<input type="text" id="oldpd" name="oldpd" placeholder="原密码"><br/>
                                    新密码: <input type="text" id="newpd" name="newpd" placeholder="新密码"><br/>
                                    重复新密码:<input type="text" id="againpd" name="againpd" placeholder="重复新密码">
                                </table>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-primary" onclick = 'javascript:if(document.getElementById("newpd").value==document.getElementById("againpd").value){window.document.getElementsByName("pdAction")[0].submit()}else{confirm("新密码不一致,请检查后重试")}'>提交</button>
                    </div>
                </div>
            </div>
        </div>
	</body>
    <script>
        $('#myTab a').click(function(e) {
            e.preventDefault()
            $(this).tab('show')
        })
    </script>
</html>