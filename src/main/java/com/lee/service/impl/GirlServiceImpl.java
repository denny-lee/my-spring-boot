package com.lee.service.impl;

import com.lee.dao.GirlMapper;
import com.lee.model.Girl;
import com.lee.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GirlServiceImpl implements GirlService {
//    @Autowired
//    private GirlMapper mapper;
    @Override
    public void save(Girl girl) {
        System.out.println("------=========---------");
//        mapper.save(girl);
    }
}
