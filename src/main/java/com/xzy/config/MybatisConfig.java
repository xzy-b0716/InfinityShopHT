package com.xzy.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * 对Mybatis进行配配置，也可以在mybatis主配置文件中配置
 */
@org.springframework.context.annotation.Configuration
public class MybatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer() {

            @Override
            public void customize(Configuration configuration) {
                //设置适应数据库中字段的驼峰命名法
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
