package com.lee.controller;

import com.lee.RubicsCube;
import com.lee.pojo.Cube;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CubicController {
    private static final Logger logger = LoggerFactory.getLogger(CubicController.class);

    @PostMapping("/sovleCubic")
    public Object sovleCubic(@RequestBody List<Cube> cubes) {
        long time = System.currentTimeMillis();
        RubicsCube rc = new RubicsCube(cubes);
        rc.solve(-1);
        System.out.println("time cost:" + String.valueOf(System.currentTimeMillis() - time));
        return rc.printAnswer();
    }

}
