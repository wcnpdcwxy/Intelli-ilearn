<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.edu360.ilearn.entity.pathTable" %>
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
		<script src="../../../js/jquery-2.1.4.min.js"></script>
		<!---//End-rate---->
        <!‐‐ 引入Echarts包 ‐‐>
        <script src="../../../js/echarts.min.js"></script>
	</head>

	<body style="background-color: white;">
		<!-- Container (notice the relative width) :  -->
		<div class="container">
			<div id="left" style="width: 15%; height: 760px; background: whitesmoke; margin:auto; float:left;padding-top: 10%">
				<div style="width: 94%; height: 70%; margin-left: 2%;">
					<a onclick="doPnum()">
						<div id="tab1" style="border-bottom: groove;border-bottom-color: #00BFF0;height: 20%;width: 100%;color: limegreen;text-align: center;padding-top: 13%;">活跃留存堆叠图</div>
					</a>
					<a onclick="doBounceRate()">
						<div id="tab2" style="border-bottom: groove;border-bottom-color: #00BFF0;height: 20%;width: 100%;color: limegreen;text-align: center;padding-top: 13%;">弹出率折线图</div>
					</a>
					<a onclick="doPathTable()">
						<div id="tab3" style="border-bottom: groove;border-bottom-color: #00BFF0;height: 20%;width: 100%;color: limegreen;text-align: center;padding-top: 13%;">网页跳转表</div>
					</a>
                    <a>
                        <div id="tab4" style="border-bottom: groove;border-bottom-color: #00BFF0;height: 20%;width: 100%;color: limegreen;text-align: center;padding-top: 13%;">产品方法论</div>
                    </a>
                    <a>
                        <div id="tab5" style="border-bottom: groove;border-bottom-color: #00BFF0;height: 20%;width: 100%;color: limegreen;text-align: center;padding-top: 13%;">六一专题</div>
                    </a>
				</div>
			</div>
            <div id="right" style="width: 85%; height: 760px; float:left">
                <div id="main" style="width: 100%;height: 100%;"></div>
                <iframe id="mainn" style="display: none;height: 100%;width: 100%;z-index: 999;border: none"></iframe>
            </div>
			<%--<div class="clearfix"></div>--%>
		</div>
	</body>
    <script type="text/javascript">
        var myChart
        // 异步加载数据
//
//        var mapKeyValue = [];
        var mapOnlyValue = [];
        var topic = '';
        function doPnum() {
            changecolor('tab1');
            window.document.getElementById('main').style.display="block";
            window.document.getElementById('mainn').style.display="none";
            option = {
                title: {
                    text: topic
                },
                tooltip : {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross',
                        label: {
                            backgroundColor: '#6a7985'
                        }
                    }
                },
                legend: {
                    data:[]
                },
                toolbox: {
                    feature: {
                        saveAsImage: {}
                    }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis : [
                    {
                        type : 'category',
                        boundaryGap : false,
                        data : []
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : []
            };


            // 基于准备好的dom，初始化echarts实例
            myChart = echarts.init(document.getElementById('main'));
            // 为echarts对象加载数据
            myChart.setOption(option);
            $.post("/getPnum","line", function(data) {
                var mapOnlyKey1 = [];
                mapOnlyKey1.length = 0;
//                mapKeyValue.length = 0;
//                mapOnlyValue.length = 0;
                var series = [];
                for ( var i = 0; i < data.length; i++) {
                    mapOnlyKey1.push(data[i].date);
//                mapKeyValue.push({
//                    "value" : data[i].activePnum,
//                    "name" : data[i].date
//                });
                    series.push({
                        name: data[i].date,
                        type:'line',
                        stack: '总量',
                        areaStyle: {normal: {}},
                        data: data[i].ints
                    });
//                mapOnlyValue.push(data[i].ints);
                    topic = '活跃留存堆积图';
                }
                console.log(mapOnlyKey1);
                console.log(series);

                // 填入数据
                myChart.setOption({
                    title: {
                        text: topic
                    },
                    xAxis : [ {
                        data : mapOnlyKey1
                    } ],
                    legend: {
                        data : mapOnlyKey1
                    },
                    series : series

                });
                // 使用刚指定的配置项和数据显示图表。
            }, 'json');
        }
        function doBounceRate() {
            changecolor('tab2');
            window.document.getElementById('main').style.display="block";
            window.document.getElementById('mainn').style.display="none";
            option = {
                title: {
                    text: topic
                },
                xAxis: {
                    type: 'category',
                    data: []
                },
                legend: {
                    data:[]
                },
                yAxis: {
                    type: 'value'
                },
                series: []
            };
            // 基于准备好的dom，初始化echarts实例
            myChart = echarts.init(document.getElementById('main'));
            // 为echarts对象加载数据
            myChart.setOption(option);
            $.post("/getBounceRate","line", function(data) {
                var mapOnlyKey2 = [];
                mapOnlyKey2.length = 0;
//                mapKeyValue.length = 0;
                mapOnlyValue.length = 0;
                var series = [];
                for ( var i = 0; i < data.length; i++) {
                    mapOnlyKey2.push(data[i].date);
//                mapKeyValue.push({
//                    "value" : data[i].activePnum,
//                    "name" : data[i].date
//                });
                    mapOnlyValue.push(data[i].rate);
                    topic = '弹出率折线图';
                }
                series.push({
                    data: mapOnlyValue,
                    type: 'line',
                    smooth: true
                });
                console.log(mapOnlyKey2);
                console.log(series);
                // 填入数据
                myChart.setOption({
                    xAxis : [ {
                        data : mapOnlyKey2
                    } ],
                    legend: {
                        data : mapOnlyKey2
                    },
                    series : series

                });
                // 使用刚指定的配置项和数据显示图表。
            }, 'json');
        }
        function doPathTable() {
//            myChart.dispose();
            window.document.getElementById('main').style.display="none";
            window.document.getElementById('mainn').style.display="block";
            window.document.getElementById('mainn').src="getPathTable";
            changecolor('tab3');
        }
        function changecolor(ch) {
            window.document.getElementById('tab1').style.backgroundColor="whitesmoke";
            window.document.getElementById('tab2').style.backgroundColor="whitesmoke";
            window.document.getElementById('tab3').style.backgroundColor="whitesmoke";
            window.document.getElementById('tab4').style.backgroundColor="whitesmoke";
            window.document.getElementById('tab5').style.backgroundColor="whitesmoke";
            window.document.getElementById('tab5').style.backgroundColor="whitesmoke";
            window.document.getElementById('tab1').style.borderLeft="outset";
            window.document.getElementById('tab2').style.borderLeft="outset";
            window.document.getElementById('tab3').style.borderLeft="outset";
            window.document.getElementById('tab4').style.borderLeft="outset";
            window.document.getElementById('tab5').style.borderLeft="outset";
            window.document.getElementById('tab1').style.borderLeftColor="white";
            window.document.getElementById('tab2').style.borderLeftColor="white";
            window.document.getElementById('tab3').style.borderLeftColor="white";
            window.document.getElementById('tab4').style.borderLeftColor="white";
            window.document.getElementById('tab5').style.borderLeftColor="white";
            window.document.getElementById(ch).style.backgroundColor="white";
            window.document.getElementById(ch).style.borderLeftColor="red";
        }
    </script>
</html>