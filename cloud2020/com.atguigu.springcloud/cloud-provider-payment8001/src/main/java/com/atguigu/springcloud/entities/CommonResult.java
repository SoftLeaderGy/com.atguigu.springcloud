package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 返回结果集
 * @Author: Yang.Guo
 * @Date: 2021/08/03/20:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T>{

    private Integer code;
    private String message;

    private T data;


    // 有参构造
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

}
