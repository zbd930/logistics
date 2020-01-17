<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%--
  Created by IntelliJ IDEA.
  User: jemmy
  Date: 2019/5/7
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String path = request.getContextPath();%>
<!DOCTYPE>
<html>
<head>
    <title>e跨境通</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/foundation/5.5.3/css/foundation.min.css">
    <link rel="stylesheet" type="text/css" href="<%out.print(path);%>/static/all.css">
    <link rel="stylesheet" type="text/css" href="<%out.print(path);%>/static/iconfont.css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/foundation/5.5.3/js/foundation.min.js"></script>
    <script src="https://cdn.staticfile.org/foundation/5.5.3/js/vendor/modernizr.js"></script>

</head>

<body>
<nav class="top-bar" data-topbar>
    <ul class="title-area">
        <li class="name">
            <!-- 如果你不需要标题或图标可以删掉它 -->
            <h1><a href="#">易跨境物流</a></h1>
        </li>
        <!-- 小屏幕上折叠按钮: 去掉 .menu-icon 类，可以去除图标。
        如果需要只显示图片，可以删除 "Menu" 文本 -->
        <li class="toggle-topbar menu-icon"><a href="<%out.print(path);%>/jsp/menu.jsp"><span></span></a></li>
    </ul>

    <section class="top-bar-section">
        <ul class="left">
            <%--<li class="active"><a href="orderAction_execute.action">Home</a></li>--%>
            <%--<li><a href="orderAction_execute.action">订单</a></li>--%>
            <%--<li><a href="orderAction_file.action">员工档案</a></li>--%>
        </ul>
        <div class="admin">
            <p>
                  <%
                    LocalDateTime localDateTime= LocalDateTime.now();
                      //创建一个日期对象
                      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
                      //下面两种方式都可以用来格式化成想要的格式
                      String string = localDateTime.format(formatter);
                    out.print(string);
                %>&nbsp; &nbsp;
            </p>

               <a href="<%=path%>/User/Menuservlet_exit.do" style="position: absolute;right: 50px">退出登陆</a>

        </div>
    </section>
</nav>

</body>
</html>
