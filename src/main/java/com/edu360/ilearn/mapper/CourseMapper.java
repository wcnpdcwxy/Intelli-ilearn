package com.edu360.ilearn.mapper;

import com.edu360.ilearn.Vo.FavouriteVo;
import com.edu360.ilearn.entity.Course;
import com.edu360.ilearn.entity.Content;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface CourseMapper {
    Course detail(int courseId);

    List<Course> doSearch(String searchContent);

    List<Course> doType(String type);

    ArrayList<Course> getFavouriteByuserId(int userId);

    void intoFavourite(FavouriteVo favouriteVo);

    void outFavourite(FavouriteVo favouriteVo);
}
