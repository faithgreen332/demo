package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("selectAllUsers")
    public List<User> selectAllUsers() {
        return userService.selectAllUsers();
    }

    @RequestMapping("insertUser")
    public void insetUser(@RequestBody User user) {
        // 参数可以直接用对象，也可以用阿里的JSONObject 来封装对象，如下
        // User user = new User();
        // String userId = "userId";
        // String userName = "userName";
        // String psw = "psw";
        // String tel = "tel";
        // String userDesc = "userDesc";
        //
        // user.setUserId(json.getString(userId) == null ? "" : json.getString(userId));
        // user.setUserName(json.getString(userName) == null ? "" : json.getString(userName));
        // user.setPsw(json.getString(psw) == null ? "" : json.getString(psw));
        // user.setTel(json.getString(tel) == null ? "" : json.getString(tel));
        // user.setUserDesc(json.getString(userDesc) == null ? "" : json.getString(userDesc));

        userService.insertUser(user);
    }
}
