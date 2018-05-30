package com.edu360.ilearn.Tool;

import com.edu360.ilearn.controller.UserController;
import com.edu360.ilearn.entity.User;
import org.hibernate.Session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.HttpJspPage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.*;

public class CreateLog {
    //判定，10%用户将流失,返回对应在list中的index
    public static int[] loseUser(ArrayList<User> list){
        int userNum = list.size();
        int updateUserNum = userNum/10;
        int arr[] = new int[updateUserNum];//updateUserNum个数的数组
        for (int i = 0; i < arr.length; i++) {
            int index = (int)(Math.random() * userNum);//生产一个0-userNum-1的随机数
            arr[i] = index;     //把随机数赋值给下标为数组下标为i的值

            for (int j = 0; j < i; j++) {//（遍历数组中储存进去的值，i中有几个值则循环几次）

                if (arr[j] == arr[i]) {//把储存在数组中的值j 和 随机出的值i 做比较
                    i--; //数组的值下标-1，i的循环次数回到上次
                    break;
                }
            }
        }
        return arr;
    }

    //制造用户登录日志（活跃度统计）
    public static void createUserLog(String date,ArrayList<User> list){
        //用户人数
        int userNum = list.size();
        //起始时间
        long startTime = System.currentTimeMillis();
        //计数器
        int count = 1;
        //同时登陆人数
        int times = userNum/100;
        System.out.println("times"+times);

        String[] split = date.split("-");
        int bcount = Integer.parseInt(split[2]);

        User newUser = null;
        int total =0;
        //计时一分钟造数据
//        while(System.currentTimeMillis()-startTime<300000){//600000
            while(count<=1440){
                if(System.currentTimeMillis()-startTime>count*300){//400
                    int random1 = (int)(1+Math.random()*times);
                    total+=random1;
                    System.out.println(random1);
                    for(int i = 0;i<random1;i++){
                        String hour = count/60>=10?""+count/60:"0"+count/60;
                        String minute = count%60>=10?""+count%60:"0"+count%60;
                        int random2 = (int)(Math.random()*60);
                        String second = random2>=10?""+random2:"0"+random2;

                        int random3 = (int)(Math.random()*userNum);
                        newUser = list.get(random3);
                        if(newUser.getStatus()!=1){
                            break;
                        }

                        String time = ""+hour+":"+minute+":"+second;
                        String info = "{\"time\":\""+ date+" "+time+"\",\"userId\":\""+newUser.getId()+"\",\"userName\":\""+newUser.getUserName()+"\"}";
                        HttpPostUtil.sendLog(info,"recharge");
                    }
                    count++;
                }
            }
//        }
        System.out.println("total"+total);
    }

    //制造用户
    public static ArrayList<User> insertUser(String date,int num){
        ArrayList<User> list = new ArrayList<User>();
        for(int i =0;i<num;i++){

            String userName = "";
            String password = "";
            String nickName;
            int stage = 0;
            String phoneNum ="";
            int status = 1;
            String oriDate = date;

            int[] header = {139,138,137,136,135,134,150,151,152,157,158,159,182,183,187};
            int index = (int)(Math.random()*header.length);
            phoneNum+=header[index];
            for(int m = 0;m<8;m++){
                phoneNum+=(int)(1+Math.random()*9);
            }

            char[] ch = {'q','w','e','r','t','y','u','i','o','p','l','k','m','j','n','h','b','g','v','f','c','d','x','s','z','a'};
            int count1 = (int)(8+Math.random()*6);
            for(int m = 0;m<count1;m++){
                userName+=ch[(int)(Math.random()*ch.length)];
            }
            int[] number = {1,2,3,4,5,6,7,8,9,0};
            int count2 = (int)(6+Math.random()*9);
            for(int m = 0;m<count1;m++){
                if((int)(Math.random()*2)==1){
                    password+=ch[(int)(Math.random()*ch.length)];
                }else{
                    password+=number[(int)(Math.random()*number.length)];
                }
            }

            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);
            user.setStage(stage);
            user.setPhoneNum(phoneNum);
            user.setStatus(status);
            user.setOriDate(oriDate);
            list.add(user);
        }
        return list;
    }


    public static void doPathLog(String date,ArrayList<User> list,HttpSession session) {
        //生产数据，类似userLog
        //用户人数
        int userNum = list.size();
        //起始时间
        long startTime = System.currentTimeMillis();
        //计数器
        int count = 1;
        //同时登陆人数
        int times = 40;
        User newUser = null;
        //计时一分钟造数据
//        while(System.currentTimeMillis()-startTime<300000){//600000
        while (count <= 1440) {
            if (System.currentTimeMillis() - startTime > count * 200) {//400
                int random1 = (int) (Math.random() * times);
                for (int i = 0; i < random1; i++) {
                    String hour = count / 60 >= 10 ? "" + count / 60 : "0" + count / 60;
                    String minute = count % 60 >= 10 ? "" + count % 60 : "0" + count % 60;
                    int random2 = (int) (Math.random() * 60);
                    String second = random2 >= 10 ? "" + random2 : "0" + random2;

                    int random3 = (int) (Math.random() * userNum);
                    newUser = list.get(random3);


                    session.setAttribute("user", newUser);

                    String time = "" + hour + ":" + minute + ":" + second;
                    String datetime = date + " " + time;

                    HttpPostUtil.pathLog(null, session, "/index", datetime);
                }
                //////////////////////////////////////////////////////////////////////////
                //相同用户有相同的ip，建个String[userNum]或者hashmap或者√一次性完成所有跳转
                //时间修改问题，不能10分钟发24小时，最多2小时?
                //√用户访问的连贯问题，random判定继续或退出，继续着random下一网页
                //√弹出率问题，特定的ip或用户被弹出当日不再访问
                count++;
            }
        }
    //    }
    }



}
