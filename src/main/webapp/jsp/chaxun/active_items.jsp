<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.yiwutong.entities.User" %>
<%String path = request.getContextPath();%>
<%@ page isELIgnored="false" %>

<%--
  Created by IntelliJ IDEA.
<%String path = request.getContextPath();%>
<%--
  Created by IntelliJ IDEA.
  User: jemmy
  Date: 2019/8/13
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%User user= (User) session.getAttribute("user");%>
<%--
  Created by IntelliJ IDEA.
  User: jemmy
  Date: 2019/12/15
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>e跨境通</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <style>
        span a{
            margin-left: 50px;
        }
    </style>
</head>
<body>
<jsp:include page="/jsp/selection/top.jsp" flush="true"/>
<jsp:include page="/jsp/selection/left.jsp" flush="true"/>
        <div class="main">
            <div class="menu-top">
                <h1 style="padding-left: 3%;">任务查看</h1>
            </div>
            <div class="middle">
                    <span><a href="<%=path%>/chaxun/get_items_method.do?method=0">海派</a>&nbsp;&nbsp;<a href="<%=path%>/chaxun/get_items_method.do?method=1">海卡</a>&nbsp;&nbsp;<a href="<%=path%>/chaxun/get_items_method.do?method=2">空派</a>&nbsp;&nbsp;<a href="<%=path%>/chaxun/get_items_method.do?method=3">空派（直飞）</a>&nbsp;&nbsp;<a href="<%=path%>/chaxun/get_items_method.do?method=4">空派（带电)</a></span>

            <br><br>
                <table class="table">
                    <tr class="menu_tr" bgcolor="#CCFFFF">
                        <td>航次订单编号</td>
                        <td>起运地</td>
                        <td>拆柜地</td>
                        <td>方式</td>
                        <td>计划出发</td>
                        <td>描述</td>
                        <td>状态</td>
                        <td>置顶</td>
                    </tr>
                    <c:forEach items="${list}" var="o" >
                        <tr >
                            <td>${o.number}</td>
                            <td>${o.qiyungang}</td>
                            <td>${o.mudigang}</td>
                            <td>${o.method}</td>
                            <td>${o.etd}</td>
                            <td>${o.desc}</td>
                            <td>${o.statu}</td>
                            <td><a onclick="return confirm('确认置顶?')" href="<%=path%>/chaxun/top.do?number=${o.number}">置顶</a></td>
                        </tr>
                    </c:forEach>
                </table>

            </div>

        </div>
</body>
</html>
