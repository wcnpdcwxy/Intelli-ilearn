<!DOCTYPE html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<title>个人信息页面</title>

		<!-- Bootstrap core CSS -->
		<link href="../../../css/bootstrap.css" rel="stylesheet">
		<link href="../../../css/font-awesome.min.css" rel="stylesheet">

		<!-- Custom styles for this template -->
		<link href="../../../css/main.css" rel="stylesheet">
	</head>

	<body>

		<div class="container">
			<div class="col-lg-10 col-lg-offset-1">

				<!-- ===== vCard Navigation ===== -->
				<div class="row w">
					<div class="col-md-4">
						<img class="img-responsive" src="../../../images/avatar.jpg" alt="">
						<ul class="nav nav-tabs nav-stacked" id="myTab">
							<li class="active">
								<a href="#about">个人信息</a>
							</li>
							<li>
								<a href="#profile">我的收藏</a>
							</li>
							<li>
								<a href="#portfolio">学习记录</a>
							</li>
						</ul>
					</div>
					<!-- col-md-4 -->

					<!-- ===== vCard Content ===== -->
					<div class="col-md-8">
						<div class="tab-content">

							<!-- ===== First Tab ===== -->
							<div class="tab-pane active" id="about">
								<form>
									<div class="form-group" style="margin-top: 15px;">
										<label for="exampleInputEmail1">用户名</label>
										<input type="email" class="form-control" id="exampleInputEmail1" placeholder="${userName}" disabled>
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">密码</label>
										<input type="password" class="form-control" id="exampleInputPassword1" placeholder="*******" readonly>
									</div>
									<div class="form-group">
										<label for="exampleInputPassword2">昵称</label>
										<input type="password" class="form-control" id="exampleInputPassword2" placeholder="${nickName}">
									</div>
									<div class="form-group">
										<label for="exampleInputPassword3">电话</label>
										<input type="password" class="form-control" id="exampleInputPassword3" placeholder="${phoneNum}">
									</div>
									<div class="form-group">
										<label for="exampleInputPassword4">积分</label>
										<input type="password" class="form-control" id="exampleInputPassword4" placeholder="${points}">
									</div>
									<!--记住密码-->
									<!--<div class="checkbox">
										<label>
								      <input type="checkbox">记住密码
								    </label>
									</div>-->
									<button type="submit" class="btn btn-default" style="width: 28%;margin-left: 36%;margin-top: 2%;height: 50px;"><h4>修改信息</h4></button>
									<a href="" style="color: red;float: right;margin-right: 20px;">修改密码</a>
								</form>
							</div>
							<!-- tab about -->

							<!-- ===== Second Tab ===== -->
							<div class="tab-pane centered" id="profile">

							</div>
							<!-- Tab Profile -->

							<!-- ===== Third Tab ===== -->
							<div class="tab-pane" id="portfolio">
								<div class="row">
									<div class="col-xs-6 centered">
										<img class="img-responsive" src="assets/img/p01.png" alt="">
										<a href="#">
											<h6><i class="icon-link"></i> Project Name</h6></a>
									</div>
									<!-- col-xs-6 -->
									<div class="col-xs-6 centered">
										<img class="img-responsive" src="assets/img/p02.png" alt="">
										<a href="#">
											<h6><i class="icon-link"></i> Project Name</h6></a>
									</div>
									<!-- col-xs-6 -->
								</div>
								<!-- row -->

								<div class="row">
									<br>
									<div class="col-xs-6 centered">
										<img class="img-responsive" src="assets/img/p03.png" alt="">
										<a href="#">
											<h6><i class="icon-link"></i> Project Name</h6></a>
									</div>
									<!-- col-xs-6 -->
									<div class="col-xs-6 centered">
										<img class="img-responsive" src="assets/img/p04.png" alt="">
										<a href="#">
											<h6><i class="icon-link"></i> Project Name</h6></a>
									</div>
									<!-- col-xs-6 -->
								</div>
								<!-- row -->
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

		<script src="../../../js/jquery.js"></script>
		<script src="../../../js/bootstrap.min.js"></script>
		<script src="../../../js/demoad.js"></script>
		<script>
			$('#myTab a').click(function(e) {
				e.preventDefault()
				$(this).tab('show')
			})
		</script>

	</body>

</html>