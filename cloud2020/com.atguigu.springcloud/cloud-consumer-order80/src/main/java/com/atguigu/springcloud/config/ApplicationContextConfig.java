package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/08/04/11:46
 */
@Configuration
public class ApplicationContextConfig {

    //在单机环境中，不需要添加，因为就一台机器
    // 在集群环境当中，需要给RestTemplate添加负载均衡功能，才能保证在eureka中找到注册的服务名下的那个服务。

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
