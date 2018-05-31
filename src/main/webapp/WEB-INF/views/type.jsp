<!--分类展示页面-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.edu360.ilearn.Vo.PageVo" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("ctx", path);
	PageVo pVo = (PageVo) session.getAttribute("pVo");
	String type = (String) session.getAttribute("type");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>分类展示页面</title>
		<link href="../../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
		<link href="../../css/jquery.raty.css" rel="stylesheet" type="text/css" media="all" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="../../js/jquery.min.js"></script>
		<script src="../../js/jquery.raty.js"></script>
    </head>
	<style>
		.corner{
			width:40px;
			height: 40px;
			font-size: 15px;
			background-color: white;
			border-color: ghostwhite;
		}
		.active{
			background-color: dodgerblue;
		}
		.corner a{
			color: mediumblue;
		}
		.active a{
			color: white;
		}
	</style>
    <script>
//  异步请求方法1 抓取固定参数（类别，时间等） 保存（request）一个list数据 包含一组实体类对象
    
    </script>
	<body style="background-color: antiquewhite">
		<div class="container" style="height: 1000px;background-color: whitesmoke;">
    		<!--搜索参数设置-->
    		<div style="border-bottom: groove;border-color: blue">
	    		<!--分类-->
	    		<div style="background-color: #E0E0E0">
					<ul class="nav nav-pills" style="margin-left: 20px">
						<li role="presentation"><a href="doType?type=计算机">计算机</a></li>
						<li role="presentation"><a href="doType?type=经济管理">经济管理</a></li>
						<li role="presentation"><a href="doType?type=心理学">心理学</a></li>
						<li role="presentation"><a href="doType?type=外语">外语</a></li>
						<li role="presentation"><a href="doType?type=文学历史">文学历史</a></li>
						<li role="presentation"><a href="doType?type=艺术设计">艺术设计</a></li>
					</ul>
	    		</div>
	    		<div style="margin-right: 20px;padding-left:83%;margin-top: 8px;">
	    			时间：
	    			<!--异步请求1 request存储参数2-->
	    			<a href="doFilter?filter=3">
	    				<font>
	    					3日内
	    				</font>
	    			</a>
	    			<!--异步请求1 request存储参数2-->
                    <a href="doFilter?filter=7">
	    				<font>
	    					1周内
	    				</font>
	    			</a>
	    			<!--异步请求1 request存储参数2-->
                    <a href="doFilter?filter=30">
	    				<font>
	    					1月内
	    				</font>
	    			</a>
	    			<!--异步请求1 request存储参数2-->
                    <a href="doFilter?filter=365">
	    				<font>
	    					1年内
	    				</font>
	    			</a>
	    		</div>
    		</div>
    		<!--分类结果显示-->
			<div style="height: 93%">
				<div style="height: 400px;padding-top: 15px;height: 92%">
					<!--循环提取list中的实体类并在div中显示-->
					<c:forEach items="${pVo.pageList}" var="course" varStatus="status">
						<a href="detail?courseId=${course.id}">
							<div style="width: 16%;height: 271px;margin-top: 15px;margin-left: 2%;margin-right: 2%;background-color: white;float: left;">
								<div style="width: 100%;height: 40%">
									<img src="${course.picAddr}" height="" width="100%"/>
								</div>
								<div style="width: 100%;height: 60%; padding: 10px;">
									<div style="width: 100%;height: 40%;margin-top: 8px">
										<h5>${course.courseName}</h5>
										<h6>${course.userNickName}</h6>
									</div>
									<div style="width: 100%;height: 60%;padding-top: 5px">
											<%--展示显示分数，无打分功能--%>
										<div style="padding-bottom: 1px">
											<div id="star" data-score="${course.mark}"></div>
										</div>
											<%--积分购买制度没有实行，暂无内容--%>
										<div>
                                            <c:if test="${course.cost==0}">
                                                <h5>免费</h5>
                                            </c:if>
                                            <c:if test="${course.cost!=0}">
                                                <h5>¥ ${course.cost}</h5>
                                            </c:if>
										</div>
									</div>

								</div>
							</div>
						</a>
					</c:forEach>
				</div>
				<%--分页--%>
				<center>
					<div style="height: 8%">
						<button class="corner"><a href="javascript:go(<%=pVo.getNow_page()-1%>)"><---</a></button>
						<%
							int se[] = pVo.getStart_end();
							if(se[0]>1){
								out.print(" <button class='corner'>...</button>");
							}
							for(int pi=se[0];pi<=se[1];pi++){
								if(pi==pVo.getNow_page()){
									out.print("　<button class='corner active'><a href='javascript:;'>"+pi+"</a></button>");
								}else{
									out.print("　<button class='corner'><a href='javascript:go("+pi+")'>"+pi+"</a></button>");
								}
							}
							if(pVo.getTotal_page_num()>se[1]){
								out.print("  <button class='corner'>...</button> ");
							}
						%>　
						<button class="corner"><a href="javascript:go(<%=pVo.getNow_page()+1%>)">---></a></button>
					</div>
				</center>
				<script type="text/javascript">
                    function go(pageNum){
                        if(pageNum<1){
                            alert("已到首页");
                            return;
                        }
                        if(pageNum><%=pVo.getTotal_page_num()%>){
                            alert("已到尾页");
                            return;
                        }
                        if(pageNum==<%=pVo.getNow_page()%>){
                            return;
                        }
                        var url = "/toType?pageNum="+pageNum;
                        location.href = url;
                    }
				</script>
			</div>
		</div>
	</body>
	<script>
        $('#star').raty({
            number: 5,
            readOnly: true,
            half: true,
        });
	</script>
</html>