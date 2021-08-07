package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/08/07/23:47
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevle(){
        // FULL最详细的日志。
        return Logger.Level.FULL;
    }
}
