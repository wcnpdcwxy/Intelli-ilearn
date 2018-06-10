<%@ page import="com.edu360.ilearn.Vo.PageVo" %>
<%@ page import="javax.swing.text.Document" %>
<%@ page import="java.awt.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("ctx", path);
    PageVo contentpVo = (PageVo) session.getAttribute("ContentpVo");
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
        <th>标题</th>
        <th>时长</th>
        <th>视频路径</th>
        <th>状态</th>
        <th>操作</th>
        <th><a href="javascript:;" onclick="toInsert()">添加</a></th>
    </tr>
    <c:forEach items="${ContentpVo.pageList}" var="content" varStatus="status">
        <tr>
            <th>${content.title}</th>
            <th>${content.duration}</th>
            <th>${content.vdAddr}</th>
            <c:if test="${content.state==0}">
                <td>
                    正常
                </td>
                <td>
                    <a href="lockContent?contentId=${content.id}">停课</a>
                </td>
            </c:if>
            <c:if test="${content.state!=0}">
                <td>
                    停课
                </td>
                <td>
                    <a href="lockContent?contentId=${content.id}">恢复</a>
                </td>
            </c:if>
            <th><a href="javascript:;" onclick="toUpdate(${status.count})">修改</a></th>
        </tr>
    </c:forEach>
</table>

<%--分页--%>
<center>
    <div style="height: 8%">
        <button class="corner"><a href="toCourseManager">返回课程</a></button>
        <button class="corner"><a href="javascript:go(<%=contentpVo.getNow_page()-1%>)">上一页</a></button>
        <%
            int se[] = contentpVo.getStart_end();
            if (se[0] > 1) {
                out.print(" <button class='corner'>...</button>");
            }
            for (int pi = se[0]; pi <= se[1]; pi++) {
                if (pi == contentpVo.getNow_page()) {
                    out.print("　<button class='corner active'><a href='javascript:;'>" + pi + "</a></button>");
                } else {
                    out.print("　<button class='corner'><a href='javascript:go(" + pi + ")'>" + pi + "</a></button>");
                }
            }
            if (contentpVo.getTotal_page_num() > se[1]) {
                out.print("  <button class='corner'>...</button> ");
            }
        %>　
        <button class="corner"><a href="javascript:go(<%=contentpVo.getNow_page()+1%>)">下一页</a></button>
    </div>
</center>
<script type="text/javascript">
    function go(pageNum) {
        if (pageNum < 1) {
            alert("已到首页");
            return;
        }
        if (pageNum ><%=contentpVo.getTotal_page_num()%>) {
            alert("已到尾页");
            return;
        }
        if (pageNum ==<%=contentpVo.getNow_page()%>) {
            return;
        }
        var url = "/toContentManager?pageNum=" + pageNum;
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
                <form name="IUAction" id="IUAction" action="/insertContent" method="post" enctype="multipart/form-data" >
                    <div style="padding-left: 110px;">
                        <table>
                            <input type="text" name="courseId" id="courseId" value="${InsCourseId}" hidden>
                            <input type="text" name="id" id="id" value="" hidden>
                            <input type="text" name="vdAddr" id="vdAddr" value="" hidden>
                            标题:<br/><input type="text" id="title" name="title" style="width: 60%"><br/>
                            时长:<br/><input type="text" id="duration" name="duration"><br/>
                            视频路径:<br/><input type="file" name="file" id="button" value="选择上传" />
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
            url :"/toUpdate2",
            data:{count:count},
            success : function(data) {
                if(data!=null){
                    document.getElementById("title").value=data.title;
                    document.getElementById("duration").value=data.duration;
                    document.getElementById("id").value=data.id;
                    document.getElementById("vdAddr").value=data.vdAddr;

                    document.getElementById("IUAction").action="/updateContent";
                    $('#myModal').modal('show');
                }
                console.log(data)
            }
        })
    }
    function toInsert() {
        document.getElementById("title").value="";
        document.getElementById("duration").value="";
        document.getElementById("id").value=null;

        document.getElementById("IUAction").action="/insertContent"
        $('#myModal').modal('show');
    }
</script>
</html>
