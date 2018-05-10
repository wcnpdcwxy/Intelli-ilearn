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
										<a class="color" href="toHome" target="home">Home</a>
									</li>
									<li>
										<a class="color1" href="product.html">计算机</a>
									</li>
									<li>
										<a class="color2" href="product.html">Sale</a>
									</li>
									<li>
										<a class="color3" href="product.html">Sale</a>
									</li>
									<li>
										<a class="color4" href="404.html">About</a>
									</li>
									<li>
										<a class="color5" href="typo.html">Short Codes</a>
									</li>
									<li>
										<a class="color6" href="contact.html">Contact</a>
									</li>
								</ul>
							</div>
							<!-- /.navbar-collapse -->

						</nav>
					</div>
					<div class="col-sm-3 search-right" style="background-color: white;height: 50px;">
						<ul class="heart">
                            <li>
								<form id="searchAction">
                                    <input type="text" name="searchContent" placeholder="Search..">
                                    <a src="doSearch"><i class="glyphicon glyphicon-search"> </i></a>
                                </form>
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

</html>