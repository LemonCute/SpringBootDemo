package com.lcke.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lcke.demo.dao.UserDao;
import com.lcke.demo.pojo.UserEntity;
import com.lcke.demo.service.UserServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceApi {

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity getUser() {
        return userDao.getUser();
    }

    public void insertUser(UserEntity userEntity){
        userDao.insert(userEntity);
    }

    public IPage<UserEntity> findUserPage(){
        return  userDao.selectPage(new Page<UserEntity>(1,2),null);
    }
}
