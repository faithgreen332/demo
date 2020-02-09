package com.example.demo.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.example.demo.vo.User;

public interface IUserDao {

    @Transactional(rollbackFor = Exception.class)
    int insertUser(User user);

    List<User> selectUsers();

    User selectUserByName(String name);
}
