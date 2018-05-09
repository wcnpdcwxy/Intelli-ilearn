package com.edu360.ilearn.service;

import com.edu360.ilearn.entity.User;

public interface UserService {

    int register(User user);

    void password(User user);

    User login(User user);

    User findinfo(int userId);
}
