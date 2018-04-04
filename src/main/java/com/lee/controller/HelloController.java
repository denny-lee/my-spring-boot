package com.lee.controller;

import com.lee.dao.GirlRepository;
import com.lee.entity.GirlEntity;
import com.lee.model.Girl;
import com.lee.model.ResponseData;
import com.lee.service.GirlService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	@Autowired
	private GirlService girlService;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private GirlRepository girlRepository;

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping("/add.json")
	@ResponseBody
	public ResponseData save(@RequestBody Girl girl, @RequestHeader("tk") String tk, Girl g) {
		/*try {
			girlService.save(girl);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		System.out.println("save----------------{}" + g.getAge());
		return new ResponseData(1, "bingo");
	}

	@RequestMapping(value = "/aa.json", method = RequestMethod.POST)
	@ResponseBody
	public String save1(@RequestParam("route") String route) {
		if (StringUtils.isBlank(route)) {
			route = "good";
		}
		System.out.println("--------------"+route);
		rabbitTemplate.convertAndSend("msgInform", route, "hera comes a message");
		return "{\"result\":\"ok\"}";
	}

	@RequestMapping(value = "/aaa.json", method = RequestMethod.POST)
	@ResponseBody
	public String save2(@Valid @RequestBody Girl girl) {
		System.out.println("--------------"+girl);
		return "{\"result\":\"ok\"}";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public Object test(@RequestParam(value = "name") String name, @RequestParam(value = "age") Integer age, @RequestParam(value = "nickName") String nickName) {
		PageRequest pageRequest = new PageRequest(0,
				10);
		Page<GirlEntity> page = girlRepository.findAll(getSpecification(name, nickName, age), pageRequest);
//		List<GirlEntity> page = girlRepository.findAll();

//		System.out.println("--------------"+girl);
		return page;
	}

	/*@RequestMapping(value = "/400", method = RequestMethod.POST)
	@ResponseBody
	public String error400() {
		System.out.println("----400----------");
		return "{\"result\":\"ok\"}";
	}*/

	private Specification<GirlEntity> getSpecification(final String name, final String nickName, final Integer age) {
		return (Root<GirlEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
			Predicate p1 = cb.equal(root.get("name").as(String.class), name);
			Predicate p2 = cb.equal(root.get("nickName").as(String.class), nickName);
			Predicate p3 = cb.equal(root.get("age").as(Integer.class), age);
			Predicate p = cb.or(cb.and(p1, p3), cb.and(p2, p3));
			return query.where(p).getRestriction();
		};
	}

}
