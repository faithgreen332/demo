package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author faith
 */
@MapperScan("com.example.demo.dao")
@SpringBootApplication
@ImportResource(locations = {"classpath:druidBeans.xml"})
public class DemoApplication {
    public static void main(String[] args) {
//        System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow", "|{}");
        SpringApplication.run(DemoApplication.class, args);
    }
}
