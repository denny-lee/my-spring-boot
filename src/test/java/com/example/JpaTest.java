package com.example;

import com.lee.Application;
import com.lee.service.GirlService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=Application.class)
public class JpaTest {
	private static final Logger log = LoggerFactory.getLogger(JpaTest.class);


	@Autowired
	private GirlService girlService;

	@Test
	public void test1() {
		girlService.updateSpec(18, 19, null);
	}

}
