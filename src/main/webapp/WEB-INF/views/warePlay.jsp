<%--
  Created by IntelliJ IDEA.
  User: icechen1219
  Date: 2018/11/04
  Time: 下午7:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<video id="example_video_1" class="video-js vjs-default-skin vjs-big-play-centered" controls preload="none" width="640"
       height="264" poster="${pageContext.request.contextPath}/static/images/oceans.png">
    <source src="${pageContext.request.contextPath}/static/videos/oceans.mp4" type="video/mp4">
    <source src="${pageContext.request.contextPath}/static/videos/oceans.webm" type="video/webm">
    <source src="${pageContext.request.contextPath}/static/videos/oceans.ogv" type="video/ogg">
</video>
</body>
</html>
