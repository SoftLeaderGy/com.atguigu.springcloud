package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/08/04/16:54
 */
@SpringBootApplication
// eureka有两个组件，一个是eurekaServer 一个是eurekaClient
// 理解：server相当一个软件园区，Client相当于在软件园一个一个的为其他客户提供的服务者
@EnableEurekaServer
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
