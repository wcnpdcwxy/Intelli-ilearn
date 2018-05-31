<%@ page import="com.edu360.ilearn.entity.Course" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.edu360.ilearn.Vo.CourseVo" %>
<%@ page import="javafx.scene.control.Alert" %>
<%@ page import="java.io.Console" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>视频目录页面</title>
        <link href="../../../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="../../../js/jquery.min.js"></script>
		<script src="../../../js/bootstrap.min.js"></script>
    </head>
    <body>
    	<table class="table table-condensed">
    		<c:forEach items="${detail.list}" var="vd" varStatus="status">

                    <tr>
                        <td>
                            课时${status.count}
                        </td>
                        <td>
                            <a onclick="gotowatch(${vd.id})">
                                ${vd.title}
                            </a>
                        </td>
                        <td>
                                ${vd.duration}
                        </td>
                        <%--<c:if test="${vd.state==0}">--%>
                            <%--<td>--%>
                                <%--未学--%>
                            <%--</td>--%>
                        <%--</c:if>--%>
                        <%--<c:if test="${vd.state==1}">--%>
                            <%--<td>--%>
                                <%--已学--%>
                            <%--</td>--%>
                        <%--</c:if>--%>
                    </tr>

			</c:forEach>
		</table>
        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">购买课程</h4>
                    </div>
                    <div class="modal-body">
                        尊敬的${user.getNickName()}，您还没有购买过本课程。<br/>
                        是否要花费${detail.getCourse().getCost()}个积分购买"${detail.getCourse().getCourseName()}"课程？
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-primary" onclick = "javascript:if(${user.getPoints()>=detail.getCourse().getCost()}){window.parent.location.href='afford'}else{confirm('您的积分不足，请尝试其它课程。')}">确认购买</button>
                    </div>
                </div>
            </div>
        </div>
 	</body>
    <script>
        function gotowatch(contentId) {
            <%
                boolean kk = false;
                ArrayList<Course> orderList = (ArrayList<Course>)session.getAttribute("orderlist");
                CourseVo detail = (CourseVo)session.getAttribute("detail");
                if(orderList!=null){
                    for(int i = 0;i<orderList.size();i++){
                        Course course = orderList.get(i);
                        if(course.getId()==detail.getCourse().getId()){
                            kk = true;
                        }
                    }
                }
                if(kk==true){
            %>
            window.parent.location.href="Vdetail?contentId="+contentId;
            <%
                }else{
                    %>
            $('#myModal').modal('show');


                    <%
                  }
             %>
        }
    </script>
</html>