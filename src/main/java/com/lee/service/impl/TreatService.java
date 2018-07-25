package com.lee.service.impl;

import com.lee.dao.ChoiseRepository;
import com.lee.dao.GuyRepository;
import com.lee.dao.OptionRepository;
import com.lee.entity.ChoiseEntity;
import com.lee.entity.GuyEntity;
import com.lee.entity.OptionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class TreatService {

    @Autowired
    private GuyRepository guyRepository;
    @Autowired
    private ChoiseRepository choiseRepository;
    @Autowired
    private OptionRepository optionRepository;

    public List<GuyEntity> fetchByName(String name) {
        return guyRepository.findAllByNameLike(name+"%");
    }

    public GuyEntity getGuy(Integer id) {
        return guyRepository.findOne(id);
    }

    public OptionEntity getOption(Integer id) {
        return optionRepository.findOne(id);
    }

    public void addChoise(ChoiseEntity c) {
        guyRepository.updateTimesById(c.getUid());
        choiseRepository.deleteByName(c.getUid());
        c.setCreateTime(new Date());
        choiseRepository.save(c);

    }

    public void reject(Integer id) {
        choiseRepository.deleteById(id);
    }

    public ChoiseEntity queryByUserId(Integer uid) {
        return choiseRepository.findFirstByUidAndDelFlagFalseOrderByCreateTimeDesc(uid);
    }

    public void save(ChoiseEntity c) {
        choiseRepository.save(c);
    }

    public List<ChoiseEntity> listAll() {
        return choiseRepository.findAllByDelFlagFalse();
    }
}
