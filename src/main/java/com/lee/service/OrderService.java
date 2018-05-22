package com.lee.service;

import com.lee.dao.OrderRepository;
import com.lee.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Liw
 * @description :
 * @date : 2018/5/22 17:20
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderEntity> query(Integer userId, Integer orderId) {
        return orderRepository.findAllByUserIdAndOrderId(userId, orderId);
    }

    public void save(OrderEntity entity) {
        orderRepository.save(entity);
    }
}
