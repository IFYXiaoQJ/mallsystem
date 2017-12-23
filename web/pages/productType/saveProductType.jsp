<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/23
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>新增商品类型</title>
</head>
<body>
    <h2>新增商品类型</h2>
    <s:form action="productTypeAction_doSaveProductType" method="post">
        <table>
            <tr>
                <td>商品类型名称:</td>
                <td><s:textfield name="productType.name"/></td>
            </tr>
            <tr>
                <td colspan="2"><s:submit value="新增"/></td>
            </tr>
        </table>
    </s:form>
</body>
</html>
