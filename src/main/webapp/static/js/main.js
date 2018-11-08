/*
  Created by IntelliJ IDEA.
  User: icechen1219
  Date: 2018/11/04
  Time: 上午10:58
  To change this template use File | Settings | File Templates.
*/
var contextPath;

$(function () {
    console.log("main.js loading...")
})

function initPath(realPath) {
    contextPath = realPath;
    $.ajax({
        url: contextPath+"/menuTree",
        type: "get",
        dataType: "json",
        success: function (data) {
            console.log(data);
            // $.parser.parse()
            data.map(function (value, index, array) {
                // 添加一级菜单，使用手风琴效果
                $("#navtree").accordion("add", {
                    title: value.text,
                    content: '<ul id="second-tree' + value.id + '" class="easyui-tree" data-options="animate:true,lines:false"></ul>',
                    selected: false
                })
                // 添加二级菜单，使用默认tree效果
                $("#second-tree" + value.id).tree({
                    data: value.children,
                })
            })
            addTreeListener();
            killTreeIcons();
        },
        error: function (res) {
            console.log(res);
        }

    })
}

$.parser.onComplete = function () {
    // 获取选中的标签页面板（tab panel）和它的标签页（tab）对象
    var pp = $('.easyui-tabs').tabs('getSelected');
    var activeTab = pp&&pp.panel('options').tab; // 相应的标签页（tab）对象
    var videoDiv = $(".video-js");
    if (videoDiv.length !=0 && activeTab&&activeTab[0].textContent=='课件学习') {
        console.log("video page loading...");
        $.getScript(contextPath + "/static/js/play.js");
    }
}


function opentabs(title, url) {
    if ($('.easyui-tabs').tabs('exists', title)) {
        $('.easyui-tabs').tabs('select', title)
    } else {
        $('.easyui-tabs').tabs('add', {
            title: title,
            href: url,
            closable: true,
            selected: true,
        });
    }
}

/**
 * 打开对话框
 * @param $obj 对话框对象
 * @param title 标题
 * @param width 宽度
 * @param height 高度
 * @param href    远程url
 * @param callfn   保存的回调函数
 * @returns
 */
function opendlg($obj, title, width, height, href, callfn) {
    $obj.dialog({
        title: title,
        width: width,
        height: height,
        cache: false,
        href: contextPath + href,
        modal: true,
        buttons: [{
            text: '保存',
            iconCls: 'icon-ok',
            handler: function () {
                callfn();
            }
        }, {
            text: '关闭',
            iconCls: 'icon-cancel',
            handler: function () {
                $obj.dialog('close');
            }
        }]
    });
}

function getDialog() {
    var $dlg = $("#ware-list #dlg");
    console.log($dlg.length)
    if ($dlg.length == 0) {
        $("#ware-list").append("<div id='dlg'></div>");
        $dlg = $("#ware-list #dlg");

    }
    return $dlg;
}

function addjs(jsfile) {
    $.getScript(contextPath + jsfile);
}

function addTreeListener() {
    $(".easyui-tree").tree({
        onLoadSuccess: function (node, data) {
            console.log(data);
        },
        onDblClick: function (node) {
            $(this).tree("toggle", node.target);
        },
        onClick: function (node) {
            if (node.attributes && node.attributes.url) {
                console.log(node.attributes.url);
                opentabs(node.text, contextPath + node.attributes.url)
            }
        },
        onExpand: function (node) {
            $('.tree-title').prev().removeClass("tree-folder-open");
            $('.tree-checkbox,.tree-checkbox0').prev().removeClass("tree-folder-open");
        }
    })
}

function killTreeIcons() {
    $(".tree-icon,.tree-file").removeClass("tree-icon tree-file");
    $(".tree-icon,.tree-folder").removeClass("tree-icon tree-folder tree-folder-open tree-folder-closed");
}
