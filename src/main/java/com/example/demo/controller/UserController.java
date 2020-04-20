package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.IUserService;
import com.example.demo.util.Constant;
import com.example.demo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("login")
    public Object login(@RequestBody JSONObject jsonObject) {
        List<User> users = this.selectAllUserForReacts();
        String userName = jsonObject.getString("userName");
        String userPsw = jsonObject.getString("userPsw");

        Assert.notNull(userName, "userName is null, please check out the parameter from UI");
        Assert.notNull(userPsw, "userName is null, please check out the parameter from UI");

        JSONObject result = new JSONObject();

        for (User user : users) {
            if (userName.equals(user.getUsername()) && userPsw.equals(user.getUserpsw())) {
                JSONObject message = new JSONObject();
                message.put("userId", user.getId());
                message.put("username", userName);
                result.put(Constant.STATUS, Constant.OK_CODE);
                result.put(Constant.MESSAGE, message);
            }
        }
        if (result.isEmpty()) {
            result.put(Constant.STATUS, Constant.NOT_OK_CODE);
            result.put(Constant.MESSAGE, "can not find user " + userName);
        }
        return result;
    }

    @RequestMapping("selectUserByName")
    public User selectUserByName(@RequestParam("name") String name) {
        return userService.selectUserByName(name);
    }

    @RequestMapping("selectAllUsers")
    public List<User> selectAllUserForReacts() {
        return userService.selectAllUsers();
    }

    @RequestMapping("insertUser")
    public void insetUser(@RequestBody User user) {
        // 参数可以直接用对象，也可以用阿里的JSONObject 来封装对象，如下
        User usr = new User();
        // String userId = "userId";
        // String userName = "userName";
        // String userPsw = "userPsw";
        // String tel = "tel";
        // String userDesc = "userDesc";
        //
        // user.setUserId(json.getString(userId) == null ? "" : json.getString(userId));
        // user.setUserName(json.getString(userName) == null ? "" : json.getString(userName));
        // user.setuserPsw(json.getString(userPsw) == null ? "" : json.getString(psw));
        // user.setTel(json.getString(tel) == null ? "" : json.getString(tel));
        // user.setUserDesc(json.getString(userDesc) == null ? "" : json.getString(userDesc));

        userService.insertUser(user);
    }
}
