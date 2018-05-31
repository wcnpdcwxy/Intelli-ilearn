package com.edu360.ilearn.entity;
//课程详情
public class Course {
    //课程号
    private int id;
//    课程名
    private String courseName;
//    课程图片地址
    private String picAddr;
//    上传者id
    private int userId;
//    上传者nickName
    private String userNickName;

//    课程介绍--适用人群
    private String intro1;
    //    课程介绍--课程概述
    private String intro2;
    //    课程介绍--联系方式
    private String intro3;
//    课程评分
    private int mark;
//    开课时间
    private String time;
//      课程分类
    private String type;
//    花费积分
    private int cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIntro1() {
        return intro1;
    }

    public void setIntro1(String intro1) {
        this.intro1 = intro1;
    }

    public String getIntro2() {
        return intro2;
    }

    public void setIntro2(String intro2) {
        this.intro2 = intro2;
    }

    public String getIntro3() {
        return intro3;
    }

    public void setIntro3(String intro3) {
        this.intro3 = intro3;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPicAddr() {
        return picAddr;
    }

    public void setPicAddr(String picAddr) {
        this.picAddr = picAddr;
    }


    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", picAddr='" + picAddr + '\'' +
                ", userId=" + userId +
                ", userNickName='" + userNickName + '\'' +
                ", intro1='" + intro1 + '\'' +
                ", intro2='" + intro2 + '\'' +
                ", intro3='" + intro3 + '\'' +
                ", mark=" + mark +
                ", time='" + time + '\'' +
                ", type='" + type + '\'' +
                ", cost=" + cost +
                '}';
    }
}
