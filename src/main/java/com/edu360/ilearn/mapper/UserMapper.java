package com.edu360.ilearn.mapper;

import com.edu360.ilearn.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface UserMapper {

    int register(User user);

    void password(User user);

    User findOne(User user);

    User findinfo(int userId);

    ArrayList<User> findAll();

    void updateUser(User user);
}
