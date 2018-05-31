<%@ page import="com.edu360.ilearn.entity.User" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("ctx", path);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<html>

	<head>
		<title>Top</title>
		<link href="../../../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
		<!-- Custom Theme files -->
		<!--theme-style-->
		<link href="../../../css/style.css" rel="stylesheet" type="text/css" media="all" />
		<!--//theme-style-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<!--theme-style-->
		<link href="../../../css/style4.css" rel="stylesheet" type="text/css" media="all" />
		<!--//theme-style-->
		<script src="../../../js/jquery.min.js"></script>
		<!--- start-rate---->
        <script type="text/javascript">
			jQuery(function() {
                $('#login_btn').click(function() {
                    window.parent.abc();
                });
<%
    User user = new User();
	if(session.getAttribute("user")!=null){
       %>
            document.getElementById("inline").style.display="";
            document.getElementById("outline").style.display="none";
            <%
            user = (User)session.getAttribute("user");
            System.out.println(user);
            %>
       <%
	}else{
	    %>
            document.getElementById("inline").style.display="none";
            document.getElementById("outline").style.display="";
        <%
    }
%>
			});
		</script>
		<!---//End-rate---->
	</head>

	<body style="background-color: antiquewhite">
		<!--header-->
		<div class="header">
			<div class="container">
				<div class="head">
					<div class=" logo">
						<a href="#"><img src="../../../images/logo2.png" alt=""></a>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="header-top">
					<div class="col-sm-7 col-md-offset-2  header-social">
						<ul>
							<li></li>
							<li></li>
							<li></li>
							<li></li>
							<li></li>
						</ul>

					</div>
					<div class="col-sm-3 header-login">
						<ul id="inline" style="display: none">
							<li onclick = "javascript:if(confirm('您确定要退出吗？')){window.parent.location.href='logOut'}">
								<a id="logout_btn" src="javascript:;;">登出</a>
							</li>
                            <li>
                                <a id="user_name" src="toMyInfo">欢迎您！${user.nickName}</a>
                            </li>
                        </ul>
                        <ul id="outline">
							<li>
								<a id="login_btn">登陆/注册</a>
							</li>
						</ul>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>

			<div class="container" style="background-color: white">
				<div class="head-top">
					<div class="col-sm-7 col-md-offset-2 h_menu4" style="background-color: white">
						<nav class="navbar nav_bottom" role="navigation">
							<!-- Collect the nav links, forms, and other content for toggling -->
							<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
								<ul class="nav navbar-nav nav_1">
									<li>
										<a class="color" href="toHome" target="home">首页</a>
									</li>
									<li>
										<a class="color1" href="doType?type=计算机" target="home">计算机</a>
									</li>
									<li>
										<a class="color2" href="doType?type=经济管理" target="home">经济管理</a>
									</li>
									<li>
										<a class="color3" href="doType?type=心理学" target="home">心理学</a>
									</li>
									<li>
										<a class="color4" href="doType?type=外语" target="home">外语</a>
									</li>
									<li>
										<a class="color5" href="doType?type=文学历史" target="home">文学历史</a>
									</li>
									<li>
										<a class="color6" href="doType?type=艺术设计" target="home">艺术设计</a>
									</li>
								</ul>
							</div>
							<!-- /.navbar-collapse -->

						</nav>
					</div>
					<div class="col-sm-3 search-right" style="background-color: white;height: 50px;">
						<ul class="heart">
                            <li>
								<%--<form name="searchAction" action="/doSearch" method="get">--%>
                                    <input type="text" name="searchContent" id="searchContent" placeholder="Search.." value="">
                                    <a id="search_btn" href="javascript:toPage();" target="home"><i class="glyphicon glyphicon-search"> </i></a>
                                <%--</form>--%>
                            </li>
							<li>
								<a href="wishlist.html">
									<span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
								</a>
							</li>
						</ul>
						<div class="clearfix"> </div>

						<!----->

					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<!-- slide -->
		<script src="../../../js/bootstrap.min.js"></script>

	</body>
    <script>
        function toPage(page)
        {
            var pagevalue=document.getElementById("searchContent");
            window.parent.document.getElementById("showPage").src="doSearch?searchContent="+pagevalue.value;
        }
    </script>
</html>