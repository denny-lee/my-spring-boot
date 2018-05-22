package com.lee.dao;

import com.lee.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer>,
        JpaSpecificationExecutor<OrderEntity> {

    List<OrderEntity> findAllByUserIdAndOrderId(Integer userId, Integer orderId);

}
