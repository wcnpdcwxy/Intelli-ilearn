package com.edu360.ilearn.Vo;

public class OrderVo {
    private int id;
    private int userId;
    private int courseId;
    private String datetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }


    @Override
    public String toString() {
        return "OrderVo{" +
                "id=" + id +
                ", userId=" + userId +
                ", courseId=" + courseId +
                ", datetime=" + datetime +
                '}';
    }
}
