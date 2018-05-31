package com.edu360.ilearn.entity;
//课程视频内容
public class Content {
//     视频id
    private int id;
//    视频标题
    private String title;
//    视频时长 duration/100:duration%100
    private String duration;
//    视频学习状况 (是否学过)
    private int state;

    private String vdAddr;

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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getVdAddr() {
        return vdAddr;
    }

    public void setVdAddr(String vdAddr) {
        this.vdAddr = vdAddr;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", state=" + state +
                ", vdAddr='" + vdAddr + '\'' +
                '}';
    }
}

