<%--
  Created by IntelliJ IDEA.
  User: icechen1219
  Date: 2018/11/04
  Time: 上午9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/addWare" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>视频名称：</td>
            <td><input type="text" name="wareName"></td>
        </tr>
        <tr>
            <td>视频时长：</td>
            <td><input type="text" name="duration"></td>
        </tr>
        <tr>
            <td>请选择视频：</td>
            <td><input type="file" name="warefile"></td>
        </tr>
        <tr>
            <td>视频简介：</td>
            <td><textarea name="remark" id="remark" cols="18" rows="5"></textarea></td>
        </tr>
    </table>
</form>
</body>
</html>
