package com.edu360.ilearn.service;

import com.edu360.ilearn.Vo.CourseVo;
import com.edu360.ilearn.entity.Course;

import java.util.ArrayList;
import java.util.List;

public interface CourseService {

    CourseVo detail(int courseId);

    List<Course> doSearch(String searchContent);

    List<Course> doType(String type);
}
