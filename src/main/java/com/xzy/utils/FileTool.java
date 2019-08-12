package com.xzy.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传工具类
 *
 * @author shixiao
 * @date 2019/8/4 - 22:03
 */
public class FileTool {

    /**
     * 图片上传
     *
     * @param file
     * @param filePath
     * @param fileName
     * @throws IOException
     */
    public static void uploadFiles(byte[] file, String filePath, String fileName) throws IOException {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    /**
     * 创建新的文件名称
     *
     * @param fileName
     * @return
     */
    public static String renameToUUID(String fileName) {
        return UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}
