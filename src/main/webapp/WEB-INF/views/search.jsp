<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.edu360.ilearn.Vo.PageVo" %>
<!--课程搜索页面-->
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("ctx", path);
    PageVo pVo = (PageVo) session.getAttribute("pVo");
    String searchContent = (String) session.getAttribute("searchContent");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>搜索页面</title>
        <link href="../../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        
        <meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="../../js/jquery.min.js"></script>
    </head>
    <script>
//  异步请求方法1  保存（request？session）一个list数据 包含一组实体类对象

//  异步请求方法2 含参数  保存（request？session）一个list数据 包含一组已排序的实体类对象
    
    </script>
    <body>
    	<div class="container">
    		<!--搜索参数设置-->
    		<div>
	    		<!--搜索栏-->
	    		<div>
	    			<form>
	    				<input type="text" name="searchin" id="searchin" value="${searchContent}"/>
	    				<!--保存（request？session）一个字符串（搜索内容）数据-->
	    				<!--提交异步请求1-->
	    				<button value="搜索" accesskey="Enter" onclick=""></button>
	    			</form>
	    		</div>
	    		<!--排序方式-->
	    		<div>
	    			时间：
	    			<!--异步请求2参数1-->
	    			<a onclick="">
	    				<font>
	    					升序
	    				</font>
	    			</a>
	    			<!--异步请求2参数2-->
	    			<a onclick="">
	    				<font>
	    					降序
	    				</font>
	    			</a>
	    		</div>
    		</div>
    		<!--搜索结果显示-->
    		<div>
    			<!--循环提取list中的实体类并在div中显示-->
                <c:forEach items="${pVo.pageList}" var="course" varStatus="status">
                    <div style="width: 16%;height: 150px;margin-left: 2%;margin-right: 2%">
                        <div style="width: 100%;height: 50%">
                            <img src="${course.picAddr}" height="" width=""/>
                        </div>
                        <div style="width: 100%;height: 50%">
                            <div style="width: 100%;height: 50%">
                                <h5>${course.courseName}</h5><br>
                                <%--nickName没有做，暂时用id代替--%>
                                <h6>${course.userId}</h6>
                            </div>
                            <div style="width: 100%;height: 50%">
                                <%--打分插件没做，展示显示分数--%>
                                <h6>${course.mark}</h6><br>
                                 <%--积分购买制度没有实行，暂无内容--%>
                                <h5>免费</h5>
                            </div>

                        </div>
                    </div>


                </c:forEach>

				<%--分页--%>
                <a href="javascript:go(<%=pVo.getNow_page()-1%>)" class="a1">上一页</a>
                <%
                    int se[] = pVo.getStart_end();
                    if(se[0]>1){
                        out.print(" ...");
                    }
                    for(int pi=se[0];pi<=se[1];pi++){
                        if(pi==pVo.getNow_page()){
                            out.print("　<a href='javascript:;' class='se'>"+pi+"</a>");
                        }else{
                            out.print("　<a href='javascript:go("+pi+")'>"+pi+"</a>");
                        }
                    }
                    if(pVo.getTotal_page_num()>se[1]){
                        out.print("  ... ");
                    }
                %>　
                <a href="javascript:go(<%=pVo.getNow_page()+1%>)" class="a2">下一页</a>
                <script type="text/javascript">
                    function go(page){
                        if(page<1){
                            alert("已到首页");
                            return;
                        }
                        if(page><%=pVo.getTotal_page_num()%>){
                            alert("已到尾页");
                            return;
                        }
                        if(page==<%=pVo.getNow_page()%>){
                            return;
                        }
                        <%
                            pVo.setNow_page((int)page);
                            session.setAttribute("pVo",pVo);
                        %>
                        var url = "toSearch";
                        location.href = url;
                    }
                </script>
    		</div>
    	</div>
 	</body>
</html>