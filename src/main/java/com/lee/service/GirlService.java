package com.lee.service;

import com.lee.entity.GirlEntity;
import com.lee.model.Girl;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface GirlService {
    void save(Girl girl);

    List<GirlEntity> query(GirlEntity girlEntity);

    int updateSpec(Integer oldAge, Integer newAge, String name);
}
