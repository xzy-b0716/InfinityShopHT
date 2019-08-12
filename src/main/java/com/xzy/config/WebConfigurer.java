package com.xzy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author shixiao
 * @date 2019/8/4 - 22:31
 */
@ComponentScan
@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {
    @Autowired
    PreReadUploadConfig uploadConfig;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("file:///" + uploadConfig.getUploadPath());
    }
}
