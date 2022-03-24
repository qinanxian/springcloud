package com.lih.articleservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Configuration 用于定义配置类，可替换XML配置文件，被注解的类内部包含一个或多个@Bean注解方法。
 */
@Configuration
public class BeanConfiguration {
    /**
     * @Bean注解用于告诉方法，产生一个Bean对象，然后这个Bean对象交给Spring管理。
     * (和xml配置中的bean标签的作用是一样的)
     * @return
     */
    @Bean
    @LoadBalanced//开启负载均衡器功能
    public RestTemplate restTemplate(){
        /**
         * 当我们需要远程调用一个 HTTP 接口时，我们经常会用到 RestTemplate 这个类。
         */
        return new RestTemplate();
    }

}
