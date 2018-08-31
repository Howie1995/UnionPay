package com.howie.domain.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.howie.domain.annotation.Cluster;

@Mapper
public interface UserMapper {

	@Select("SELECT * FROM USER WHERE username = #{name}")
	User findByName(@Param("name") String name);
	
	@Insert("INSERT INTO `user`(`user`.id,`user`.username,`user`.`password`) VALUES(#{id},#{name},#{pass})")
	int insert(@Param("id")String id,@Param("name") String name,@Param("pass")String pass);
	
}