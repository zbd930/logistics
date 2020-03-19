<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jemmy
  Date: 2019/9/29
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%String path = request.getContextPath();%>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>e跨境通</title>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/foundation/5.5.3/js/foundation.min.js"></script>
    <script src="https://cdn.staticfile.org/foundation/5.5.3/js/vendor/modernizr.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script>
        function jump() {
            window.location.href="<%=path%>/huodai/jump3.do";
        }
    </script>
</head>
<body>
<jsp:include page="../selection/top.jsp" flush="true"/>
<jsp:include page="../selection/left.jsp" flush="true"/>

<div class="main">
    <div class="menu-top">
        <h1 style="padding-left: 3%;">任务查看</h1>
    </div>
    <div class="middle">
        <span style="display: block">相关信息如下：</span>
        <span style="display: block">剩余体积:${details.volume}CBM&nbsp;剩余重量:${details.weight}KG</span>
        <span style="display: block">截关时间:${details.cut_time}&nbsp;</span>
        <span style="display: block">开船时间:${details.cut_end}&nbsp;</span>
        <span style="display: block;margin-top: 10px;">该航次的所有订单信息如下：</span>
        <table style="height: 100px;overflow: scroll" class="table">
            <tr class="menu_tr" bgcolor="#CCFFFF">
                <td>订单编号</td>
                <td>目的地</td>
                <td>箱数</td>
                <td>重量</td>
                <td>体积</td>
                <td>送货时间</td>
                <td>品名</td>
                <td>状态</td>
                <td>备注</td>
                <td>UPS单号</td>
            </tr>
                <c:forEach items="${list}" var="o" >
                    <tr >
                        <td>${o.numbers}</td>
                        <td>${o.dest}</td>
                        <td>${o.order_details.ctn}</td>
                        <td>${o.order_details.weight}</td>
                        <td>${o.order_details.volume}</td>
                        <td>${o.picking}</td>
                        <td>${o.order_details.category}</td>
                        <td>${o.statu}</td>
                        <td>${o.order_details.beizhu}</td>
                        <td>${o.order_details.ups}</td></tr>
                </c:forEach>
    </div>
</div>
</body>
</html>
