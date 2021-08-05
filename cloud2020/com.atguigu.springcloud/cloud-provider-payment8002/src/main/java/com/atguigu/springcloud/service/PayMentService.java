package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/08/04/09:34
 */
public interface PayMentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
