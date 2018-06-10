<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("ctx", path);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>首页</title>

        <script src="../../../js/jquery.min.js"></script>
        <script src="../../../js/ui/jquery-ui.js"></script>
        <link rel="stylesheet" href="../../../css/ui/jquery-ui.css">
        <link rel="stylesheet" href="../../../css/ui/style.css">
        <%--<script type="text/javascript" src="http://jqueryui.com/latest/ui/ui.core.js"></script>--%>
        <%--<script type="text/javascript" src="http://jqueryui.com/latest/ui/ui.dialog.js"></script>--%>
        <%--<link type="text/css" href="http://jqueryui.com/latest/themes/base/ui.all.css" rel="stylesheet" />--%>

        <script type="text/javascript">
            jQuery(function() {
                $('#loginDiv').hide();
                $('#selector1').click(function() {
                    document.getElementById("page_room").style.display="";
                    document.getElementById("page_room2").style.display="none";
                    document.getElementById("selector1").style.borderBottomColor="green";
                    document.getElementById("selector2").style.borderBottomColor="white";
                    document.getElementById("login_page").style.color="green";
                    document.getElementById("register_page").style.color="black";
                });
                $('#selector2').click(function() {
                    document.getElementById("page_room").style.display="none";
                    document.getElementById("page_room2").style.display="";
                    document.getElementById("selector1").style.borderBottomColor="white";
                    document.getElementById("selector2").style.borderBottomColor="green";
                    document.getElementById("login_page").style.color="black";
                    document.getElementById("register_page").style.color="green";
                });
            });
            function abc() {
                $('#loginDiv').dialog({
                    width: 516,
                    height: 397,
                    position: { using:function(pos){
                        console.log(pos)
                        var topOffset = $(this).css(pos).offset().top;
                        if (topOffset = 0||topOffset>0) {
                            $(this).css('top', 110);
                        }
                    }},
                    modal: true,
                    resizable: false,
                    close: function(e, u) {
    //					$('#loginDiv').empty();
                        $(this).dialog("destroy");
                    }
                });
            }
        </script>

        <style>
            #loginDiv {
                width: 516px;
                height: 397px;
                z-index: 99999;
            }
        </style>

    </head>



    <body>
        <div id='loginDiv'>
            <div id="selector" style="width: 100%; height: 20%;">
                <div id="selector1" style="width: 50%; height: 100%; float: left; border-bottom-style: double; border-bottom-color: green;">
                    <a id="login_page" style="color: green;line-height:50px">
                        <center>
                            登陆
                        </center>
                    </a>
                </div>
                <div id="selector2" style="width: 50%; height: 100%; float: left; border-bottom-style: double; border-bottom-color: white;">
                    <a id="register_page" style="line-height:50px">
                        <center>
                            注册
                        </center>
                    </a>
                </div>
                <div class="clearfix"></div>
            </div>
            <div id="page_room" style="width: 100%; height: 80%;">
                <iframe src='toLogin' style="border: 0; width: 100%; height: 100%;" scrolling="no"></iframe>
            </div>
            <div id="page_room2" style="width: 100%; height: 80%;display: none">
                <iframe src='toRegister' style="border: 0; width: 100%; height: 100%;" scrolling="no"></iframe>
            </div>
        </div>


        <!--导航-->
        <iframe allowtransparency=true id="top" name="top" src="toTop" width="100%" height="100px" scrolling="no" frameborder="0"></iframe>
        <!--首页-->
        <iframe allowtransparency=true id="showPage" name="home" src="toHome" width="100%" height="800px" scrolling="no" frameborder="0"></iframe>
        <%--底部--%>
        <iframe allowtransparency=true id="bottom" src="toBottom" width="100%" scrolling="no" height="320px" frameborder="0"></iframe>


    </body>
</html>