package com.edu360.ilearn.service;

import com.edu360.ilearn.Vo.ContentVo;
import com.edu360.ilearn.Vo.HistoryVo;
import com.edu360.ilearn.entity.Content;

import java.util.ArrayList;

public interface ContentService {

    ContentVo Vdetail(int contentId);

    void setHistory(HistoryVo historyVo);

    ArrayList<HistoryVo> getHistoryById(int userId);

    ArrayList<Content> findAllByCourseId(int courseId);

    void updateContent(Content content);

    void updateContent2(Content content);

    void insertContent(Content content);
}
