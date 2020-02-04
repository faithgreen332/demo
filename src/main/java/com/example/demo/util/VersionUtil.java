package com.example.demo.util;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;

/**
 * @author lijinfei
 * @Desc
 * @date 2020/2/4 11:50 Version: 1.0
 */
public class VersionUtil {
    public static void main(String[] args) {
        String version = SpringBootVersion.getVersion();
        System.out.println(version);
        String implementationVersion = SpringApplication.class.getPackage().getImplementationVersion();
        System.out.println(implementationVersion);
    }
}
