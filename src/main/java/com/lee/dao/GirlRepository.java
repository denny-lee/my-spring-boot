package com.lee.dao;

import com.lee.entity.GirlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GirlRepository extends JpaRepository<GirlEntity, Integer>,
        JpaSpecificationExecutor<GirlEntity> {

}
