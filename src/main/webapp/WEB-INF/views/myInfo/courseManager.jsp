<%@ page import="com.edu360.ilearn.Vo.PageVo" %>
<%@ page import="javax.swing.text.Document" %>
<%@ page import="java.awt.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("ctx", path);
    PageVo coursepVo = (PageVo) session.getAttribute("CoursepVo");
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
        <th>课程名</th>
        <th>分类</th>
        <th>适用人群介绍</th>
        <th>课程内容介绍</th>
        <th>联系方式介绍</th>
        <th>评分</th>
        <th>花费积分</th>
        <th>创建日期</th>
        <th>状态</th>
        <th>操作1</th>
        <th>操作2</th>
        <th><a href="javascript:;" onclick="toInsert()">添加</a></th>
    </tr>
    <c:forEach items="${CoursepVo.pageList}" var="course" varStatus="status">
        <tr>
            <th>${course.courseName}</th>
            <th>${course.type}</th>
            <th>${course.intro1}</th>
            <th>${course.intro2}</th>
            <th>${course.intro3}</th>
            <th>${course.mark}</th>
            <th>${course.cost}</th>
            <th>${course.time}</th>
            <c:if test="${course.status==0}">
                <td>
                    正常
                </td>
                <td>
                    <a href="lockCourse?courseId=${course.id}">停课</a>
                </td>
            </c:if>
            <c:if test="${course.status!=0}">
                <td>
                    停课
                </td>
                <td>
                    <a href="unlockCourse?courseId=${course.id}">恢复</a>
                </td>
            </c:if>
            <th><a href="javascript:;" onclick="toUpdate(${status.count})">修改</a></th>
            <th><a href="toContentManager?courseId=${course.id}">详情</a></th>
        </tr>
    </c:forEach>
</table>

<%--分页--%>
<center>
    <div style="height: 8%">
        <button class="corner"><a href="javascript:go(<%=coursepVo.getNow_page()-1%>)">上一页</a></button>
        <%
            int se[] = coursepVo.getStart_end();
            if (se[0] > 1) {
                out.print(" <button class='corner'>...</button>");
            }
            for (int pi = se[0]; pi <= se[1]; pi++) {
                if (pi == coursepVo.getNow_page()) {
                    out.print("　<button class='corner active'><a href='javascript:;'>" + pi + "</a></button>");
                } else {
                    out.print("　<button class='corner'><a href='javascript:go(" + pi + ")'>" + pi + "</a></button>");
                }
            }
            if (coursepVo.getTotal_page_num() > se[1]) {
                out.print("  <button class='corner'>...</button> ");
            }
        %>　
        <button class="corner"><a href="javascript:go(<%=coursepVo.getNow_page()+1%>)">下一页</a></button>
    </div>
</center>
<script type="text/javascript">
    function go(pageNum) {
        if (pageNum < 1) {
            alert("已到首页");
            return;
        }
        if (pageNum ><%=coursepVo.getTotal_page_num()%>) {
            alert("已到尾页");
            return;
        }
        if (pageNum ==<%=coursepVo.getNow_page()%>) {
            return;
        }
        var url = "/toCourseManager?pageNum=" + pageNum;
        location.href = url;
    }
</script>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <%--<h4 class="modal-title" id="myModalLabel">更新添加</h4>--%>
            </div>
            <div class="modal-body">
                <form name="IUAction" id="IUAction" action="/insertCourse" method="get">
                    <div style="padding-left: 110px;">
                        <table>
                            <input type="text" name="id" id="id" value="" hidden>
                            课程名:<br/><input type="text" id="courseName" name="courseName" style="width: 60%"><br/>
                            分类:<br/><input type="text" id="type" name="type"><br/>
                            适用人群介绍:<br/><textarea id="intro1" name="intro1" cols="45" rows="3"></textarea><br/>
                            课程内容介绍:<br/><textarea id="intro2" name="intro2" cols="45" rows="8"></textarea><br/>
                            联系方式介绍:<br/><textarea id="intro3" name="intro3" cols="45" rows="3"></textarea><br/>
                            花费积分:<br/><input type="text" id="cost" name="cost"><br/>
                        </table>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick = 'javascript:if(confirm("是否要添加数据?")){window.document.getElementsByName("IUAction")[0].submit()}'>提交</button>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    function toUpdate(count) {
        $.ajax({
            type : "post",
            url :"/toUpdate",
            data:{count:count},
            success : function(data) {
                if(data!=null){
                    document.getElementById("id").value=data.id;
                    document.getElementById("courseName").value=data.courseName;
                    document.getElementById("type").value=data.type;
                    document.getElementById("intro1").value=data.intro1;
                    document.getElementById("intro2").value=data.intro2;
                    document.getElementById("intro3").value=data.intro3;
                    document.getElementById("cost").value=data.cost;
                    document.getElementById("IUAction").action="/updateCourse";
                    $('#myModal').modal('show');
                }
                console.log(data)
            }
        })
    }
    function toInsert() {
        document.getElementById("id").value=null;
        document.getElementById("courseName").value="";
        document.getElementById("type").value="";
        document.getElementById("intro1").value="";
        document.getElementById("intro2").value="";
        document.getElementById("intro3").value="";
        document.getElementById("cost").value="";
        document.getElementById("IUAction").action="/insertCourse"
        $('#myModal').modal('show');
    }
</script>
</html>
