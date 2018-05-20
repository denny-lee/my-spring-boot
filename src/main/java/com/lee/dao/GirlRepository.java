package com.lee.dao;

import com.lee.entity.GirlEntity;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import java.util.List;

public interface GirlRepository extends JpaRepository<GirlEntity, Integer>,
        JpaSpecificationExecutor<GirlEntity> {

    @Modifying
    @Query("update #{#entityName} a set a.age = :newAge, a.nickName=:name where a.age = :oldAge")
    int updateAge(@Param("oldAge") Integer oldAge, @Param("newAge") Integer newAge, @Param("name") String name);

    @Lock(value = LockModeType.PESSIMISTIC_READ)
    List<GirlEntity> findAllByNickName(String nickName);
}
