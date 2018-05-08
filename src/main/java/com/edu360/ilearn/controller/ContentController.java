package com.edu360.ilearn.controller;

import com.edu360.ilearn.Vo.ContentVo;
import com.edu360.ilearn.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContentController {
    @Autowired
    private ContentService contentService;

    //视频页面包括评论的获取
    @PostMapping("/Vdetail")
    @ResponseBody
    public ContentVo Vdetail(int contentId){
        return contentService.Vdetail(contentId);
    }
}
