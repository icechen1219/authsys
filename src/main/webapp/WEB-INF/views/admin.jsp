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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/easyui/default/easyui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/easyui/icon.css">
    <script src="${pageContext.request.contextPath}/static/plugins/jquery/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/plugins/easyui/jquery.easyui.min.js"></script>
    <style>
        h3, h1 {
            margin: 5px 10px 0 0;
            padding: 0;
        }
    </style>
    <script>
        $(function () {
            $(".easyui-tree").tree({
                url: '${pageContext.request.contextPath}/menuTree',
                onLoadSuccess: function (node, data) {
                    console.log(data);
                },
                onDblClick: function (node) {
                    $(this).tree("toggle", node.target);
                },
                onClick: function (node) {
                    if (node.attributes && node.attributes.url) {
                        alert(node.attributes.url);
                        opentabs(node.text, '${pageContext.request.contextPath}' + node.attributes.url)
                    }
                }
            })
        })

        function opentabs(title, url) {
            if ($('.easyui-tabs').tabs('exists', title)) {
                $('.easyui-tabs').tabs('select', title)
            } else {
                $('.easyui-tabs').tabs('add', {
                    title: title,
                    href: url,
                    closable: true,

                });
            }
        }
    </script>
</head>
<body class="easyui-layout">
<div data-options="region:'north'" style="height:80px;text-align: right;line-height: 30px;overflow: hidden;">
    <h1>基础权限管理系统</h1>
    <h3>欢迎：${sessionScope.loginUser.username}</h3>
</div>
<div data-options="region:'west',split:true" title="导航栏" style="width:200px;">
    <div class="easyui-accordion" data-options="fit:true,border:false">
        <div class="easyui-tree" data-options="animate:true,dnd:true"></div>
    </div>
</div>
<div data-options="region:'center'">
    <div class="easyui-tabs" data-options="fit:true,border:false,plain:true">
        <div title="About" data-options="content:'easyui演示程序'" style="padding:10px"></div>
    </div>
</div>
</body>
</html>
