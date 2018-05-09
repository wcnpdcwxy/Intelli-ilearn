package com.edu360.ilearn.service;

import com.edu360.ilearn.entity.User;
import com.edu360.ilearn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int register(User user) {
        user.setStatus(1);
        Random random = new Random(System.currentTimeMillis());
        int cid = random.nextInt();
        cid = cid>0?cid:(-1*cid);
        user.setNickName("用户"+cid);
        return userMapper.register(user);
    }

    @Override
    public void password(User user) {
        userMapper.password(user);
    }


    @Override
    public User login(User user) {
        return userMapper.findOne(user);
    }

    @Override
    public User findinfo(int userId) {
        User newUser = new User();
        newUser = userMapper.findinfo(userId);
        newUser.setPassword(null);
        return newUser;
    }

}

