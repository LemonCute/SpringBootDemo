package com.lcke.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcke.demo.pojo.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//@Mapper
//Spring在扫描注解时，取消了扫描抽象类和接口
@Repository
public interface UserDao extends BaseMapper<UserEntity> {

   public UserEntity getUser();
}
