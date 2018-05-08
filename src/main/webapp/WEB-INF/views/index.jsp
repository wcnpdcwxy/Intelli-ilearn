<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("ctx", path);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>首页</title>
    <link href="../../css/index.css" rel="stylesheet" type="text/css" />
    <%--<script type="text/javascript">
        $(function () {
            $('.demo11').Tabs({
                event: 'mouseover'
            });
        });
        function dyniframesize(body) {
            var ifm= document.getElementById("body");

            var subWeb = document.frames ? document.frames["body"].document :

                ifm.contentDocument;

            if(ifm != null && subWeb != null) {

                ifm.height = subWeb.body.scrollHeight;

            }
        }


    </script>--%>
</head>

<body id="cont">
<iframe allowtransparency=true id="top"  src="toTop" width="100%" height="46px" scrolling="no" frameborder="0"></iframe>
<!--导航-->
<iframe allowtransparency=true  id="navigation"  src="toNavigation" width="100%" height="95px" scrolling="no" frameborder="0"></iframe>
<iframe allowtransparency=true id="body"  src="toDynmsn" width="100%"  frameborder="0" scrolling="auto" name="body"></iframe>

</body>
</html>