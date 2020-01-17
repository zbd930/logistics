<%--
  Created by IntelliJ IDEA.
  User: jemmy
  Date: 2019/12/16
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.yiwutong.entities.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%String path = request.getContextPath();%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%User user= (User) session.getAttribute("user");%>
<html>
<html>
<head>
    <title>e跨境通</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script>
        function openDialog(){
            document.getElementById('light').style.display='block';
            document.getElementById('fade').style.display='block'
        }
        function closeDialog(){
            document.getElementById('light').style.display='none';
            document.getElementById('fade').style.display='none'
        }
        $(document).ready(function () {
            var result="${final_result}";
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
                <h1 style="padding-left: 3%;">数据异常</h1>
            </div>
            <div class="middle">
                <form action="<%=path%>/problem/get_redis_data.do">
                    <input type="number" name="number" style="width: 250px" placeholder="请输入单号">
                    <input type="submit" value="提交">
                </form>
                    <p>箱数:${data.ctn}</p>
                    <p>重量:${data.weight}</p>
                    <p>体积${data.volume}</p>
                    <a onclick="openDialog()" >点击修正</a>
                <%--弹窗1--%>
                <div id="light" class="white_content" >
                    <img src="<%=path%>/image/close.png" style="margin-bottom: 80px;width: 20px;height: 20px;position: absolute;right: 5px;cursor: pointer" onclick = "closeDialog()">
                    <form action="<%=path%>/problem/confirmed_data.do" style="text-align: center;margin-top:20px;" method="POST">
                        <input name="number" placeholder="请输入数字">
                        <input name="ctn" type="number"  step="0.01" placeholder="请输入箱数" >
                        <input name="weight" type="number"  step="0.01"  placeholder="请输入重量">
                        <input name="volume"  type="number"  step="0.01" placeholder="请输入体积">
                        <button style="display: block;margin-left:45%">提交</button>
                    </form>
                </div>
                <div id="fade" class="black_overlay"></div>

            </div>
        </div>
</body>
</html>
