package com.liuyang.springcloud.controller;

import com.liuyang.springcloud.common.CommonResult;
import com.liuyang.springcloud.entities.Payment;
import com.liuyang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

/**
 * @author: LiuYang | LeonWillow | lanwu114
 * @date: 2020-06-28
 * @des:
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService ps;

    @PostMapping(value="/payment")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int result = ps.create(payment);
        log.info("********插入结果："+result);
        if(result > 0){
            return new CommonResult<>(200, "插入数据库成功", result);
        }else{
            return new CommonResult<>(500,"插入数据库失败",null);
        }
    }


    @GetMapping(value="/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable(value="id") Long id){
        Payment payment = ps.getPaymentById(id);
        log.info("********获取结果："+payment);
        if(payment != null){
            return new CommonResult<>(200, "查询数据成功", payment);
        }else{
            return new CommonResult<>(500,"查询数据失败:"+id,null);
        }
    }
}
