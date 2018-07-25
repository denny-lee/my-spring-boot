package com.example;

import com.lee.Application;
import com.lee.dao.GuyRepository;
import com.lee.dao.OptionRepository;
import com.lee.entity.GuyEntity;
import com.lee.entity.OptionEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=Application.class)
public class JpaTest {
	private static final Logger log = LoggerFactory.getLogger(JpaTest.class);


	@Autowired
	private OptionRepository optionRepository;
	@Autowired
	private GuyRepository guyRepository;
	@Test
	public void test1() {
		List<OptionEntity> list = new ArrayList<>();
		/*list.add(new OptionEntity("请你看一场电影"));
		list.add(new OptionEntity("请你喝一点点奶茶"));
		list.add(new OptionEntity("一起去玩桌游"));
		list.add(new OptionEntity("请你吃金拱门套餐"));
		list.add(new OptionEntity("请你喝星巴克"));
		list.add(new OptionEntity("送你钢管舞体验课一次"));*/
//		optionRepository.save(list);
	}

	@Test
	public void test2() {
		List<GuyEntity> list = new ArrayList<>();
		list.add(new GuyEntity("二狗", 1, 1));
		guyRepository.save(list);
	}

}
