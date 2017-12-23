<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/23
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <h2>用户登录</h2>
    <a href="${pageContext.request.contextPath}/pages/user/registerUser.jsp">注册新用户</a>
    <s:form action="userAction_doLogin" method="post">
        <table>
            <tr>
                <td>用户名:</td>
                <td><s:textfield name="user.name"/></td>
            </tr>
            <tr>
                <td>密  码:</td>
                <td><s:textfield name="user.password"/></td>
            </tr>
            <tr>
                <td colspan="2"><s:submit value="登录"/></td>
            </tr>
        </table>
    </s:form>
</body>
</html>
