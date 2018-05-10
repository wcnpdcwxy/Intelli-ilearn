package com.edu360.ilearn.service;

import com.edu360.ilearn.Vo.CourseVo;
import com.edu360.ilearn.entity.Course;
import com.edu360.ilearn.mapper.ContentMapper;
import com.edu360.ilearn.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ContentMapper contentMapper;

    @Override
    public CourseVo detail(int courseId) {
        CourseVo courseVo = new CourseVo();
        courseVo.setCourse(courseMapper.detail(courseId));
        courseVo.setList(contentMapper.getVedioList(courseId));
        return courseVo;
    }

    @Override
    public List<Course> doSearch(String searchContent) {
        return courseMapper.doSearch(searchContent);
    }

}

