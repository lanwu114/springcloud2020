package com.liuyang.springcloud.controller;

import com.liuyang.springcloud.common.CommonResult;
import com.liuyang.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: LiuYang | LeonWillow | lanwu114
 * @date: 2020-06-28
 * @des:
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;
    @PostMapping("/consumer")
    public CommonResult<Integer> create(Payment payment){
        CommonResult c = restTemplate.postForObject(PAYMENT_URL+"/payment",payment,CommonResult.class);
        log.info("成功"+c);
        return c;
    }

    @GetMapping("/consumer/{id}")
    public CommonResult getPayment(@PathVariable(value="id") Long id) {
        CommonResult c = restTemplate.getForObject(PAYMENT_URL+"/payment/"+id,CommonResult.class);
        if(c.getCode() == 200){
            log.info("成功"+c);
        }
        return c;
    }
}
