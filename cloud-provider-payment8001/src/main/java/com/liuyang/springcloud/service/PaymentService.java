package com.liuyang.springcloud.service;

import com.liuyang.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author: LiuYang | LeonWillow | lanwu114
 * @date: 2020-06-28
 * @des:
 */
public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
