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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css">
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
<div id="headnav" data-options="region:'north',border:false" style="height: 50px;">
    <div class="title">基础权限管理系统</div>
    <div class="theme">
        <span class="Gray" title="Gray">■</span>
        <span class="Metro" title="Metro">■</span>
        <span class="Black" title="Black">■</span>
        <span class="Bootstrap" title="Bootstrap">■</span>
        <span class="Material" title="Material">■</span>
        <span class="Default" title="Default">■</span>
        <div>
            <a href='#'>| 修改密码 |</a> <a href="${pageContext.request.contextPath}/">&nbsp;&nbsp; 重新登录 &nbsp;&nbsp;| </a>
        </div>
    </div>

</div>
<div data-options="region:'south'" style="height: 10px;"></div>
<div data-options="region:'west',split:true,iconCls:'icon-man'" title="当前用户:${sessionScope.loginUser.realName}"
     style="width:200px;">
    <div class="easyui-accordion" data-options="fit:true,border:false">
        <!--    动态添加导航树代码    -->
    </div>
</div>
<div data-options="region:'center'">
    <div class="easyui-tabs" data-options="fit:true,border:false,plain:true">
        <div title="About" data-options="content:'easyui演示程序'" style="padding:10px"></div>
    </div>
</div>
</body>
</html>
