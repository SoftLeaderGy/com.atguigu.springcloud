package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/08/06/10:51
 */
@Configuration
public class MySelfrule {

    /**
     * 想修改Ribbon的轮询策略，就新建个配置类，并且此配置类不能放在被@ComponentScan注解扫描到的地方
     * 也就是说  不能和主启动类包或其子包下。
     * @return
     */
    @Bean
    public IRule myRule(){

        return new RandomRule(); // 自定义随意
    }
}
