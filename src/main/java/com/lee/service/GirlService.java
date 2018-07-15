package com.lee.service;

import com.lee.entity.GirlEntity;
import com.lee.model.CountPojo;
import com.lee.model.Girl;

import java.util.List;
import java.util.Map;

public interface GirlService {
    void save(Girl girl);

    void saveOrUpdate(GirlEntity girlEntity);

    List<GirlEntity> query(GirlEntity girlEntity);

    int updateSpec(Integer oldAge, Integer newAge, String name);

    List<GirlEntity> queryByNickName(String nickName);

    List<CountPojo> queryNative();
}
