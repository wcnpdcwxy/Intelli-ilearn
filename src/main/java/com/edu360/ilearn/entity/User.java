package com.edu360.ilearn.entity;

import org.springframework.data.annotation.Id;

import java.util.Date;

//import org.springframework.data.mongodb.core.mapping.Document;

//@Document(collection = "user")

public class User {
    @Id
    private int id;
    private String userName;
    private String password;
    private String nickName;
    private int stage;
    private String phoneNum;
    private int status;
    private String oriDate;
    private int points;

    public String getOriDate() {
        return oriDate;
    }

    public void setOriDate(String oriDate) {
        this.oriDate = oriDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", stage=" + stage +
                ", phoneNum='" + phoneNum + '\'' +
                ", status=" + status +
                ", oriDate='" + oriDate + '\'' +
                ", points=" + points +
                '}';
    }
}
