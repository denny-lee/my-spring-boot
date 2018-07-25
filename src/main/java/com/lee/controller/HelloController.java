package com.lee.controller;

import com.lee.SignUtil;
import com.lee.entity.ChoiseEntity;
import com.lee.entity.GuyEntity;
import com.lee.entity.OptionEntity;
import com.lee.pojo.UserInfo;
import com.lee.service.impl.TreatService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;

@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private TreatService treatService;

    @GetMapping("/user")
    public Object fetchUser(@RequestParam("name") String name) {
        if (StringUtils.isBlank(name)) {
            return new ArrayList<>();
        }
        return treatService.fetchByName(name);
    }

    @GetMapping("/choosen")
    public Object choosen(@RequestParam("uid") Integer uid, @RequestParam("key") Long key) {
        GuyEntity user = treatService.getGuy(uid);
        if (null == user) {
            return "user 不能为空";
        }
        int[] keyArr = SignUtil.decode(key.intValue());
        int date = Calendar.getInstance().get(Calendar.DATE);
        if (null != keyArr) {
            logger.info("cid:{}, dt:{}, uid:{}", keyArr[0], keyArr[1], keyArr[2]);
            logger.info("date:{}", date);
        }
        if (null == keyArr || uid != keyArr[2] || date != keyArr[1]) {
            return "参数错误";
        }
        int cid = keyArr[0];
        OptionEntity op = treatService.getOption(cid);
        if (null == op) {
            return "无此选项";
        }
        ChoiseEntity c = new ChoiseEntity();
        c.setCid(cid);
        c.setDescription(op.getDescription());
        c.setUid(uid);
        c.setName(user.getName());
        treatService.addChoise(c);

        return "ok:"+c.getId();
    }

    @GetMapping("/reject")
    public Object reject(@RequestParam("key") Long key) {
        int[] keyArr = SignUtil.decode(key.intValue());
        int date = Calendar.getInstance().get(Calendar.DATE);

        if (null != keyArr) {
            logger.info("cid:{}, dt:{}, uid:{}", keyArr[0], keyArr[1], keyArr[2]);
            logger.info("date:{}", date);
        }
        if (null == keyArr || date != keyArr[1]) {
            return "参数错误";
        }
        int id = keyArr[0];
        treatService.reject(id);
        return "ok";
    }

    @GetMapping("/initState")
    public Object initState(@RequestParam("uid") Integer uid) {
        if (null == uid) {
            return "user 不存在";
        }
        GuyEntity g = treatService.getGuy(uid);
        ChoiseEntity c = treatService.queryByUserId(uid);
        if (null == g) {
            return "user 不存在";
        }
        if (null == c) {
            return new UserInfo(g.getTimes(), null, "");
        }
        return new UserInfo(g.getTimes(), c.getId(), c.getDescription());
    }

    @GetMapping("/listAll")
    public Object listAll() {
        return treatService.listAll();
    }

    @GetMapping("/taste")
    public Object taste(@RequestParam("uid") Integer uid, @RequestParam("taste") String taste) {
        ChoiseEntity cc = treatService.queryByUserId(uid);
        if (null == cc) {
            GuyEntity user = treatService.getGuy(uid);
            if (null == user) {
                return "user 不能为空";
            }
            ChoiseEntity c = new ChoiseEntity();
            c.setCid(2);
            c.setDescription("请你喝一点点奶茶");
            c.setUid(uid);
            c.setName(user.getName());
            c.setRemark(taste);
            treatService.addChoise(c);
        } else {
            cc.setRemark(taste);
            treatService.save(cc);
        }
        return "ok";
    }

}
