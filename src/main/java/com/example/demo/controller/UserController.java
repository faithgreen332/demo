package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.IUserService;
import com.example.demo.vo.User;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;

    // @CrossOrigin(origins = "http://localhost:3000") // cors 请求的方法之一，另外两种是配置Filter和在addCorsMapping里加对应的请求头
    @RequestMapping("selectUserByName")
    public User selectUserByName(@RequestParam("name") String name) {
        return userService.selectUserByName(name);
    }
}
