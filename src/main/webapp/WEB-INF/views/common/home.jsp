<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("ctx", path);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<html>

	<head>
		<title>Home</title>
		<link href="../../../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
		<!-- Custom Theme files -->
		<!--theme-style-->
		<link href="../../../css/style.css" rel="stylesheet" type="text/css" media="all" />
		<!--//theme-style-->
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<!--theme-style-->
		<link href="../../../css/style4.css" rel="stylesheet" type="text/css" media="all" />
		<!--//theme-style-->
		<script src="../../../js/jquery.min.js"></script>
		<!---//End-rate---->
		<!--light-box-files -->
		<script src="../../../js/jquery.chocolat.js"></script>
		<link rel="stylesheet" href="../../../css/chocolat.css" type="text/css" media="screen" charset="utf-8">
		<!--light-box-files -->
	</head>

	<body style="background-color: antiquewhite;">
		<!-- Container (notice the relative width) :  -->
		<div class="container">
			<div id="left" style="width: 5%; height: 380px; background-color: snow; margin:auto; float:left;">
				<a>
					<img id="left_img" src="../../../images/left.png" style="position:relative;top:50%;left:50%;margin-top:-17px;margin-left:-17px;" />
				</a>
			</div>
			<div id="container1" style="width: 90%; height: 380px; background: #E0E0E0; margin:auto; float:left;"></div>
			<div id="right" style="width: 5%;  height: 380px; background: snow; margin:auto; float:left;">
				<a>
					<img id="right_img" src="../../../images/right.png" style="position:relative;top:50%;left:50%;margin-top:-17px;margin-left:-17px;" />
				</a>
			</div>
			<div id="container2" style="width: 100%; height: 50px; background: #E0E0E0; margin:auto; float:left">
				<div id="examplee" align="middle">
					<a>
						<div id="img1" style="background-color:lightskyblue; height: 50px;width: 20%; float:left;">音乐特辑</div>
					</a>
					<a>
						<div id="img2" style="background-color:pink; height: 50px;width: 20%; float:left;">5月好课精选</div>
					</a>
					<a>
						<div id="img3" style="background-color:pink; height: 50px;width: 20%; float:left;">学摄影，就现在</div>
					</a>
                    <a>
                        <div id="img4" style="background-color:pink; height: 50px;width: 20%; float:left;">产品方法论</div>
                    </a>
                    <a>
                        <div id="img5" style="background-color:pink; height: 50px;width: 20%; float:left;">六一专题</div>
                    </a>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
		<script>
			$(document).ready(function() {
				var max = 2;

				function move_one(index) {
					$('#examplee div').each(function(i) {
						$(this).css('background-color', 'pink');
					})
					$('#img' + (index + 1) + '').css('background-color', 'lightskyblue')
				}

				function rush_one(index) {
					instance.api().destroy();
					instance.api().open(index);

					move_one(index);
				}
				var index = 0;
				var instance = $('#container2').Chocolat({
					loop: true,
					images: [{
							src: '../../images/ch.jpg',
						},
						{
							src: '../../images/ch1.png',
						},
						{
							src: '../../images/ch2.png',
						},
                        {
                            src: '../../images/ch3.png',
                        },
                        {
                            src: '../../images/ch4.png',
                        },
					],
					imageSize: 'cover',
					container: '#container1',
				}).data('chocolat');
				instance.api().open(0)
				$('#img1').on('click', function(e) {
					index = 0;
					rush_one(index)
				})
				$('#img2').on('click', function(e) {
					index = 1;
					rush_one(index)
				})
				$('#img3').on('click', function(e) {
					index = 2;
					rush_one(index)
				})
                $('#img4').on('click', function(e) {
                    index = 3;
                    rush_one(index)
                })
                $('#img5').on('click', function(e) {
                    index = 4;
                    rush_one(index)
                })
				$('#right_img').on('click', function(e) {
					var def = instance.api().next()

					if(index == max) {
						index = 0;
					} else if(index < max) {
						index++;
					}

					move_one(index);
				})

				$('#left_img').on('click', function(e) {
					var def = instance.api().prev()

					if(index == 0) {
						index = max;
					} else if(index > 0) {
						index--;
					}

					move_one(index);
				})
			});
		</script>
	</body>

</html>