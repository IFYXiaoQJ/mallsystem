<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/26
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>用户基本信息</title>
</head>
<body>
    <div style="width: 100%; height: 80px;">
        <div style="float: right;">
            当前用户:${loginUser.name},钱包:${loginUser.money}<br/>
            <a href="shoppingCarAction_doFindShoppingCarForPage?pageBean.cpage=1">我的购物车</a><br/>
            <a href="">我的订单</a><br/>
        </div>
    </div>
</body>
</html>
