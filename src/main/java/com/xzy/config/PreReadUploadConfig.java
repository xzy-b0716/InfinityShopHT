package com.xzy.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author shixiao
 * @date 2019/8/4 - 22:17
 */
@Component
@ConfigurationProperties(prefix = "preread")
public class PreReadUploadConfig {
    private String uploadPath;

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }
}
