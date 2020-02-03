package com.example.demo.service;

import com.example.demo.vo.User;

import java.util.List;

public interface IUserService
{
    void insertUser(User user);

    List<User> selectAllUsers();

    User selectUserByName(String name);
}
