package com.edu360.ilearn.entity;

public class CourseContent {
    private int id;
    private int courseId;
    private int contentId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "CourseContent{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", contentId=" + contentId +
                '}';
    }
}
