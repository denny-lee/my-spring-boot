package com.lee.dao;

import com.lee.entity.GuyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GuyRepository extends JpaRepository<GuyEntity, Integer>,
        JpaSpecificationExecutor<GuyEntity> {

    GuyEntity findFirstByName(String name);
}
