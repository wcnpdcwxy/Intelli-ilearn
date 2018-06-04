package com.edu360.ilearn.service;

import com.edu360.ilearn.Vo.CourseVo;
import com.edu360.ilearn.Vo.FavouriteVo;
import com.edu360.ilearn.entity.Course;
import com.edu360.ilearn.mapper.ContentMapper;
import com.edu360.ilearn.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<Course> doType(String type) {
        return courseMapper.doType(type);
    }

    @Override
    public ArrayList<Course> getFavouriteByuserId(int userId) {
        return courseMapper.getFavouriteByuserId(userId);
    }

    @Override
    public void intoFavourite(FavouriteVo favouriteVo) {
        courseMapper.intoFavourite(favouriteVo);
    }

    @Override
    public void outFavourite(FavouriteVo favouriteVo) {
        courseMapper.outFavourite(favouriteVo);
    }

    @Override
    public ArrayList<Course> findAll(String search) {
        return courseMapper.findAll(search);
    }

    @Override
    public void updateCourse(Course course) {
        courseMapper.updateCourse(course);
    }

    @Override
    public void updateCourse2(Course course) {
        courseMapper.updateCourse2(course);
    }

    @Override
    public void insertCourse(Course course) {
        courseMapper.insertCourse(course);
    }

}

