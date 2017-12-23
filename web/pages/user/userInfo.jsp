<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/22
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>用户详细信息</title>
</head>
<body>
    <h2>完善用户详细信息</h2>
    <a href="">去到主页</a>
    <s:form action="userAction_doUpdateUserInfo" method="post">
        <table>
            <s:hidden name="userInfo.user.no" value="%{#session.loginUser.no}"/>
            <s:hidden name="userInfo.no" value="%{userInfo.no}"/>
            <tr>
                <td>真实姓名:</td>
                <td><s:textfield name="userInfo.realname" value="%{userInfo.realname}"/>(必填)</td>
            </tr>
            <tr>
                <td>性别:</td>
                <td><s:radio list="#{'1':'男','0':'女'}" name="userInfo.sex" value="%{userInfo.sex}"/></td>
            </tr>
            <tr>
                <td>年龄:</td>
                <td><s:textfield name="userInfo.age" value="%{userInfo.age}"/></td>
            </tr>
            <tr>
                <td>身份证:</td>
                <td><s:textfield name="userInfo.idcard" value="%{userInfo.idcard}"/>(必填)</td>
            </tr>
            <tr>
                <td>真实地址:</td>
                <td><s:textfield name="userInfo.address" value="%{userInfo.address}"/>(必填)</td>
            </tr>
            <tr>
                <td>邮政地址:</td>
                <td><s:textfield name="userInfo.postAddress" value="%{userInfo.postAddress}"/>(必填)</td>
            </tr>
            <tr>
                <td>联系电话1:</td>
                <td><s:textfield name="userInfo.tel1" value="%{userInfo.tel1}"/>(必填)</td>
            </tr>
            <tr>
                <td>联系电话2:</td>
                <td><s:textfield name="userInfo.tel2" value="%{userInfo.tel2}"/>(可选)</td>
            </tr>
            <tr>
                <td><s:reset value="重置"/></td>
                <td><s:submit value="修改"/></td>
            </tr>
        </table>
    </s:form>
</body>
</html>
