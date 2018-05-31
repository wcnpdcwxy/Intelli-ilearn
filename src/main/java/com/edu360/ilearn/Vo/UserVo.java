package com.edu360.ilearn.Vo;

import com.edu360.ilearn.entity.User;

public class UserVo {
    private int id;
    private String newDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewDate() {
        return newDate;
    }

    public void setNewDate(String newDate) {
        this.newDate = newDate;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", newDate='" + newDate + '\'' +
                '}';
    }
}
