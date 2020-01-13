package com.lcke.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcke.demo.pojo.UserEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

//@Mapper
//Spring在扫描注解时，取消了扫描抽象类和接口
@Repository
public interface UserDao extends BaseMapper<UserEntity> {

   // 使用 xml
   public UserEntity getUser();

   // 使用 注解
   @Results({
           @Result(column = "id", property = "id", id = true),
           @Result(column = "department_name", property = "departmentName")
   })
   @Select("select * from sys_user where id = #{id}")
   public UserEntity getById(Integer id);
}
