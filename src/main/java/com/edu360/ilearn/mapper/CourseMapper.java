package com.edu360.ilearn.mapper;

import com.edu360.ilearn.entity.Course;
import com.edu360.ilearn.entity.Content;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseMapper {
    Course detail(int courseId);
}
