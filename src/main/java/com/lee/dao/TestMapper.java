package com.lee.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.lee.model.Snippet;

@Mapper
public interface TestMapper {
	
	@Insert("insert into snippet(content,tag,gmt_create) values(#{content},#{tag},NOW())")
    boolean save(Snippet snippet);
	
	@Delete("delete from snippet")
    boolean delete();
	
}
