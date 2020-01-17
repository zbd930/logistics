<%@ page import="com.yiwutong.entities.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path = request.getContextPath();%>
<%@ page isELIgnored="false" %>

<%--
  Created by IntelliJ IDEA.
  User: jemmy
  Date: 2019/8/13
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%User user= (User) session.getAttribute("user");%>
<html>
<head>
    <title>e跨境通</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div>
    <jsp:include page="/jsp/selection/top.jsp" flush="true"/>
    <jsp:include page="/jsp/selection/left.jsp" flush="true"/>
    <div class="main">
        <div class="menu-top">
            <h1 style="padding-left: 3%;">欢迎您</h1>
        </div>
        <div class="menu">
            <div id="menu-items">
                <div class="menu_item"><a href="<%=path%>/jsp/menu.jsp">
                    <img src="<%=path%>/image/shouye.png" class="menu_image">
                    <span style="display: block;text-align: center">控制台</span>
                </a>

                </div>
                <div class="menu_item"><a href="<%=path%>/xinxi/xinxi.do">
                    <img src="<%=path%>/image/xinxi.png" class="menu_image">
                    <span style="display: block;text-align: center">信息</span>
                </a>
                </div>
                <div class="menu_item"><a href="<%=path%>/system/system.do">
                    <img src="<%=path%>/image/system.png" class="menu_image">
                    <span style="display: block;text-align: center">系统</span>
                </a>
                </div>
            </div>

        </div>
    </div>

</div>
</body>
</html>
