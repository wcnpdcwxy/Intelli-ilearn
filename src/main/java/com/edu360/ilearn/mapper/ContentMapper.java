package com.edu360.ilearn.mapper;

import com.edu360.ilearn.Vo.HistoryVo;
import com.edu360.ilearn.entity.Content;
import com.edu360.ilearn.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface ContentMapper {
    ArrayList<Content> getVedioList(int courseId);

    Content getVedio(int contentId);

    void setHistory(HistoryVo historyVo);

    ArrayList<HistoryVo> getHistoryById(int userId);

    ArrayList<Content> findAllByCourseId(int courseId);

    void updateContent(Content content);

    void updateContent2(Content content);

    void insertContent(Content content);
}
