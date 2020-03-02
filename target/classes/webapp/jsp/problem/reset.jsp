<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-12-20
  Time: 上午 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.yiwutong.entities.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%String path = request.getContextPath();%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%User user= (User) session.getAttribute("user");%>
<html>
<head>
    <title>e跨境通</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            var result="<%=request.getParameter("password")%>";
            if (result!="null"){
                alert(result)
            }
        })
    </script>
</head>
<body>
<jsp:include page="/jsp/selection/top.jsp" flush="true"/>
<jsp:include page="/jsp/selection/left.jsp" flush="true"/>
<div class="main">
    <div class="menu-top">
        <h1 style="padding-left: 3%;">重置账号</h1>
    </div>
    <div class="middle">
        <table class="table" >
                <tr class="menu_tr" bgcolor="#CCFFFF" >
                    <td>公司名</td>
                    <td>用户ID</td>
                    <td>联系人</td>
                    <td>账号</td>
                    <td>重置</td>
                </tr>
            <c:forEach items="${companies}" var="o" >
                <tr>
                    <td>${o.company_name}</td>
                    <td>${o.user_id}</td>
                    <td>${o.contact_name}</td>
                    <td>${o.user.username}</td>
                    <td><a href="<%=path%>/User/reset.do?user_id=${o.user_id}">重置密码</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
