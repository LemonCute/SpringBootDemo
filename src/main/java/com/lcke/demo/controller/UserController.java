package com.lcke.demo.controller;

import com.lcke.demo.pojo.UserEntity;
import com.lcke.demo.service.UserServiceApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/user")
@Api(value = "查询客户")
public class UserController {

    @Autowired
    UserServiceApi userServiceApi;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "用户名",required = false,dataType = "String",paramType = "UserEntity")
    })
    @ApiOperation(value = "查找单个用户 ",notes = "获取单个")
    @RequestMapping("/get")
    public void getUser() {
        UserEntity user = userServiceApi.getUser();
        System.out.println("user = " + user);
    }
}
