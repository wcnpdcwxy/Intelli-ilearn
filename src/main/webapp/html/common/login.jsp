<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
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

	<body>
		<div class="loginDiv">
			<div class="login-do">
				<div class="login-tab">
					<input type="text" name="username" id="username" placeholder="用户名" required="">
				</div>
				<div class="login-tab">
					<input type="password" name="password" id="password" placeholder="密码" required="">
				</div>
				<div class="log_btn" style="border: none;outline: none;height: 50px; width: 95%;background-color: yellowgreen; font-size: 1em;  text-align: center;">
					<font style="color: white; line-height:50px;">
						登陆
					</font>
				</div>
				<div class="pwd_tab" style="font-size: 0.7em; margin-top: 15px;margin-left: 390px;">
					<a id="change_pwd" href="#">
						忘记密码
					</a>
				</div>
			</div>
		</div>
	</body>

</html>