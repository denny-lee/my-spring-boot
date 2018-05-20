package com.lee.service;

import com.lee.entity.GirlEntity;
import com.lee.model.Girl;

import java.util.List;

public interface GirlService {
    void save(Girl girl);

    void saveOrUpdate(GirlEntity girlEntity);

    List<GirlEntity> query(GirlEntity girlEntity);

    int updateSpec(Integer oldAge, Integer newAge, String name);

    List<GirlEntity> queryByNickName(String nickName);
}
