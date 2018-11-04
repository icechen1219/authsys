<%--
  Created by IntelliJ IDEA.
  User: icechen1219
  Date: 2018/11/04
  Time: 上午10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="easyui-layout" data-options="fit:true,border:false" id="ware-list">
    <div data-options="region:'north',collapsible:false" title="课件列表" style="height: 12%;">
        <div class="easyui-panel" data-options="border:false" id="ware-op-btn"
             style="padding: 5px; background-color: #F2F2F2">
            <a href="#" class="easyui-linkbutton" id="refresh" data-options="plain:true,iconCls:'icon-reload'">刷 新</a>
            <span class="btn-separator"></span>
            <a href="#" class="easyui-linkbutton" id="add" data-options="plain:true,iconCls:'icon-add'" onclick="addjs('/static/js/ware.js')">新 增</a>
            <span class="btn-separator"></span>
            <input name="wareName" class="easyui-textbox" data-options="prompt:'视频名称'">
            <a href="#" class="easyui-linkbutton" id="search" data-options="plain:true,iconCls:'icon-search'">检 索</a>
        </div>
    </div>
</div>
</body>
</html>
