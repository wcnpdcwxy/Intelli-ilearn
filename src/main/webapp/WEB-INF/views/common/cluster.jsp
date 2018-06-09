<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.edu360.ilearn.Vo.PageVo" %>
<!--课程搜索页面-->
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("ctx", path);
    PageVo clusterpVo = (PageVo) session.getAttribute("ClusterpVo");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>table</title>
        <link href="../../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        
        <meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="../../js/jquery.min.js"></script>
    </head>
    <body style="background-color: white">
    	<div class="container" style="height: 600px;">
            <div style="height:100%; width: 100%;margin-top: 30px">
                <table class="table" border="5">
                    <tr>
                        <th>分类</th>
                        <th>用户id</th>
                        <th>收藏数</th>
                        <th>订单数</th>
                        <th>历史学习数</th>
                    </tr>
                    <c:forEach items="${ClusterpVo.pageList}" var="string" varStatus="status">
                        <tr>
                            <c:if test='${string.split(",")[0].split(":")[0]==1}'>
                                <td>
                                    忠实的学习者(f^o^h^)
                                </td>
                            </c:if>
                            <c:if test='${string.split(",")[0].split(":")[0]==2}'>
                                <td>
                                    心动没有行动的浪人(f^o.h.)
                                </td>
                            </c:if>
                            <c:if test='${string.split(",")[0].split(":")[0]==3}'>
                                <td>
                                    缺乏耐心的学习者(f^o^h.)
                                </td>
                            </c:if>
                            <c:if test='${string.split(",")[0].split(":")[0]==4}'>
                                <td>
                                    有规划的自学者(f.o^h^)
                                </td>
                            </c:if>
                            <th>${string.split(",")[0].split(":")[1]}</th>
                            <th>${string.split(",")[1]}</th>
                            <th>${string.split(",")[2]}</th>
                            <th>${string.split(",")[3]}</th>
                        </tr>
                    </c:forEach>
                </table>

				<%--分页--%>
                <center>
                    <div style="height: 8%">
                        <button class="corner"><a href="javascript:go(<%=clusterpVo.getNow_page()-1%>)">上一页</a></button>
                        <%
                            int se[] = clusterpVo.getStart_end();
                            if(se[0]>1){
                                out.print(" <button class='corner'>...</button>");
                            }
                            for(int pi=se[0];pi<=se[1];pi++){
                                if(pi==clusterpVo.getNow_page()){
                                    out.print("　<button class='corner active'><a href='javascript:;'>"+pi+"</a></button>");
                                }else{
                                    out.print("　<button class='corner'><a href='javascript:go("+pi+")'>"+pi+"</a></button>");
                                }
                            }
                            if(clusterpVo.getTotal_page_num()>se[1]){
                                out.print("  <button class='corner'>...</button> ");
                            }
                        %>　
                        <button class="corner"><a href="javascript:go(<%=clusterpVo.getNow_page()+1%>)">下一页</a></button>
                    </div>
                </center>
                <script type="text/javascript">
                    function go(pageNum){
                        if(pageNum<1){
                            alert("已到首页");
                            return;
                        }
                        if(pageNum><%=clusterpVo.getTotal_page_num()%>){
                            alert("已到尾页");
                            return;
                        }
                        if(pageNum==<%=clusterpVo.getNow_page()%>){
                            return;
                        }
                        var url = "/toCluster?pageNum="+pageNum;
                        location.href = url;
                    }
                </script>
    		</div>
    	</div>
 	</body>
</html>