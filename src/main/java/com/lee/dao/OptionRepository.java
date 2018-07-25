package com.lee.dao;

import com.lee.entity.OptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OptionRepository extends JpaRepository<OptionEntity, Integer>,
        JpaSpecificationExecutor<OptionEntity> {

}