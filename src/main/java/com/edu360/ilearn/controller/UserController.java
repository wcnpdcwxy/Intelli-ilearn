package com.edu360.ilearn.controller;

import com.edu360.ilearn.Vo.LoginVo;
import com.edu360.ilearn.entity.User;
import com.edu360.ilearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

//    注册
    @PostMapping("/register")
    @ResponseBody
    public String register(User user){
        //存mongodb
        userService.register(user);
        return "success";
    }

//    修改密码
    @PostMapping("/password")
    @ResponseBody
    public String password(User user){
        System.out.println(user);
        userService.password(user);
        return "success";
    }

//    登出
    @PostMapping("/Logout")
    @ResponseBody
    public String Logout(User user){


        return "success";
    }

//    登陆
    @PostMapping("/logined")
    @ResponseBody
    public String login(LoginVo vo,HttpSession session){
        System.out.println(321);
        System.out.println(vo);

        User user = new User();
        user.setUsername(vo.getUsername());
        user.setPassword(vo.getPassword());

        if(userService.login(user)) {
            session.setAttribute("user",user);
            return "true";
        }else {
            return "false";
        }
    }

    //    个人信息
    @PostMapping("/findinfo")
    @ResponseBody
    public User findinfo(int userId,HttpSession session){
        User user = userService.findinfo(userId);
        return user;
    }

}
