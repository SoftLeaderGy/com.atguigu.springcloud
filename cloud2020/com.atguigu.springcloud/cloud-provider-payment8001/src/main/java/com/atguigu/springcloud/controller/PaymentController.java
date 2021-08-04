package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/08/04/09:38
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PayMentService payMentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = payMentService.create(payment);
        if(result > 0){
            return new CommonResult(200,"插入数据库成功",result);

        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){
        Payment payment = payMentService.getPaymentById(id);
        if(payment != null) {
            return new CommonResult(200,"查询成功",payment);

        }else {
            return new CommonResult(444,"没有查询记录，查询ID:"+id,null);

        }
    }



}
