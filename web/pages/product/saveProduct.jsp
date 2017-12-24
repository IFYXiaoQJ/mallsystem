<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/24
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>新增商品</title>
</head>
<body>
    <h2>新增商品</h2>
    <s:form action="productAction_doSaveProduct" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>商品图片:</td>
                <td><s:file name="productImg" accept="image/png,image/jpg,image/jpeg"/></td>
            </tr>
            <tr>
                <td>商品类型:</td>
                <td><s:select name="product.productType.no" list="%{productTypeList}" headerKey="" headerValue="请选择" listKey="no" listValue="name"/></td>
            </tr>
            <tr>
                <td>商品名称:</td>
                <td><s:textfield name="product.name"/></td>
            </tr>
            <tr>
                <td>公司名称:</td>
                <td><s:textfield name="product.company"/></td>
            </tr>
            <tr>
                <td>数量:</td>
                <td><s:textfield name="product.total"/></td>
            </tr>
            <tr>
                <td>价格(单件):</td>
                <td><s:textfield name="product.price"/></td>
            </tr>
            <tr>
                <td>是否有优惠</td>
                <td><s:radio list="#{'1':'有','0':'无'}" name="product.discounts" value="%{'0'}"/></td>
            </tr>
            <tr>
                <td>详细信息:</td>
                <td><s:textfield name="product.info"/></td>
            </tr>
            <tr>
                <td>生产地址:</td>
                <td><s:textfield name="product.address"/></td>
            </tr>
            <tr>
                <td><s:reset value="重置"/></td>
                <td><s:submit value="新增"/></td>
            </tr>
        </table>
    </s:form>
</body>
</html>
