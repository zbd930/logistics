<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.yiwutong.entities.User" %>
<%String path = request.getContextPath();%>
<%@ page isELIgnored="false" %>
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
    <script>
        $(document).ready(function () {
            var result="${delete}";
            if(result!=""){
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
                <h1 style="padding-left: 3%;">任务查看</h1>
            </div>
            <div class="middle">
                <form action="<%=path%>/chaxun/check_schdule_id.do" METHOD="post" style="position: absolute;left:15%">
                    <input name="numbers" type="text" style="width: 250px;display: inline-block" placeholder="用户订单号">
                    <button style="width: 100px;height: 50px;display: inline-block">查询</button>
                </form>
            <br><br>
                <table class="table" style="margin-top: 30px;">
                    <tr class="menu_tr" bgcolor="#CCFFFF" >
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
                    <td>选项</td>
                    </tr>
                    <c:forEach items="${list1}" var="o" >
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
                            <td>${o.order_details.ups}</td>
                            <td><a onclick="return confirm('确认删除?')" href="<%=path%>/chaxun/delete_order.do?number=${o.numbers}&&weight=${o.order_details.weight}&&volume=${o.order_details.volume}&&order_id=${o.id}">删除</a></td>
                        </tr>
                    </c:forEach>
                </table>

            </div>

        </div>
</body>
</html>
