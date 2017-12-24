<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/24
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>更新商品类型</title>
</head>
<body>
    <h2>更新商品类型</h2>
    <a href="${pageContext.request.contextPath}/pages/productType/productTypeMain.jsp">返回</a>
    <s:form action="productTypeAction_doUpdateProductType" method="post">
        <s:hidden name="productType.no" value="%{productType.no}"/>
        <table border="1">
            <tr>
                <td>商品类型名称:</td>
                <td><s:textfield name="productType.name" value="%{productType.name}"/></td>
            </tr>
            <tr>
                <td colspan="2"><s:submit value="更新"/></td>
            </tr>
        </table>
    </s:form>
</body>
</html>
