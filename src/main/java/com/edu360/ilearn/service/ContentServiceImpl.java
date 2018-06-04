package com.edu360.ilearn.service;

import com.edu360.ilearn.Vo.ContentVo;
import com.edu360.ilearn.Vo.HistoryVo;
import com.edu360.ilearn.entity.Content;
import com.edu360.ilearn.mapper.ContentMapper;
import com.edu360.ilearn.mapper.DiscussMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private DiscussMapper discussMapper;
    @Autowired
    private ContentMapper contentMapper;

    @Override
    public ContentVo Vdetail(int contentId) {
        ContentVo contentVo = new ContentVo();
        contentVo.setContent(contentMapper.getVedio(contentId));
        contentVo.setList(discussMapper.getDiscussList(contentId));
        return contentVo;
    }

    @Override
    public void setHistory(HistoryVo historyVo) {
        contentMapper.setHistory(historyVo);
    }

    @Override
    public ArrayList<HistoryVo> getHistoryById(int userId) {
        return contentMapper.getHistoryById(userId);
    }

    @Override
    public ArrayList<Content> findAllByCourseId(int courseId) {
        return contentMapper.findAllByCourseId(courseId);
    }

    @Override
    public void updateContent(Content content) {
        contentMapper.updateContent(content);
    }

    @Override
    public void updateContent2(Content content) {
        contentMapper.updateContent2(content);
    }

    @Override
    public void insertContent(Content content) {
        contentMapper.insertContent(content);
    }

}

