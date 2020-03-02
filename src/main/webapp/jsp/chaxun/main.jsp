<%@ page import="com.yiwutong.entities.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%String path = request.getContextPath();%>
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
            var result="${jieguo}";
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
                <span style="width: 100%;">
                    <form action="<%=path%>/chaxun/get.do" method="get">
                        <input  style="display:none;width: 20% " name="page"  value="1" placeholder="起始时间" >
                        <input  style="width: 20%;display: inline-block" name="start" type="date" placeholder="起始时间">
                        <input  style="width: 20%;display: inline-block" name="end" type="date" placeholder="结束时间">
                        <input  style="width: 20%;display: inline-block" name="number"  placeholder="单号">
                        <input  style="width: 20%;display: inline-block" type="number" value="0" name="user_id">
                        <button>提交</button>
                    </form>
                </span>
            </div>
            <div class="selection" style="font-size: 15px;margin-left:50px">
                <a onclick="return confirm('确认下载?')" href="<%=path%>/chaxun/export.do">点击导出数据</a>
            </div>
            <div style="overflow: scroll;height:600px">
                <table class="table" >
                    <tr class="menu_tr" bgcolor="#CCFFFF" >
                        <td>航次订单编号</td>
                        <td>起运地</td>
                        <td>拆柜地</td>
                        <td>方式</td>
                        <td>计划出发</td>
                        <td>描述</td>
                        <td>状态</td>
                        <td>供应商ID</td>
                        <td>慢必赔</td>
                        <td>选项</td>
                        <td>删除</td>
                    </tr>
                    <c:forEach items="${list}" var="o" >
                        <tr >
                            <td>${o.number}</td>
                            <td>${o.qiyungang}</td>
                            <td>${o.mudigang}</td>
                            <td>${o.method}</td>
                            <td>${o.etd}</td>
                            <td>${o.eta}</td>
                            <td>${o.statu}</td>
                            <td>${o.user_id}</td>
                            <td>${o.details.compensate}</td>
                            <td><a href="<%=path%>/jump/details.do?id=${o.id}">更多</a></td>
                            <td><a onclick="return confirm('确认删除?')" href="<%=path%>/chaxun/delete.do?id=${o.id}">删除</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
</body>
</html>
