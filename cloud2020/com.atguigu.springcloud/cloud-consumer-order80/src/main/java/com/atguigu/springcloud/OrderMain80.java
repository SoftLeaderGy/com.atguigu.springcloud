package com.atguigu.springcloud;

import com.atguigu.myrule.MySelfrule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/08/04/11:36
 */
@EnableEurekaClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfrule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
