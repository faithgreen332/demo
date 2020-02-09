package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.User;

/**
 * @author Administrator
 */
public interface IUserService {
    /**
     * 写入单个用户
     * 
     * @param user
     */
    void insertUser(User user);

    List<User> selectAllUsers();

    /**
     * 根据用户名字查找用户
     * 
     * @param name
     * @return
     */
    User selectUserByName(String name);
}
