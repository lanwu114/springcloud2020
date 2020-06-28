package com.liuyang.springcloud.service.impl;

import com.liuyang.springcloud.dao.PaymentDao;
import com.liuyang.springcloud.entities.Payment;
import com.liuyang.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: LiuYang | LeonWillow | lanwu114
 * @date: 2020-06-28
 * @des:
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao pd;
    @Override
    public int create(Payment payment) {
        return pd.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return pd.getPaymentById(id);
    }
}
