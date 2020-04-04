package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.dao.IUserDao;
import com.example.demo.service.IUserService;
import com.example.demo.vo.User;

/**
 * @author Administrator
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    private IUserDao iUserDao;

    @Override
    public void insertUser(User user) {
        iUserDao.insertUser(user);
    }

    @Override
    public List<User> selectAllUsers() {
        return iUserDao.selectUsers();
    }

    @Override
    public User selectUserByName(String name) {
        return iUserDao.selectUserByName(name);
    }
}
