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

/**
 * 注解	示例	描述
 * @ApiModel    @ApiModel(value = "用户对象")	描述一个实体对象
 * @ApiModelProperty    @ApiModelProperty(value = "用户ID", required = true, example = "1000")	描述属性信息，执行描述，是否必须，给出示例
 * @Api    @Api(value = "用户操作 API(v1)", tags = "用户操作接口")	用在接口类上，为接口类添加描述
 * @ApiOperation    @ApiOperation(value = "新增用户")	描述类的一个方法或者说一个接口
 * @ApiParam    @ApiParam(value = "用户名", required = true)	描述单个参数
 */

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
