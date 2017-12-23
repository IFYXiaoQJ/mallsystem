<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/20
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="true" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>注册用户</title>
</head>
<body>
    <h2>注册用户</h2>
    <s:form action="userAction_doRegisterUser" method="post">
        <table>
            <tr>
                <td>用户名:</td>
                <td><s:textfield name="user.name"/>(必须字母开头,长度8-12位间)</td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><s:textfield name="user.password"/>(必须字母与数字结合,长度8-16位间)</td>
            </tr>
            <tr>
                <td><s:reset value="重置"/></td>
                <td><s:submit value="注册"/></td>
            </tr>
        </table>
    </s:form>
</body>
</html>
