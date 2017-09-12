package com.lee.dao;

import com.lee.model.Girl;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GirlMapper {
    @Insert("insert into girl(name,age) values(#{name},#{age})")
    boolean save(Girl girl);

    @Select("select id, name, age from girl")
    List<Girl> listAll();
}
