package com.atguigu.springcloud.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/08/08/12:24
 */
@Service
public class paymentService {
    /**
     * 正常访问，肯定ok
     * @param id
     * @return
     */
    public String paymentInfo_ok(Integer id){
        return "线程池： " + Thread.currentThread().getName() + "paymentInfo_ok,id: " + id +"\t"+ "哈哈";
    }


    /**
     * 访问会有问题
     * @param id
     * @return
     */
    @SneakyThrows
    public String paymentInfo_Timeout(Integer id){

        int timeNumber = 3;
        TimeUnit.SECONDS.sleep(timeNumber);
        return "线程池： " + Thread.currentThread().getName() + "paymentInfo_Timeout,id: " + id +"\t"+ "哈哈" + "耗时+"+timeNumber+"秒种";
    }
}
