package com.edu360.ilearn.Vo;

public class HistoryVo {
    private int id;
    private int userId;
    private int courseId;
    private String courseName;
    private int contentId;
    private String contentTitle;
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

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    @Override
    public String toString() {
        return "HistoryVo{" +
                "id=" + id +
                ", userId=" + userId +
                ", courseId=" + courseId +
                ", courseName=" + courseName +
                ", contentId=" + contentId +
                ", contentTitle=" + contentTitle +
                ", datetime='" + datetime + '\'' +
                '}';
    }
}
