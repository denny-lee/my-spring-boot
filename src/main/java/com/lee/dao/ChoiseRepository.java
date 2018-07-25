package com.lee.dao;

import com.lee.entity.ChoiseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChoiseRepository extends JpaRepository<ChoiseEntity, Integer>,
        JpaSpecificationExecutor<ChoiseEntity> {

    List<ChoiseEntity> findAllByDelFlagFalse();

    ChoiseEntity findFirstByUidAndDelFlagFalseOrderByCreateTimeDesc(Integer uid);

    @Modifying
    @Query("update #{#entityName} c set c.delFlag = true where c.uid = ?1 and c.delFlag = false ")
    int deleteByName(Integer uid);

    @Modifying
    @Query("update #{#entityName} c set c.delFlag = true where c.id = ?1 and c.delFlag = false ")
    int deleteById(Integer id);

}
