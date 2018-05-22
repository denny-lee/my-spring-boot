package com.example;

import com.lee.Application;
import com.lee.entity.GirlEntity;
import com.lee.entity.OrderEntity;
import com.lee.service.GirlService;
import com.lee.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=Application.class)
public class ShardingTest {
	private static final Logger log = LoggerFactory.getLogger(ShardingTest.class);


	@Autowired
	private OrderService orderService;

	@Test
	public void test1() {
		OrderEntity entity = new OrderEntity();
		entity.setOrderId(2);
		entity.setUserId(999);
		entity.setGoodsName("商品1，内裤");
		orderService.save(entity);

		OrderEntity entity1 = new OrderEntity();
		entity1.setOrderId(2);
		entity1.setUserId(888);
		entity1.setGoodsName("商品1，袜子");
		orderService.save(entity1);

		OrderEntity entity2 = new OrderEntity();
		entity2.setOrderId(3);
		entity2.setUserId(999);
		entity2.setGoodsName("商品1，bra");
		orderService.save(entity2);

		OrderEntity entity3 = new OrderEntity();
		entity3.setOrderId(3);
		entity3.setUserId(888);
		entity3.setGoodsName("商品1，wtf");
		orderService.save(entity3);
	}

	@Test
	public void test2() {
		System.out.println(orderService.query(999, 2));
		System.out.println(orderService.query(888, 2));
		System.out.println(orderService.query(999, 3));
		System.out.println(orderService.query(888, 3));
	}

}
