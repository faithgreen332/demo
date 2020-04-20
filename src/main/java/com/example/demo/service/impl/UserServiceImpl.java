package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.service.IUserService;
import com.example.demo.vo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper iUserDao;

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
