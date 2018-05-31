package com.edu360.ilearn.service;

import com.edu360.ilearn.Vo.OrderVo;
import com.edu360.ilearn.entity.Course;
import com.edu360.ilearn.entity.User;

import java.util.ArrayList;

public interface UserService {

    int register(User user);

    void password(User user);

    User login(User user);

    User findinfo(int userId);

    ArrayList<User> findAll();

    void updateUser(User user);

    ArrayList<Course> getOrder(int id);

    void updatePoints(User user);

    void addOrder(OrderVo orderVo);
}
