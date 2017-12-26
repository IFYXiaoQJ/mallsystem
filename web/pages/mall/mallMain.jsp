<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/23
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<%@include file="/pages/user/userBaseInfo.jsp"%>
    <h2>商城主页</h2>
    <hr/>
    <h3>商品类型管理</h3>
    <a href="${pageContext.request.contextPath}/pages/productType/saveProductType.jsp">新增商品类型</a><br/>
    <a href="${pageContext.request.contextPath}/pages/productType/productTypeMain.jsp">商品类型列表</a>
    <hr/>
    <h3>商品管理</h3>
    <a href="productAction_toSaveProduct">新增商品</a><br/>
    <a href="${pageContext.request.contextPath}/pages/product/productMain.jsp">商品列表</a>
    <hr/>
</body>
</html>
