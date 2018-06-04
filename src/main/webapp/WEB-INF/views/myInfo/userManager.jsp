<%@ page import="com.edu360.ilearn.Vo.PageVo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("ctx", path);
    PageVo userpVo = (PageVo) session.getAttribute("UserpVo");
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
        <th>用户名</th>
        <th>昵称</th>
        <th>电话号</th>
        <th>积分</th>
        <th>创建日期</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${UserpVo.pageList}" var="user" varStatus="status">
        <tr>
            <th>${user.userName}</th>
            <th>${user.nickName}</th>
            <th>${user.phoneNum}</th>
            <th>${user.points}</th>
            <th>${user.oriDate}</th>
            <c:if test="${user.status!=3}">
                <td>
                    正常
                </td>
                <td>
                    <a href="lockUser?userId=${user.id}">封号</a>
                </td>
            </c:if>
            <c:if test="${user.status==3}">
                <td>
                    停用
                </td>
                <td>
                    <a href="unlockUser?userId=${user.id}">解封</a>
                </td>
            </c:if>
        </tr>
    </c:forEach>
</table>

<%--分页--%>
<center>
    <div style="height: 8%">
        <button class="corner"><a href="javascript:go(<%=userpVo.getNow_page()-1%>)">上一页</a></button>
        <%
            int se[] = userpVo.getStart_end();
            if (se[0] > 1) {
                out.print(" <button class='corner'>...</button>");
            }
            for (int pi = se[0]; pi <= se[1]; pi++) {
                if (pi == userpVo.getNow_page()) {
                    out.print("　<button class='corner active'><a href='javascript:;'>" + pi + "</a></button>");
                } else {
                    out.print("　<button class='corner'><a href='javascript:go(" + pi + ")'>" + pi + "</a></button>");
                }
            }
            if (userpVo.getTotal_page_num() > se[1]) {
                out.print("  <button class='corner'>...</button> ");
            }
        %>　
        <button class="corner"><a href="javascript:go(<%=userpVo.getNow_page()+1%>)">下一页</a></button>
    </div>
</center>
<script type="text/javascript">
    function go(pageNum) {
        if (pageNum < 1) {
            alert("已到首页");
            return;
        }
        if (pageNum ><%=userpVo.getTotal_page_num()%>) {
            alert("已到尾页");
            return;
        }
        if (pageNum ==<%=userpVo.getNow_page()%>) {
            return;
        }
        var url = "/toUserManager?pageNum=" + pageNum;
        location.href = url;
    }
</script>
</body>
</html>
