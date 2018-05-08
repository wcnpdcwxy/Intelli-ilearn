package com.edu360.ilearn.mapper;

import com.edu360.ilearn.entity.Discuss;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface DiscussMapper {
    ArrayList<Discuss> getDiscussList(int contentId);
}
