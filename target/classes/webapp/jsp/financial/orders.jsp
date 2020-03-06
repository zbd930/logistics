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
                    <span><a href="<%=path%>/financial/get_zhangdan.do?method=0&&page=1&&number=null">海派</a>&nbsp;&nbsp;<a href="<%=path%>/financial/get_zhangdan.do?method=1&&page=1&&number=null">海卡</a>&nbsp;&nbsp;<a href="<%=path%>/financial/get_zhangdan.do?method=2&&page=1&&number=null">空派</a>&nbsp;&nbsp;<a href="<%=path%>/financial/get_zhangdan.do?method=3&&page=1&&number=null">空派（直飞）</a>&nbsp;&nbsp;<a href="<%=path%>/financial/get_zhangdan.do?method=4&&page=1&&number=null">空派（带电)</a></span>
            <br>
                <form action="<%=path%>/financial/get_zhangdan.do">
                    <input name="numbers" placeholder="请输入用户单号" style="width: 100px">
                    <input name="page"  style="display: none" value="1">
                    <input name="method"  style="display: none" value="null">
                    <input type="submit">
                </form>
                <a href="<%=path%>/financial/export.do">点击下载</a>
                <br>
                <table class="table">
                    <tr class="menu_tr" bgcolor="#CCFFFF">
                        <td>用户订单编号</td>
                        <td>供应商ID</td>
                        <td>起运地</td>
                        <td>目的地</td>
                        <td>状态</td>
                        <td>起运时间</td>
                        <td>品名</td>
                        <td>件数</td>
                        <td>重量</td>
                        <td>体积</td>
                        <td>已支付运费</td>
                        <td>报关费</td>
                        <td>关税</td>
                        <td>查验费</td>
                        <td>总运费</td>
                    </tr>
                    <c:forEach items="${pagebean.list}" var="o" >
                        <tr >
                            <td>${o.numbers}</td>
                            <td>${o.ship.user_id}</td>
                            <td>${o.ship.qiyungang}</td>
                            <td>${o.dest}</td>
                            <td>${o.statu}</td>
                            <td>${o.ship.etd}</td>
                            <td>${o.order_details.category}</td>
                            <td>${o.order_details.ctn}</td>
                            <td>${o.order_details.weight}</td>
                            <td>${o.order_details.volume}</td>
                            <td>${o.amount.paid}</td>
                            <td>${o.amount.customer}</td>
                            <td>${o.amount.tax}</td>
                            <td>${o.amount.inspect}</td>
                            <td>${o.amount.total}</td>
                        </tr>
                    </c:forEach>
                </table>
                <div style="position: relative;margin-left: 65% " >
                  <c:if test="${pagebean.allRows!='0'}">
                    <font size="2">共<font color="red"><c:out value="${pagebean.allRows}"></c:out></font>条记录</font><br><br>
                    <font size="2">共<font color="red"><c:out value="${pagebean.totalPage}"></c:out></font>页 </font>
                    <font size="2">当前<font color="red"><c:out value="${pagebean.currentPage}"></c:out></font>页 </font>&nbsp;&nbsp;
                    <c:choose>
                        <c:when test="${pagebean.currentPage==1} ">
                            首页&nbsp;&nbsp;&nbsp;上一页
                        </c:when>
                        <c:otherwise>
                            <a href="<%=path%>/financial/get_zhangdan.do?page=1&&method=${pagebean.list.get(0).ship.method}">首页</a>
                            &nbsp;&nbsp;&nbsp;
                            <a href="<%=path%>/financial/get_zhangdan.do?page=<c:out value="${pagebean.currentPage-1}&&method=${pagebean.list.get(0).ship.method}" /> ">上一页</a>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${pagebean.currentPage==pagebean.totalPage}">
                            下一页&nbsp;&nbsp;&nbsp;尾页
                        </c:when>
                        <c:otherwise>
                            <a href="<%=path%>/financial/get_zhangdan.do?page=<c:out value="${pagebean.currentPage+1}&&method=${pagebean.list.get(0).ship.method}" />">下一页</a>
                            &nbsp;&nbsp;&nbsp;
                            <a href="<%=path%>/financial/get_zhangdan.do?page=${pagebean.totalPage}&&method=${pagebean.list.get(0).ship.method}">尾页</a>
                        </c:otherwise>
                    </c:choose>
                    <p style="display: inline-block;">
                    <form action="<%=path%>/financial/get_zhangdan.do?" size="2" onclick="return validate(this)">
                        跳转到&nbsp;<input type="text" name="page" style="width:40px;height: 20px;display: inline-block">&nbsp;页面
                        <input style="display: none" name="method" value="${pagebean.list.get(0).ship.method}">
                        <input type="submit" value="go" style="display: inline-block" onclick="return validate(this)">
                    </form>
                    </p>
                  </c:if>
                </div>
            </div>

        </div>
</body>
</html>
