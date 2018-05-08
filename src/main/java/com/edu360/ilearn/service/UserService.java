package com.edu360.ilearn.service;

import com.edu360.ilearn.entity.User;

public interface UserService {

    void register(User user);

    void password(User user);

    boolean login(User user);

    User findinfo(int userId);
}
