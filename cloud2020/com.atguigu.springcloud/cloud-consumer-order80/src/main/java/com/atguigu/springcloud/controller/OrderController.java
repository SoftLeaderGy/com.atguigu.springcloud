package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/08/04/11:42
 */
@RestController
@Slf4j
public class OrderController {


    // 定义要调用的服务地址
    private static final String PAYMENT_URL = "http://localhost:8001";

    // 注入restTemplate
    @Resource
    private RestTemplate restTemplate;

    // 客户端应该是以Get请求
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@Param("serial") String serial){
        log.info(serial);
        Payment payment = new Payment();
        payment.setSerial(serial);
        // restTemplate调用postForObject方法需要传入三个参数，需要调用的服务地址、参数、需要转换的类型
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL+"payment/get/"+id,CommonResult.class);
    }

}
