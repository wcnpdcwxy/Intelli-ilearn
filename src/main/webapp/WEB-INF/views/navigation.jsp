<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
  String path=request.getContextPath();
  pageContext.setAttribute("ctx", path);

%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>修配连汽配市场</title>
<link href="../../css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../js/jquery-1.7.1.min.js"></script>
<!--tab切换-->
<script src="../../js/jquery.tabs.js"></script>
<script>
   function goTo(src) {
		window.top.document.getElementById('body').src = src;

	}
</script>
</head>

<body>
	<div class="top3">
		<!--导航-->
		<div class="wid">
			<div class="top3_left">
				<span>修配连</span>汽配市场
			</div>
			<div class="top3_right">
				<!--导航-->
				<%--<c:if test="${not empty user.menus}">
					<ul id="test">
						<c:forEach var="menu" items="${user.menus}"
							varStatus="status">

								<li onclick="goTo('${ctx}${menu.forward}')">
									<div class="top">
										 <img src="${ctx}/${menu.imgUrl}" /> 
									</div>
									<div class="bottom">${menu.menuName}</div> 
									<c:if test="${menu.menuName eq '询价单'}">
										<div class="radius" style="left:58px" id="xjd"></div>
									</c:if> <c:if test="${menu.menuName eq '公共货架'}">
										<div id="gghj"
											style="border-radius: 9px;bottom: 58px;color: #fff;height: 14px; left: 65px;margin: 0 auto;padding: 2px;position: absolute;text-align: center;width: 14px;">
											<img src="${ctx}/images/new.gif">
										</div>
									</c:if>
								</li>

						</c:forEach>

					</ul>
				</c:if>--%>
				<li onclick="goTo('toTest')">
					<div class="top">
						<img src="../../images/icon005.png" />
					</div>
					<div class="bottom">大数据</div>
				</li>
				<div class="clear"></div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<!--导航-->
</body>
</html>
