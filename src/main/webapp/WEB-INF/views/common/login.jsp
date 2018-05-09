<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("ctx", path);
%>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
        <script src="../../../js/jquery.min.js"></script>
		<style>
			.loginDiv {
				width: 516px;
				height: 297px;
			}
			
			.login-do {
				padding-bottom: 2em;
			}
			
			.login-tab {
				border: 1px solid #E9E9E9;
				margin-bottom: 2em;
                margin-top: 2em;
				padding: 0.5em 1em;
			}
			
			.login-tab input[type="text"],
			.login-tab input[type="password"] {
				border: none;
				outline: none;
				font-size: 0.9em;
				color: #999;
				width: 95%;
			}
		</style>
	</head>

	<script>
        function login(){
            var loginName1=$("#userName").val();
            var password1=$("#password").val();
            alert("测试！");
            if(loginName1==''||password1==''){
                $("#tips").html("用户名、密码、验证码不能为空");
            }else{
                $.ajax({
                    type : "post",
                    url :"/logined",
                    data:{userName:loginName1,password:password1},
                    success : function(data) {
                        /*if(data==1){
                            $("#tips").html("验证码错误");
                        }else */
                        if(data=="error"){
                            $("#tips").html("用户名或密码错误");
                        }else if(data=="success"){
                            window.parent.location.href="toIndex";
                        }
                    }

                });
            }
        }
	</script>

	<body>
		<div class="loginDiv">
			<div class="login-do">
				<form id="loginForm">
					<div class="login-tab">
						<input type="text" name="userName" id="userName" placeholder="用户名" required="">
					</div>
					<div class="login-tab" style="margin-bottom: 1em">
						<input type="password" name="password" id="password" placeholder="密码" required="">
					</div>
                    <label id="tips" style="margin-left: 20%;font-size: small;color: red"></label>
					<div style="border: none;outline: none;height: 50px; width: 95%;background-color: yellowgreen; font-size: 1em;  text-align: center;margin-top: 1em;" onclick="login()">
						<font style="color: white; line-height:50px;">
							登陆
						</font>
					</div>
				</form>
			</div>
		</div>
	</body>

</html>