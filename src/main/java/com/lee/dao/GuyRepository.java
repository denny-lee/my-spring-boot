package com.lee.dao;

import com.lee.entity.GuyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GuyRepository extends JpaRepository<GuyEntity, Integer>,
        JpaSpecificationExecutor<GuyEntity> {

    List<GuyEntity> findAllByNameLike(String name);

    @Modifying
    @Query("update #{#entityName} g set g.times = g.times - 1 where g.id = ?1")
    int updateTimesById(Integer id);
}
