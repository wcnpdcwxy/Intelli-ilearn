package com.edu360.ilearn.entity;
//课程视频内容
public class Content {
//     视频id
    private int id;
//    视频标题
    private String title;
//    视频时长 duration/100:duration%100
    private int duration;
//    视频学习状况 (是否学过)
    private double state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getState() {
        return state;
    }

    public void setState(double state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", state=" + state +
                '}';
    }
}

