<%@ page import="com.edu360.ilearn.Vo.PageVo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("ctx", path);
    PageVo favpVo = (PageVo) session.getAttribute("FavpVo");
%>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>个人信息页面</title>

        <!-- Bootstrap core CSS -->
        <link href="../../../css/bootstrap.css" rel="stylesheet">
        <link href="../../../css/font-awesome.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <%--<link href="../../../css/main.css" rel="stylesheet">--%>


        <script src="../../../js/jquery.js"></script>
        <script src="../../../js/bootstrap.min.js"></script>
        <script src="../../../js/demoad.js"></script>
    </head>
    <body>
        <table class="table" border="5">
            <tr>
                <th>课程id</th>
                <th>课程名</th>
                <th>教师</th>
                <th>分类</th>
                <th>评分</th>
            </tr>
            <c:forEach items="${FavpVo.pageList}" var="course" varStatus="status">
                <tr>
                    <th>${course.id}</th>
                    <th>${course.courseName}</th>
                    <th>${course.userNickName}</th>
                    <th>${course.type}</th>
                    <th>${course.mark}</th>
                </tr>
            </c:forEach>
        </table>

        <%--分页--%>
        <center>
            <div style="height: 8%">
                <button class="corner"><a href="javascript:go(<%=favpVo.getNow_page()-1%>)">上一页</a></button>
                <%
                    int se[] = favpVo.getStart_end();
                    if (se[0] > 1) {
                        out.print(" <button class='corner'>...</button>");
                    }
                    for (int pi = se[0]; pi <= se[1]; pi++) {
                        if (pi == favpVo.getNow_page()) {
                            out.print("　<button class='corner active'><a href='javascript:;'>" + pi + "</a></button>");
                        } else {
                            out.print("　<button class='corner'><a href='javascript:go(" + pi + ")'>" + pi + "</a></button>");
                        }
                    }
                    if (favpVo.getTotal_page_num() > se[1]) {
                        out.print("  <button class='corner'>...</button> ");
                    }
                %>　
                <button class="corner"><a href="javascript:go(<%=favpVo.getNow_page()+1%>)">下一页</a></button>
            </div>
        </center>
        <script type="text/javascript">
            function go(pageNum) {
                if (pageNum < 1) {
                    alert("已到首页");
                    return;
                }
                if (pageNum ><%=favpVo.getTotal_page_num()%>) {
                    alert("已到尾页");
                    return;
                }
                if (pageNum ==<%=favpVo.getNow_page()%>) {
                    return;
                }
                var url = "/toFavinfo?pageNum=" + pageNum;
                location.href = url;
            }
        </script>
    </body>
</html>
