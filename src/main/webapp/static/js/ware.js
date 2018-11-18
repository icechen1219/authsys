/*
  Created by IntelliJ IDEA.
  User: icechen1219
  Date: 2018/11/04
  Time: 下午6:01
  To change this template use File | Settings | File Templates.
*/
$(function () {
    console.log("ware.js loaded...");
    var dialog = getDialog();
    opendlg(dialog, '新增课件', "380", "350", contextPath+'/addWare', function () {
        uploadConfirm(dialog);
    });
});

function uploadConfirm($dlg) {
    var form = new FormData($('form')[0]);
    $.ajax({
        url: contextPath+'/addWare',
        type: 'post',
        data: form,
        processData: false,
        contentType: false,
        success: function (data) {
            console.log(data);
            $.messager.show({
                title: '提示',
                msg: data,
                timeout: 3000,
                showType: 'slide'
            });

            $dlg.dialog('close');
        },
        error: function (e) {
            alert('提交失败!\n'+e);
        }
    });

}