package com.edu360.ilearn.controller;

import com.edu360.ilearn.Vo.ContentVo;
import com.edu360.ilearn.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class ContentController {
    @Autowired
    private ContentService contentService;

    //视频页面包括评论的获取
    @GetMapping("/Vdetail")
    public String Vdetail(int contentId, HttpSession session){
        session.removeAttribute("Vdetail");
        ContentVo vdetail = contentService.Vdetail(contentId);
        session.setAttribute("Vdetail",vdetail);
        return "course/watch";
    }
}
