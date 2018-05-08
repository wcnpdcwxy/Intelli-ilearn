package com.edu360.ilearn.service;

import com.edu360.ilearn.entity.User;
import com.edu360.ilearn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        user.setStatus(1);
        userMapper.register(user);
    }

    @Override
    public void password(User user) {
        userMapper.password(user);
    }


    @Override
    public boolean login(User user) {
        boolean sign = false;
        int res = userMapper.findOne(user);
        if(res==1){
            sign = true;
        }
        return sign;
    }

    @Override
    public User findinfo(int userId) {
        User newUser = new User();
        newUser = userMapper.findinfo(userId);
        newUser.setPassword(null);
        return newUser;
    }

}

