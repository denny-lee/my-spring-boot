package com.lee.dao;

import com.lee.entity.GirlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GirlRepository extends JpaRepository<GirlEntity, Integer>,
        JpaSpecificationExecutor<GirlEntity> {

    @Modifying
    @Query("update #{#entityName} a set a.age = :newAge, a.name=:name where a.age = :oldAge")
    int updateAge(@Param("oldAge") Integer oldAge, @Param("newAge") Integer newAge, @Param("name") String name);
}
