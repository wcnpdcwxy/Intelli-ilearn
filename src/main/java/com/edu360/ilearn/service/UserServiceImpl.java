package com.edu360.ilearn.service;

import com.edu360.ilearn.Tool.TimeUtil;
import com.edu360.ilearn.entity.User;
import com.edu360.ilearn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        if(user.getOriDate()==null){
            user.setOriDate(TimeUtil.getTime("date"));
        }
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

    @Override
    public ArrayList<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

}

