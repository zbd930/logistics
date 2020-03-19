<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%String path = request.getContextPath();%>

<%--
  Created by IntelliJ IDEA.
  User: jemmy
  Date: 2019/9/26
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>e跨境通</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <style>
        .input {
            height: 50px;
            width: 100px;
        }
        .select{
            height: 50px;
            width: 100px;
        }
    </style>
    <script>
        $(document).ready(function () {

            var jieguo="${my_result}";
            if (jieguo!=""){
                alert(jieguo);
            }
        })
    </script>
</head>
<body>
    <jsp:include page="/jsp/selection/top.jsp" flush="true"/>
    <jsp:include page="/jsp/selection/left.jsp" flush="true"/>
        <div class="main">
            <div class="menu-top">
                <h1 style="padding-left: 3%;">追踪任务</h1>
            </div>
            <div class="middle">
                <span >追踪航次单号</span>
                <form action="<%=path%>/chaxun/chaxun.do" method="get">
                    <input name="num" placeholder="请输入编号" class="input" style="width: 100px">
                    <input type="submit">
                </form>
                <span>
                      <p>订单号：${item.number}</p><p>最新状态：${item.statu}</p>
                </span><br><br><br>
                <span>更新航次状态</span>
                <form action="<%=path%>/chaxun/genzhong.do" method="post">
                    <input name="number" placeholder="请输入编号" class="input" style="width: 100px">
                    <select name="status" class="select">
                        <option value="1">已装柜</option>
                        <option value="2">报关中</option>
                        <option value="3">开船</option>
                        <option value="4">货到港</option>
                        <option value="5">查验中</option>
                        <option value="6">已完成</option>
                    </select>
                    <input type="submit" style="display: block" onclick="return confirm('确认更新?')">
                </form>
            </div>
        </div>
</body>
</html>
