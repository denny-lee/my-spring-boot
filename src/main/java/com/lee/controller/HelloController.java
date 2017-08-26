package com.lee.controller;

import com.lee.model.Girl;
import com.lee.model.ResponseData;
import com.lee.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController {

	@Autowired
	private GirlService girlService;

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	@RequestMapping("/add.json")
	@ResponseBody
	public ResponseData save(Girl girl) {
		try {
			girlService.save(girl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseData(1, "bingo");
	}
}
