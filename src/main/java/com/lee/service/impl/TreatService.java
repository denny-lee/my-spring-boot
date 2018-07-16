package com.lee.service.impl;

import com.lee.dao.ChoiseRepository;
import com.lee.dao.GuyRepository;
import com.lee.dao.OptionRepository;
import com.lee.entity.ChoiseEntity;
import com.lee.entity.GuyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class TreatService {

    @Autowired
    private GuyRepository guyRepository;
    @Autowired
    private ChoiseRepository choiseRepository;
    @Autowired
    private OptionRepository optionRepository;

    public GuyEntity fetchByName(String name) {
        return guyRepository.findFirstByName(name);
    }

    public void addChoise(Integer uid, Integer cid) {

        choiseRepository.deleteByName(uid);
        ChoiseEntity c = new ChoiseEntity();
        c.setCid(cid);

        choiseRepository.save(c);

    }
}
