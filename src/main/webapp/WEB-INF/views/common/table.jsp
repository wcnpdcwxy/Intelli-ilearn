<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.edu360.ilearn.Vo.PageVo" %>
<!--课程搜索页面-->
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("ctx", path);
    PageVo pVo = (PageVo) session.getAttribute("pVo");
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
                        <th>ip地址</th>
                        <th>用户id</th>
                        <th>用户名</th>
                        <th>起始时间</th>
                        <th>起始网址</th>
                        <th>最长时间</th>
                        <th>最长时间网址</th>
                        <th>终止时间</th>
                        <th>终止网址</th>
                        <th>跳转数</th>
                        <th>平均时间</th>
                    </tr>
                    <c:forEach items="${pVo.pageList}" var="pathtable" varStatus="status">
                        <tr>
                            <th>${pathtable.ip}</th>
                            <th>${pathtable.userId}</th>
                            <th>${pathtable.userName}</th>
                            <th>${pathtable.earlyTime}</th>
                            <th>${pathtable.earlyPath}</th>
                            <th>${pathtable.getLongTime()}</th>
                            <th>${pathtable.longTimePath}</th>
                            <th>${pathtable.lastTime}</th>
                            <th>${pathtable.lastPath}</th>
                            <th>${pathtable.pathCount}</th>
                            <th>${pathtable.getAvgTime()}</th>
                        </tr>
                    </c:forEach>
                </table>

				<%--分页--%>
                <center>
                    <div style="height: 8%">
                        <button class="corner"><a href="javascript:go(<%=pVo.getNow_page()-1%>)">上一页</a></button>
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
                        <button class="corner"><a href="javascript:go(<%=pVo.getNow_page()+1%>)">下一页</a></button>
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
                        var url = "/toTable?pageNum="+pageNum;
                        location.href = url;
                    }
                </script>
    		</div>
    	</div>
 	</body>
</html>