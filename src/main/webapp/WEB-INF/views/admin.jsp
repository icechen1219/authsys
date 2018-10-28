<%--
  Created by IntelliJ IDEA.
  User: icechen1219
  Date: 2018/10/25
  Time: 下午7:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基础权限管理系统</title>
</head>
<body>
<h1>欢迎：${sessionScope.loginUser.username} 登录成功!</h1>
<h3>恭喜：${requestScope.loginUser.username} 注册成功！</h3>
</body>
</html>
