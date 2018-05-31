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
                            <a onclick="gotowatch(${vd.id})" ">
                                ${vd.title}
                            </a>
                        </td>
                        <td>
                                ${vd.duration}
                        </td>
                        <c:if test="${vd.state==0}">
                            <td>
                                未学
                            </td>
                        </c:if>
                        <c:if test="${vd.state==1}">
                            <td>
                                已学
                            </td>
                        </c:if>
                    </tr>

			</c:forEach>
		</table>
 	</body>
    <script>
        function gotowatch(contentId) {
            window.parent.location.href="Vdetail?contentId="+contentId;
        }
    </script>
</html>