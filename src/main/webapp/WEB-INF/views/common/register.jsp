<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("ctx", path);
%>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Register</title>
        <script src="../../../js/jquery.min.js"></script>
		<style>
			.registerDiv {
				width: 516px;
				height: 297px;
			}
			
			.register-do {
				padding-bottom: 2em;
			}
			
			.register-tab {
				border: 1px solid #E9E9E9;
				margin-bottom: 1.5em;
				padding: 0.5em 1em;
			}
			
			.register-tab input[type="text"],
			.register-tab input[type="password"] {
				border: none;
				outline: none;
				font-size: 0.9em;
				color: #999;
				width: 95%;
			}
		</style>
	</head>

	<script>
        function register(){
            var userName1=$("#userName").val();
            var password1=$("#password1").val();
            var password2=$("#password2").val();
            alert("测试！");
            if(password1!==password2||password1==''||password2==''||userName1==''){
                $("#tips").html("用户名、密码不能为空且两次密码必须相同");
            }else{
				$.ajax({
					type : "post",
					url :"/register",
					data:{userName:userName1,password:password1},
					success : function(data) {
						/*if(data==1){
							$("#tips").html("验证码错误");
						}else */
						if(data=="error"){
	                        $("#tips").html("网络等原因导致失败，请重试");
						}else if(data=="success"){
							window.parent.location.href="toIndex";
						}
					}

				});
            }
        }
	</script>

	<body>
		<div class="registerDiv">
			<div class="register-do">
				<form id="registerForm">
					<div class="register-tab">
						<input type="text" name="userName" id="userName" placeholder="用户名" required="">
					</div>
					<div class="register-tab">
						<input type="password" name="password1" id="password1" placeholder="密码" required="">
					</div>
					<div class="register-tab" style="margin-bottom: 0.7em">
						<input type="password" name="password2" id="password2" placeholder="重复密码" required="">
					</div>
                    <label id="tips" style="margin-left: 20%;font-size: small;color: red"></label>
					<div style="border: none;outline: none;height: 50px; width: 95%;background-color: yellowgreen; font-size: 1em;  text-align: center;margin-top: 0.7em;" onclick="register()">
						<font style="color: white; line-height:50px;">
							注册
						</font>
					</div>
				</form>
			</div>
		</div>
	</body>

</html>