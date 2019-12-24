package com.lcke.demo.controller;

import com.lcke.demo.pojo.UserEntity;
import com.lcke.demo.service.UserServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceApi userServiceApi;

    @RequestMapping("/get")
    public void getUser() {
        UserEntity user = userServiceApi.getUser();
        System.out.println("user = " + user);
    }
}
