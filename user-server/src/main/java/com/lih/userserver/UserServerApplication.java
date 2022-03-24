package com.lih.userserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//开启服务注册  被注册中心发现    该注解只是用于所有注册中心
//@EnableDiscoveryClient
//开启服务注册  被注册中心发现    该注解只是用于euerka注册中心
@EnableEurekaClient
@EnableWebMvc
@EnableSwagger2
@MapperScan("com.lih.userserver.mapper")
public class UserServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServerApplication.class, args);
    }

}
