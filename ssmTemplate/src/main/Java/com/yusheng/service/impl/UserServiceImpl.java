package com.yusheng.service.impl;

import com.yusheng.dao.UserMapper;
import com.yusheng.pojo.User;
import com.yusheng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByName(String uName) {
        User user = userMapper.getUserByName(uName);
        return user;
    }

    @Override
    public int updateUser(User user) {

        return userMapper.updateUser(user);
    }
}
