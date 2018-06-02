package com.edu360.ilearn.controller;

import com.edu360.ilearn.Tool.CreateLog;
import com.edu360.ilearn.Tool.HttpPostUtil;
import com.edu360.ilearn.Tool.TimeUtil;
import com.edu360.ilearn.Vo.*;
import com.edu360.ilearn.entity.Course;
import com.edu360.ilearn.entity.User;
import com.edu360.ilearn.service.CourseService;
import com.edu360.ilearn.service.UserService;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;


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
    public String password(String oldpd,String newpd,HttpSession session){
        User user = (User) session.getAttribute("user");

        if(user.getPassword().equals(oldpd)){
            PasswordVo passwordVo = new PasswordVo();
            passwordVo.setUserId(user.getId());
            passwordVo.setOldpd(oldpd);
            passwordVo.setNewpd(newpd);

            userService.password(passwordVo);
        }

        return "redirect:toMyInfo";
    }

//    登出
    @GetMapping("/logOut")
    public String Logout(HttpSession session){
        System.out.println(999);
        session.removeAttribute("user");
        session.removeAttribute("orderlist");
        session.removeAttribute("favouritelist");
        return "redirect:toIndex";
    }

//    登陆
    @PostMapping("/logined")
    @ResponseBody
    public String login(LoginVo vo,HttpSession session){
        //验证登陆信息
        User user = new User();
        user.setUserName(vo.getUserName());
        user.setPassword(vo.getPassword());
        User newUser = userService.login(user);
        //编辑日志信息
        String info = "{\"time\":\""+ TimeUtil.getTime("long")+"\",\"userId\":\""+newUser.getId()+"\",\"userName\":\""+newUser.getUserName()+"\"}";
        if(newUser!=null) {
            //查找用户所有订单信息
            ArrayList<Course> orderlist = userService.getOrder(newUser.getId());
            //查找用户所有收藏信息
            ArrayList<Course> favouritelist = courseService.getFavouriteByuserId(newUser.getId());
            session.setAttribute("user",newUser);
            session.setAttribute("orderlist",orderlist);
            session.setAttribute("favouritelist",favouritelist);
            HttpPostUtil.sendLog(info,"recharge");
            return "success";
        }else {
            return "error";
        }
    }

    //查找个人信息
    @PostMapping("/findinfo")
    @ResponseBody
    public User findinfo(int userId,HttpSession session){
        User user = userService.findinfo(userId);
        return user;
    }

    //修改个人信息
    @PostMapping("/editinfo")
    public String editinfo(User user,HttpSession session){
        userService.editinfo(user);
        User findinfo = userService.findinfo(user.getId());

        session.setAttribute("user",findinfo);
        return "redirect:toMyInfo";
    }


    @GetMapping("/afford")
    public String afford( HttpSession session){
        User user = (User) session.getAttribute("user");
        CourseVo detail = (CourseVo) session.getAttribute("detail");

        //积分减少
        int lastpoint = user.getPoints() - detail.getCourse().getCost();
        user.setPoints(lastpoint);
        session.setAttribute("user",user);
        userService.updatePoints(user);

        //订单添加
        OrderVo orderVo = new OrderVo();
        orderVo.setUserId(user.getId());
        orderVo.setCourseId(detail.getCourse().getId());
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        orderVo.setDatetime(format);

        userService.addOrder(orderVo);
        ArrayList<Course> orderlist = userService.getOrder(user.getId());
        session.setAttribute("orderlist",orderlist);

        return "redirect:toDetail";
    }




    /////////////////////////////////////////////////////////////////////////////////////////////////////////


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
