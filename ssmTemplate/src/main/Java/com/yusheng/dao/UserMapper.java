package com.yusheng.dao;

import com.yusheng.pojo.User;

public interface UserMapper {
    User getUserByName(String uName);

    int updateUser(User user);
}
