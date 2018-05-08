package com.edu360.ilearn.mapper;

import com.edu360.ilearn.entity.Content;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface ContentMapper {
    ArrayList<Content> getVedioList(int courseId);

    Content getVedio(int contentId);
}
