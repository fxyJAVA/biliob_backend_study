package com.yxf.biliob_backendf_v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class BiliobBackendfV2Application {

    public static void main(String[] args) {
        SpringApplication.run(BiliobBackendfV2Application.class, args);
    }

}
