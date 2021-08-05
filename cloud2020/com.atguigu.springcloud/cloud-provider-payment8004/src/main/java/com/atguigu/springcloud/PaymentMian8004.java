package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/08/05/15:00
 */
@SpringBootApplication
@EnableDiscoveryClient  // 该注解用于向使用zookeeper作为注册中心时注册服务
public class PaymentMian8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMian8004.class,args);
    }
}
