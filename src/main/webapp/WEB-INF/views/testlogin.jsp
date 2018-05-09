<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%
    request.setAttribute("ctx", request.getContextPath());

%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>修配连汽配市场</title>
    <%--<link href="${ctx}/css/index.css" rel="stylesheet" type="text/css" />--%>
    <!--弹出页-->
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script  type="text/javascript" src="../../js/layer/layer.min.js"></script>
    <script type="text/javascript">
        function mygs() {
            var url = "${ctx}/login/toGetPassword.shtml";
            $.layer({
                type: 2,
                title: false,//关闭按钮
                shadeClose: false,
                shade: [0.6, '#000'],//遮罩
                border: [0, 0, '#ccc'],//边框
                area: ['650px', '450px'],//宽高
                iframe: { src: '' + url + '' },
                shift: [ "top" ], //从下面动画弹出
                end: function () {
                    window.location.reload();
                }
            });
        }

        function refreshCode() {
            document.getElementById('imageValidate').src = '${ctx}/login/Kaptcha.jpg?' + Math.random();
        }


        // 如果在框架中，则跳转刷新上级页面
        if(self.frameElement && self.frameElement.tagName=="IFRAME"){
            parent.location.reload();
        }


        function login(){
            var loginName1=$("#username").val();
            var password1=$("#password").val();
            alert("测试！");
            /*if(loginName1==''||password1==''){
                $("#tips").html("用户名、密码、验证码不能为空");
            }else{*/
                $.ajax({
                    type : "post",
                    url :"/logined",
                    data:{username:loginName1,password:password1},
                    success : function(data) {
                        /*if(data==1){
                            $("#tips").html("验证码错误");
                        }else */if(data=="false"){
                            $("#tips").html("用户名或密码错误");
                        }else if(data=="true"){
                            window.location.href="toIndex";
                        }/*else if(data=="bbb"){
                            window.location.href="toBBB";
                        }*/

                    }

                });
//            }



        }

    </script>
</head>

<body>
<div class="wid top1"><img src="${ctx}/images/logo1.jpg" /></div>
<div class="land">
    <div class="wid land_1">
        <div class="title">
            <ul>
                <li class="ziti1"><a href="javascript:;">xiupeilian.com</a></li>
                <li class="ziti2">修配连汽配市场</li>
                <li class="ziti3">我的<span>网上汽配店铺</span></li>
            </ul>
        </div>
        <div class="login">
            <form id="loginForm"<%--  action="/logined" method="post"--%>>
                <div class="login_name"><input style="width:268px;height:38px;font-size:14px;font-family:'微软雅黑';color:#494848;padding-left:13px;border:1px solid #cdcdcd;" type="text" placeholder="用户名/邮箱/手机号"  id="username"/> </div>
                <div class="login_password"><input type="password" style="width:268px;height:38px;font-size:14px;font-family:'微软雅黑';color:#494848;padding-left:13px;border:1px solid #cdcdcd;" placeholder="登陆密码"  id="password"/></div>
                <div class="login_password">
                    <input type="text" style="width:100px;height:38px;font-size:14px;font-family:'微软雅黑';color:#494848;padding-left:13px;border:1px solid #cdcdcd;" name="validateCode" id="validateCode" class="delValue"  placeholder="验证码" onkeydown="javascript:if(event.keyCode==13) login();"/>
                    <label for="validateCode" class="checkCodePlaceholder" id="checkCodePlaceholder">看不清</label>
                    <img style="height:24px;width:60px;display:inline-block; vertical-align:middle;cursor:pointer;" src="${ctx}/login/Kaptcha.jpg" border="0" title="看不清,请点击图片换一张" id="imageValidate" onclick="refreshCode()" >
                    <span ><a onclick="mygs();" href="javascript:;" style="color:red;">忘记密码？</a></span>
                </div>

                <p style="margin-left:100px;margin-top:60px;color:red;font-size:16px" id="tips"></p>


                <button class="button" type="button" onclick="login()">登录</button>
                <input type="button" onclick="a0()" value="tijiao"/>
                <input type="button" onclick="login()" value="tijiao2"/>
            </form>
            <div class="position">还没有修配连账号吗？赶快<span><a href="${ctx}/register/toRegister.shtml">点击注册</a></span>加入我们吧！</div>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div class="footer wid">Copyright © 2014-2024 www.xiupeilian.com  All Rights Reserved. 修配连 版权所有</div>
</body>
</html>

