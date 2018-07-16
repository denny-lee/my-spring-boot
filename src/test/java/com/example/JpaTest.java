package com.example;

import com.lee.Application;
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
public class JpaTest {
	private static final Logger log = LoggerFactory.getLogger(JpaTest.class);


	@Autowired
	private GirlService girlService;

	@Test
	public void test1() {
		girlService.updateSpec(18, 19, "Mary");
	}

	@Test
	public void test2() {
		GirlEntity entity = new GirlEntity();
		entity.setId(10);
		entity.setAge(18);
		entity.setName("Alice");
		entity.setNickName("Ali");
		girlService.saveOrUpdate(entity);
	}

	@Test
	public void test3() {
		List<GirlEntity> list = girlService.queryByNickName("Mary");
		log.info("mary : {}", list);
	}

}
