package com.yusheng.service;

import com.yusheng.pojo.User;

public interface UserService {
    // 通过用户名获取用户
    User getUserByName(String uName);

    int updateUser(User user);
}
