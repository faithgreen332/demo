package com.example.demo.service.impl;

import com.example.demo.dao.IUserDao;
import com.example.demo.service.IUserService;
import com.example.demo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService") public class UserServiceImpl implements IUserService
{
    @Autowired private IUserDao iUserDao;

    @Override public void insertUser(User user)
    {
    }

    @Override public List<User> selectAllUsers()
    {
        return iUserDao.selectUsers();
    }

    @Override public User selectUserByName(String name)
    {
        return iUserDao.selectUserByName(name);
    }
}
