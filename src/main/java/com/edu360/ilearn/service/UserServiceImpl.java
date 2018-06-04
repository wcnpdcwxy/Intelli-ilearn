package com.edu360.ilearn.service;

import com.edu360.ilearn.Tool.TimeUtil;
import com.edu360.ilearn.Vo.OrderVo;
import com.edu360.ilearn.Vo.PasswordVo;
import com.edu360.ilearn.Vo.UserVo;
import com.edu360.ilearn.entity.Course;
import com.edu360.ilearn.entity.User;
import com.edu360.ilearn.entity.pathTable;
import com.edu360.ilearn.mapper.DataMapper;
import com.edu360.ilearn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Source;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
        int register = userMapper.register(user);

        User one = userMapper.findOne(user);
        one.setPoints(one.getPoints()+100);
        userMapper.updatePoints(one);

        return register;
    }

    @Override
    public void password(PasswordVo passwordVo) {
        userMapper.password(passwordVo);
    }


    @Override
    public User login(User user) {
        UserVo userVo = userMapper.getUserVo(user);
        User one = userMapper.findOne(user);
        int point = 0;
        if(userVo!=null){
            String date = userVo.getNewDate().split(" ")[0];
            Date tab_date = new SimpleDateFormat("yyyy-MM-dd").parse(date, new ParsePosition(0));
            SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");

            Date nowdate=new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(nowdate);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            Date newdate = calendar.getTime();

            boolean equals = fmt.format(newdate).equals(fmt.format(tab_date));

            if(equals){
                one.setPoints(point+one.getPoints());
                userMapper.updatePoints(one);
            }
        }
        return one;
    }

    @Override
    public User findinfo(int userId) {
        User newUser = new User();
        newUser = userMapper.findinfo(userId);
        newUser.setPassword(null);
        return newUser;
    }

    @Override
    public ArrayList<User> findAllByStatus(int num) {
        return userMapper.findAllByStatus(num);
    }

    @Override
    public ArrayList<User> findAll(String search) {
        return userMapper.findAll(search);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public ArrayList<Course> getOrder(int id) {
        return userMapper.getOrder(id);
    }

    @Override
    public void updatePoints(User user) {
        userMapper.updatePoints(user);
    }

    @Override
    public void addOrder(OrderVo orderVo) {
        userMapper.addOrder(orderVo);
    }

    @Override
    public void editinfo(User user) {
        userMapper.editinfo(user);
    }

}

