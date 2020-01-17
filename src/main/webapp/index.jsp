<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%String path=request.getContextPath();%>
<html>
<head>
    <title>e跨境通</title>
    <style type="text/css">*{font-size:12px;}</style>
    <link rel="stylesheet" href="https://cdn.staticfile.org/foundation/5.5.3/css/foundation.min.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/all.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/iconfont.css">
    <script src="<%=path%>/static/all.js"></script>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/foundation/5.5.3/js/foundation.min.js"></script>
    <script src="https://cdn.staticfile.org/foundation/5.5.3/js/vendor/modernizr.js"></script>
    <style>
        body{
            position: relative;
            /*-webkit-background-size: 100%;*/
            background:url("<%=path%>/static/background.jpg")  no-repeat center center;
            background-size:cover;
            /*background: url("background.jpg") no-repeat fixed;*/
            overflow:hidden;
        }
    </style>
</head>

<body>
<div class="login">
    <h1>易跨境运营后台</h1>
    <img src="<%=path%>/static/yiwutong.jpg" style="width: 100px;height: 100px">
    <div>
        <form action="<%=path%>/User/login.do" method="post" >
            <input type="text" name="name" placeholder="请输入账号"  required="required" class="log_input" style="width: 60%;display: inline"></span>
            <input type="password" name="password" class="log_input"  placeholder="请输入密码"   style="width:  60%;display: inline" required="required"></span>
            <input type="submit" class="log_submit"  value="提交" style="width:  40% ;display: inline">
            <p style="color: red;font-size: 10px;">${the_result}</p>
        </form>
    </div>
</div>
</body>
</html>
