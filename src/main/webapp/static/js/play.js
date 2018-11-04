/*
  Created by IntelliJ IDEA.
  User: icechen1219
  Date: 2018/11/04
  Time: 下午7:27
  To change this template use File | Settings | File Templates.
*/
var player;
$(function () {
    console.log("play.js loaded...");
    reloadVideo();
})

function reloadVideo() {
    player && player.dispose();

    player = videojs('example_video_1', {fluid: true, autoplay: false}, function () {
        console.log('Good to go!');
        player.play();
    });

    player.on('play', function () {
        console.log('开始/恢复播放');
    });
    player.on('pause', function () {
        console.log('暂停播放');
    });
    player.on('ended', function () {
        console.log('结束播放');
    });

}