package com.edu360.ilearn.mapper;

import com.edu360.ilearn.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void register(User user);

    void password(User user);

    int findOne(User user);

    User findinfo(int userId);
}
