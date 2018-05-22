package com.lee.entity;

import javax.persistence.*;

/**
 * @author : Liw
 * @description :
 * @date : 2018/4/4 10:41
 */
@Entity
@Table(name = "t_order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "user_id")
    private Integer userId;
    private String goodsName;

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", userId=" + userId +
                ", goodsName='" + goodsName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
