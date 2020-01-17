<%@ page import="com.yiwutong.entities.User" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: jemmy
  Date: 2019/6/15
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String path = request.getContextPath();%>
<%User user= (User) session.getAttribute("user");%>

<html>
<head>
    <title>e跨境通</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script type="text/javascript">
        function display(id) {
            var traget = document.getElementById(id);
            if (traget.style.display == "none") {
                traget.style.display = "";
            } else {
                traget.style.display = "none";
            }
        }
    </script>
</head>
<!-- 左边导航栏 开始-->
<div id="menu">
    <!--显示菜单-->
    <div id="open">
        <div class="navBox">
            <ul >
                <li >
                    <p class="obtain"  onclick="display('lb')"><i>查询</i></p>
                    <div id="lb" style="display:none">
                        <a href="<%=path%>/jump/chaxun.do">
                            <p style="font-size: 16px;">任务查看</p></a>
                        <a href="<%=path%>/jump/pingui.do">
                            <p style="font-size: 16px;">拼柜任务</p></a>
                        <a href="<%=path%>/jump/user_order.do">
                            <p style="font-size: 16px;">用户订单</p></a>
                        <a href="<%=path%>/jump/genzhong.do">
                            <p style="font-size: 16px;">跟踪任务</p></a>
                    </div>
                </li>
                <li>
                    <p class="obtain"  onclick="display('lb1')"><i>财务</i></p>
                    <div id="lb1" style="display:none">
                        <a href="<%=path%>/jump/jine.do">
                            <p style="font-size: 16px;">金额查询</p></a>
                    </div>
                </li>
            </ul>
            <ul >
                <li>
                    <p class="obtain"  onclick="display('lb2')"><i>管理</i></p>
                    <div id="lb2" style="display:none">
                        <a href="<%=path%>/company/get.do?page=1">
                            <p style="font-size: 16px;">货代信息管理</p></a>
                        <a href="<%=path%>/company/get_address.do?page=1">
                            <p style="font-size: 16px;">发货人管理</p></a>
                    </div>
                </li>
                <li>
                    <p class="obtain"  onclick="display('lb3')"><i>异常</i></p>
                    <div id="lb3" style="display:none">
                        <a href="<%=path%>/jump/problem.do">
                            <p style="font-size: 16px;">跟踪任务</p></a>
                        <a href="<%=path%>/problem/get.do">
                            <p style="font-size: 16px;">账号重置</p></a>
                    </div>
                </li>
            </ul>

        </div>
    </div>
</div>
</body>
</html>
