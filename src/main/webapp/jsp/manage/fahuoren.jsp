<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-12-16
  Time: 上午 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.yiwutong.entities.User" %>
<%String path = request.getContextPath();%>
<%@ page isELIgnored="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>e跨境通</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
        <jsp:include page="/jsp/selection/top.jsp" flush="true"/>
        <jsp:include page="/jsp/selection/left.jsp" flush="true"/>
        <div class="main">
            <div class="menu-top">
                <h1 style="padding-left: 3%;">发货人信息管理</h1>
            </div>
            <div class="middle">
                <table class="table">
                    <tr class="menu_tr" bgcolor="#CCFFFF">
                        <td>openid</td>
                        <td>电话</td>
                        <td>地址</td>
                        <td>名字</td>
                    </tr>
                    <c:forEach items="${pagebean.list}" var="o" >
                        <tr >
                            <td>${o.openid}</td>
                            <td>${o.phone}</td>
                            <td>${o.address}</td>
                            <td>${o.name}</td>
                        </tr>
                    </c:forEach>
                </table>

                <div style="position: relative;margin-left: 65% " >

                    <font size="2">共<font color="red"><c:out value="${pagebean.allRows}"></c:out></font>条记录</font><br><br>
                    <font size="2">共<font color="red"><c:out value="${pagebean.totalPage}"></c:out></font>页 </font>
                    <font size="2">当前<font color="red"><c:out value="${pagebean.currentPage}"></c:out></font>页 </font>&nbsp;&nbsp;
                    <c:choose>
                        <c:when test="${pagebean.currentPage==1} ">
                            首页&nbsp;&nbsp;&nbsp;上一页
                        </c:when>
                        <c:otherwise>
                            <a href="<%=path%>/company/get_address.do?page=1">首页</a>
                            &nbsp;&nbsp;&nbsp;
                            <a href="<%=path%>/company/get_address.do?page=<c:out value="${pagebean.currentPage-1}" /> ">上一页</a>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${pagebean.currentPage==pagebean.totalPage}">
                            下一页&nbsp;&nbsp;&nbsp;尾页
                        </c:when>
                        <c:otherwise>
                            <a href="<%=path%>/company/get_address.do?page=<c:out value="${pagebean.currentPage+1}" />">下一页</a>
                            &nbsp;&nbsp;&nbsp;
                            <a href="<%=path%>/company/get_address.do?page=${pagebean.totalPage}">尾页</a>
                        </c:otherwise>
                    </c:choose>
                    <p style="display: inline-block;">
                    <form action="<%=path%>/company/get_address.do?page" size="2" onclick="return validate(this)">
                        跳转到&nbsp;<input type="text" name="page" style="width:40px;height: 20px;display: inline-block">&nbsp;页面
                        <input type="submit" value="go" style="display: inline-block" onclick="return validate(this)">
                    </form>
                    </p>
                </div>

            </div>
        </div>

</body>
</html>
