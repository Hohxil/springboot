package com.edu.hello.controller;

import com.edu.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testBoot")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("getUser")
    public String getUser() {

           return userService.Sel().toString();

    }
    @RequestMapping("getUserOne/{id}")
    public String getUserOne(@PathVariable  int id) {
        System.out.println("进入getUserOne方法");
        return userService.findOne(id).toString();
    }
}
