package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Value("${server.port}")
    private String serverPort;

//   将DiscoveryClient注入到spring中，就可以获取服务中的信息
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = payMentService.create(payment);
        if(result > 0){
            return new CommonResult(200,"插入数据库成功,serverPort:"+serverPort,result);

        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){
        Payment payment = payMentService.getPaymentById(id);
        if(payment != null) {
            return new CommonResult(200,"查询成功,serverPort:"+serverPort,payment);

        }else {
            return new CommonResult(444,"没有查询记录，查询ID:"+id,null);

        }
    }


    @GetMapping("/payment/discovery")
    public Object getDiscovery(){

        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info(service);

        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getHost(),instance.getHost(),instance.getUri());
        }
        return this.discoveryClient;

    }


    // 测试feign调用超时
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return serverPort;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

}
