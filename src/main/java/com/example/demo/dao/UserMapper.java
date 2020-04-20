package com.example.demo.dao;

import com.example.demo.vo.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ljf
 */
public interface UserMapper {

    /**
     * 插入user
     *
     * @param user user
     * @return 插入的条数
     */
    @Transactional(rollbackFor = Exception.class)
    int insertUser(User user);

    /**
     * 查询所有user
     *
     * @return users
     */
    List<User> selectUsers();

    /**
     * 根据userName查询user
     *
     * @param name userName
     * @return User
     */
    User selectUserByName(String name);
}