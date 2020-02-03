package com.example.demo.controller;

import com.example.demo.service.IUserService;
import com.example.demo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("user") public class UserController
{
    @Autowired private IUserService userService;

    @RequestMapping("selectUserByName")
    public User selectUserByName(@RequestParam("name") String name)
    {
        return userService.selectUserByName(name);
    }
}
