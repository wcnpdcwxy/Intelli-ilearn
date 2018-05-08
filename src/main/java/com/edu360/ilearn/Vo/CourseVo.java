package com.edu360.ilearn.Vo;

import com.edu360.ilearn.entity.Content;
import com.edu360.ilearn.entity.Course;

import java.util.ArrayList;

public class CourseVo {
    private Course course;
//    教学视频列表
    private ArrayList<Content> list;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ArrayList<Content> getList() {
        return list;
    }

    public void setList(ArrayList<Content> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "CourseVo{" +
                "course=" + course +
                ", list=" + list +
                '}';
    }
}
