package com.xzy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(value = "com.xzy.beans.cache")
@MapperScan(value = "com.xzy.mapper") //可以使用value也可以使用basePackages
@SpringBootApplication
public class InfintyshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfintyshopApplication.class, args);
    }

}
