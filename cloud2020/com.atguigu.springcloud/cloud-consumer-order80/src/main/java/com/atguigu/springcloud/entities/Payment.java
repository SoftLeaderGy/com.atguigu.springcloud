package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/08/04/11:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// 实现Serializable 后期微服务可能用到序列化
public class Payment implements Serializable {

    private Long id;
    private String serial;

}
