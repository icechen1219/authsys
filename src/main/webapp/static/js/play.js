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
    // 为了避免反复打开标签页导致videojs对象重复创建，所以先销毁它
    player && player.dispose();

    player = videojs('example_video_1', {
        fluid: true,
        autoplay: true,
        techOrder: ["html5"],
        bigPlayButton: true,
        textTrackDisplay: false,
        posterImage: false,
        errorDisplay: false,
        controlBar: {
            captionsButton: false,
            chaptersButton: false,
            playbackRateMenuButton: false,
            liveDisplay: false,
            subsCapsButton: false,
            remainingTimeDisplay: true,
            progressControl: true,
            volumePanel: {
                inline: false,
                volumeControl: {//竖着的音量条
                    vertical: true
                }
            },
            fullscreenToggle: true
        }
    }, function () {
        disableProgress();
        console.log('Good to go!');
        // player.play(); // 交给autoplay控制
        console.log("你已学习完：" + (localStorage.getItem("finishCount") || 0) + "次本视频。")

        // 监听帧更新事件，注意一定要放到ready事件中，否则在视频尚未加载完毕的时候也会触发该事件，导致获取当前时间始终为0
        player.on('timeupdate', function () {
            var lastpos = localStorage.getItem("lastpos") || 0;
            if (player.currentTime() - parseFloat(lastpos) > 1) {
                console.log('快进了，退回去...')
                player.currentTime(parseFloat(lastpos));
            } else{
                localStorage.setItem("lastpos", player.currentTime());
            }
        });
    });

    player.on('play', function () {
        console.log('开始/恢复播放');
        var lastpos = localStorage.getItem("lastpos") || 0;
        console.log("上次播放到：" + lastpos + "秒，为你恢复进度。");
        if (lastpos >= player.duration()) {
            lastpos = 0;
        }
        player.currentTime(lastpos);
    });

    player.on('pause', function () {
        console.log('暂停播放');
        localStorage.setItem("lastpos", player.currentTime());
    });

    player.on('ended', function () {
        console.log('结束播放');
        var finishCount = localStorage.getItem("finishCount") || 0;
        localStorage.setItem("finishCount", parseInt(finishCount) + 1);
    });

    // 屏蔽视频上右键，避免用户直接下载视频
    jQuery("#example_video_1").on("contextmenu", function () {
        return false;
    });
}

/**
 * 监听视频网页退出事件，记录网页退出时的播放时间
 */
window.onunload = function () {
    localStorage.setItem("lastpos", player.currentTime());
}

/**
 * 禁用videojs的进度条点击事件
 */
function disableProgress() {
    // 取消大进度条的事件
    player.controlBar.progressControl.off("mousedown");
    player.controlBar.progressControl.off("mouseup");
    player.controlBar.progressControl.off("touchstart");
    player.controlBar.progressControl.off("touchend");
    player.controlBar.progressControl.off("click");

    // 取消小进度条的部分事件，保留单击和触摸事件
    // player.controlBar.progressControl.seekBar.off("mousedown");
    // player.controlBar.progressControl.seekBar.off("mouseup");
    player.controlBar.progressControl.seekBar.off("touchstart");
    player.controlBar.progressControl.seekBar.off("touchend");
    player.controlBar.progressControl.seekBar.off("click");

    // player.controlBar.progressControl.seekBar.playProgressBar.off("mousedown");
    // player.controlBar.progressControl.seekBar.playProgressBar.off("mouseup");
    // player.controlBar.progressControl.seekBar.playProgressBar.off("touchstart");
    // player.controlBar.progressControl.seekBar.playProgressBar.off("touchend");
    // player.controlBar.progressControl.seekBar.playProgressBar.off("click");
}