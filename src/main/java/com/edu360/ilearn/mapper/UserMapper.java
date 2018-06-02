package com.edu360.ilearn.mapper;

import com.edu360.ilearn.Vo.OrderVo;
import com.edu360.ilearn.Vo.PasswordVo;
import com.edu360.ilearn.Vo.UserVo;
import com.edu360.ilearn.entity.Course;
import com.edu360.ilearn.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface UserMapper {

    int register(User user);

    void password(PasswordVo passwordVo);

    User findOne(User user);

    User findinfo(int userId);

    ArrayList<User> findAll();

    void updateUser(User user);

    ArrayList<Course> getOrder(int id);

    void updatePoints(User user);

    UserVo getUserVo(User user);

    void addOrder(OrderVo orderVo);

    void editinfo(User user);
}
