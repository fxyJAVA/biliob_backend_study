package com.yxf.biliob_backendf_v2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Desc TODO
 * @Author fxy
 * @Date 2020/6/25 16:52
 **/
@Configuration
public class ServerConfig {

    @Bean
    public WebMvcConfigurer myConfigure() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .allowedHeaders("*")
                        .allowCredentials(true)
                        .maxAge(3600);
            }

            //todo
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
            }
        };
    }
}
