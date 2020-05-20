package com.sxg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

/**
 * springboot整合servlet方式一  filter  listener
 */

@SpringBootApplication
@ServletComponentScan //在springboot 启动时会扫描@webservlet，并将其实例化;
@MapperScan("com.sxg.dao") //用户扫描mybatis的mapper接口
@EnableCaching   //springboot  在启动时启动缓存
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
