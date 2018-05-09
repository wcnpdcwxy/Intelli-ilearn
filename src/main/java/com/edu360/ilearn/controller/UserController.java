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
    public String register(User user,HttpSession session){
        //存mongodb
        if(userService.register(user)==1){
            session.setAttribute("user",user);
            return "success";
        }
        return "error";
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
    @GetMapping("/logOut")
    public String Logout(HttpSession session){
        System.out.println(999);
        session.removeAttribute("user");
        return "redirect:toIndex";
    }

//    登陆
    @PostMapping("/logined")
    @ResponseBody
    public String login(LoginVo vo,HttpSession session){
        System.out.println(321);
        System.out.println(vo);

        User user = new User();
        user.setUserName(vo.getUserName());
        user.setPassword(vo.getPassword());
        User newUser = userService.login(user);
        if(newUser!=null) {
            session.setAttribute("user",newUser);
            return "success";
        }else {
            return "error";
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
