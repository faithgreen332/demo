package com.example.demo.service;

import com.example.demo.vo.User;

import java.util.List;

/**
 * @author Administrator
 */
public interface IUserService {
    /**
     * 写入单个用户
     *
     * @param user user
     */
    void insertUser(User user);

    /**
     * 查询所有user
     *
     * @return users
     */
    List<User> selectAllUsers();

    /**
     * 根据用户名字查找用户
     *
     * @param name name
     * @return User
     */
    User selectUserByName(String name);
}
