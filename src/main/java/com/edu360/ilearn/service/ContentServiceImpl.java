package com.edu360.ilearn.service;

import com.edu360.ilearn.Vo.ContentVo;
import com.edu360.ilearn.mapper.ContentMapper;
import com.edu360.ilearn.mapper.DiscussMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}

