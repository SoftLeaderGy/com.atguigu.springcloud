package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/08/08/16:31
 */

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_ok(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_ok, 哭～～";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_Timeout, 哭～～";
    }
}
