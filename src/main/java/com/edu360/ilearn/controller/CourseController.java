package com.edu360.ilearn.controller;

import com.edu360.ilearn.Vo.CourseVo;
import com.edu360.ilearn.entity.Course;
import com.edu360.ilearn.entity.Content;
import com.edu360.ilearn.entity.Discuss;
import com.edu360.ilearn.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/detail")
    @ResponseBody
    public CourseVo detail(int courseId){
        return courseService.detail(courseId);
    }
}
