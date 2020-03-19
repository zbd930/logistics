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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%User user= (User) session.getAttribute("user");%>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>e跨境通</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script>
        $(document).ready(function () {
            var result="${jieguo}";
            if(result!=""){
                alert(result)
            }
        })
        function add(id){
            var value=document.getElementById('id') ;
            value.value=id;
            document.getElementById('light').style.display='block';
            document.getElementById('fade').style.display='block'
        }
        function closeDialog(){
            document.getElementById('light').style.display='none';
            document.getElementById('fade').style.display='none'
        }
        function add1(){
            document.getElementById('light1').style.display='block';
            document.getElementById('fade1').style.display='block'
        }
        function closeDialog1(){
            document.getElementById('light1').style.display='none';
            document.getElementById('fade1').style.display='none'
        }
        function add2(user_id){
            document.getElementById('id3').value=user_id;
            document.getElementById('light2').style.display='block';
            document.getElementById('fade2').style.display='block'
        }
        function closeDialog2(){
            document.getElementById('light2').style.display='none';
            document.getElementById('fade2').style.display='none'
        }
    </script>
</head>
<body>
        <jsp:include page="/jsp/selection/top.jsp" flush="true"/>
        <jsp:include page="/jsp/selection/left.jsp" flush="true"/>
        <div class="main">
            <div class="menu-top">
                <h1 style="padding-left: 3%;">货代信息管理</h1>
            </div>
            <div class="middle">
                <a onclick="add1()">新增添加</a>
                <table class="table">
                    <tr class="menu_tr" bgcolor="#CCFFFF">
                        <td>供应商ID</td>
                        <td>联系人姓名</td>
                        <td>联系人电话</td>
                        <td>联系人邮箱</td>
                        <td>联系人地址</td>
                        <td>公司名字</td>
                        <td>赔偿条款</td>
                        <td>新增地址</td>
                    </tr>
                    <c:forEach items="${pagebean.list}" var="o" >
                        <tr >
                            <td>${o.user_id}</td>
                            <td>${o.contact_name}</td>
                            <td>${o.contact_phone}</td>
                            <td>${o.contact_mail}</td>
                            <td>${o.contact_address}</td>
                            <td>${o.company_name}</td>
                            <td>${o.peichang}<br><a onclick="add(${o.supplier_id})">点击修改</a></td>
                            <td><a onclick="add2(${o.user_id})">点击新增</a></td>
                        </tr>
                    </c:forEach>
                </table>
                <%--弹窗1--%>
                <div id="light" class="white_content" >
                    <img src="<%=path%>/image/close.png" style="margin-bottom: 80px;width: 20px;height: 20px;position: absolute;right: 5px;cursor: pointer" onclick = "closeDialog()">
                    <form action="<%=path%>/company/peichang.do" style="text-align: center;margin-top:20px;" method="POST">
                        <input name="id"  id="id" style="display: none">
                        <textarea name="peichang" cols="1" rows="3" style="resize:none" >

                        </textarea>
                        <button style="display: block;margin-left:45%">提交</button>
                    </form>
                </div>
                <div id="fade" class="black_overlay"></div>

                <%--弹窗2--%>
                <div id="light1" class="white_content" >
                    <img src="<%=path%>/image/close.png" style="margin-bottom: 80px;width: 20px;height: 20px;position: absolute;right: 5px;cursor: pointer" onclick = "closeDialog1()">
                    <form action="<%=path%>/company/add.do" style="text-align: center;margin-top:20px;" method="POST">
                        <input name="username" placeholder="账号">
                        <input name="password"  placeholder="密码" type="password">
                        <input name="type"  value="2" style="display: none" p>
                        <input name="contact_name" placeholder="联系人姓名">
                        <input name="contact_phone"  placeholder="联系人电话">
                        <input name="contact_mail" placeholder="联系人邮箱">
                        <input name="contact_address" placeholder="提货地址（重要）">
                        <input name="company_name" placeholder="公司名字">
                        <textarea name="peichang" cols="1" rows="3" style="resize:none" placeholder="赔偿">
                        </textarea>
                        <button style="display: block;margin-left:45%">提交</button>
                    </form>
                </div>
                <div id="fade1" class="black_overlay"></div>
                <%--弹窗3--%>
                <div id="light2" class="white_content" >
                    <img src="<%=path%>/image/close.png" style="margin-bottom: 80px;width: 20px;height: 20px;position: absolute;right: 5px;cursor: pointer" onclick = "closeDialog2()">
                    <form action="<%=path%>/company/add_address.do" style="text-align: center;margin-top:20px;" method="POST">
                        <input name="user_id" id="id3" placeholder="" style="display: none">
                        <input name="contact_name" placeholder="联系人姓名">
                        <input name="contact_phone"  placeholder="联系人电话">
                        <input name="contact_mail" placeholder="联系人邮箱">
                        <input name="contact_address" placeholder="提货地址（重要）">
                        <input name="company_name" placeholder="公司名字">
                        <textarea name="peichang" cols="1" rows="3" style="resize:none;width: 400px" placeholder="赔偿">
                        </textarea>
                        <button style="display: block;margin-left:45%">提交</button>
                    </form>
                </div>
                <div id="fade2" class="black_overlay"></div>


                <div style="position: relative;margin-left: 65% " >
                        <font size="2">共<font color="red"><c:out value="${pagebean.allRows}"></c:out></font>条记录</font><br><br>
                        <font size="2">共<font color="red"><c:out value="${pagebean.totalPage}"></c:out></font>页 </font>
                        <font size="2">当前<font color="red"><c:out value="${pagebean.currentPage}"></c:out></font>页 </font>&nbsp;&nbsp;
                        <c:choose>
                            <c:when test="${pagebean.currentPage==1} ">
                                首页&nbsp;&nbsp;&nbsp;上一页
                            </c:when>
                            <c:otherwise>
                                <a href="<%=path%>/company/get.do?page=1">首页</a>
                                &nbsp;&nbsp;&nbsp;
                                <a href="<%=path%>/company/get.do?page=<c:out value="${pagebean.currentPage-1}" /> ">上一页</a>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${pagebean.currentPage==pagebean.totalPage}">
                                下一页&nbsp;&nbsp;&nbsp;尾页
                            </c:when>
                            <c:otherwise>
                                <a href="<%=path%>/company/get.do?page=<c:out value="${pagebean.currentPage+1}" />">下一页</a>
                                &nbsp;&nbsp;&nbsp;
                                <a href="<%=path%>/company/get.do?page=${pagebean.totalPage}">尾页</a>
                            </c:otherwise>
                        </c:choose>
                        <p style="display: inline-block;">
                        <form action="<%=path%>/company/get.do?page" size="2" onclick="return validate(this)">
                            跳转到&nbsp;<input type="text" name="page" style="width:40px;height: 20px;display: inline-block">&nbsp;页面
                            <input type="submit" value="go" style="display: inline-block" onclick="return validate(this)">
                        </form>

                    </p>
                </div>
            </div>
        </div>
</body>
</html>
