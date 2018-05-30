package com.edu360.ilearn.controller;

import com.edu360.ilearn.Tool.CreateLog;
import com.edu360.ilearn.Tool.HttpPostUtil;
import com.edu360.ilearn.Tool.TimeUtil;
import com.edu360.ilearn.Vo.LoginVo;
import com.edu360.ilearn.entity.User;
import com.edu360.ilearn.service.UserService;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

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

        String info = "{\"time\":\""+ TimeUtil.getTime("long")+"\",\"userId\":\""+newUser.getId()+"\",\"userName\":\""+newUser.getUserName()+"\"}";
        if(newUser!=null) {
            session.setAttribute("user",newUser);
            HttpPostUtil.sendLog(info,"recharge");
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


    //生成登陆日志数据
    @GetMapping("/createUserLog")
    @ResponseBody
    public String createUserLog(){
        ArrayList<User> list = userService.findAll();
        //流失用户
        int[] indexs = CreateLog.loseUser(list);
        for(int i = 0;i<indexs.length;i++){
            User user = list.get(indexs[i]);
            user.setStatus(2);//流失用户
            userService.updateUser(user);
        }

        //造数据
        CreateLog.createUserLog("2018-05-07",list);
        return "success";
    }

    //生成用户
    @GetMapping("/insertUser")
    @ResponseBody
    public String insertUser(){
        ArrayList<User> list = CreateLog.insertUser("2018-05-07",11314);
        if(list!=null){
            for(int i =0;i<list.size();i++){
                User user = list.get(i);
                userService.register(user);
            }
        }
        return "success";
    }


    //生成用户网页跳转数据
    @GetMapping("/createUserPathLog")
    @ResponseBody
    public String createUserPathLog(HttpSession session){
        ArrayList<User> list = userService.findAll();
        //造数据
        CreateLog.doPathLog("2018-05-06",list,session);
        return "success";
    }

}
