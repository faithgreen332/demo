package com.example.demo.dao;

import com.example.demo.vo.User;

import java.util.List;

public interface IUserDao
{
    int insert(User user);

    List<User> selectUsers();

    User selectUserByName(String name);
}
