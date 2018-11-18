package com.cqgcxy.authsys.web;

import com.cqgcxy.authsys.domain.CourseWareDO;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author icechen1219
 * @date 2018/11/04
 */
@Controller
public class WareManagerController {
    private static final int MAX_FILE_SIZE = 5 * 1024 * 1024;
    private static final String[] VIDEO_SUFFIX = {
            "mp4", "avi", "3gp", "mkv", "wmv", "flv", "mov", "webm", "ogv"
    };
    private Logger logger = LoggerFactory.getLogger(WareManagerController.class);

    @RequestMapping("/wareManager")
    public String gotoWareList() {
        return "wareList";
    }

    @RequestMapping(value = "/addWare", method = RequestMethod.GET)
    public String gotoUploadWare() {
        return "uploadWare";
    }

    @RequestMapping("/warePlay")
    public String gotoWatchWare() {
        return "warePlay";
    }

    @RequestMapping(value = "/addWare", method = RequestMethod.POST)
    @ResponseBody
    public String addWare(CourseWareDO ware, @RequestParam(required = false) MultipartFile warefile, HttpServletRequest request) {
        if (warefile != null && !warefile.isEmpty()) {
            String uploadPath = request.getServletContext().getRealPath("static" + File.separator + "videos");
            logger.debug("upload path===========>" + uploadPath);
            String oldFileName = warefile.getOriginalFilename();
            String suffix = FilenameUtils.getExtension(oldFileName);
            if (!fileAccept(suffix)) {
                throw new RuntimeException("不受支持的文件格式！\n目前只能上传以下格式：\n" + StringUtils.join(VIDEO_SUFFIX, '/'));
            }
            long size = warefile.getSize();
            if (size > MAX_FILE_SIZE) {
                throw new RuntimeException("附件不能超过5M");
            }

            String newName = System.currentTimeMillis() / 1000 + RandomUtils.nextInt(1000000) + "." + suffix;
            logger.debug("upload filename===========>" + newName);
            File targetFile = new File(uploadPath, newName);
            // 确保文件上传的各级文件夹已存在
            boolean exist = targetFile.mkdirs();
            try {
                warefile.transferTo(targetFile);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
            logger.debug("relative path======>" + (uploadPath + File.separator + newName));
            return uploadPath + File.separator + newName;
        }

        throw new RuntimeException("文件为空");
    }

    private boolean fileAccept(String suffix) {
        for (String accept : VIDEO_SUFFIX) {
            if (accept.equalsIgnoreCase(suffix)) {
                return true;
            }
        }
        return false;
    }
}
