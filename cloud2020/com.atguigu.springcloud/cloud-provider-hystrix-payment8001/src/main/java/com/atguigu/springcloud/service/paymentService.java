package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
     *
     * @param id
     * @return
     */
    @SneakyThrows
    //@HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler")
    // 表示服务降级，方法：paymentInfo_Timeout 出事了不会继续等待，而是执行fallbackMethod里边的 "paymentInfo_TimeoutHandler"方法
    // 也就是说添加了@HystrixCommand以后如果别添加的方法出事了会找fallbackMethod里边配置的方法进行"兜底"
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000") //设置服务调用超时时间的峰值，为3秒钟，如果超时时间大于3秒就会进行服务熔断。
    })
    public String paymentInfo_Timeout(Integer id){

        /**
         * 模拟调用超时，进行服务熔断
         */
//        int timeNumber = 5; // 延时5秒种
//        TimeUnit.SECONDS.sleep(timeNumber);
//        return "线程池： " + Thread.currentThread().getName() + "paymentInfo_Timeout,id: " + id +"\t"+ "哈哈" + "耗时+"+timeNumber+"秒种";

        /**
         * 模拟服务报错，进行服务降级
         */
        int a = 10/0;
        return "线程池： " + Thread.currentThread().getName() + "paymentInfo_Timeout,id: " + id +"\t"+ "哈哈";
    }

    /**
     * 服务熔断后执行的方法（兜底方法）
     * @param id
     * @return
     */
    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池： " + Thread.currentThread().getName() + "paymentInfo_Timeout,id: " + id +"运行超时或者服务运行报错，请稍后在试"+"\t"+ "哭～～";
    }
}
