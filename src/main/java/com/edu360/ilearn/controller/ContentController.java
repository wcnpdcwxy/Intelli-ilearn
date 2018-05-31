package com.edu360.ilearn.controller;

import com.edu360.ilearn.Vo.ContentVo;
import com.edu360.ilearn.Vo.CourseVo;
import com.edu360.ilearn.Vo.HistoryVo;
import com.edu360.ilearn.entity.User;
import com.edu360.ilearn.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ContentController {
    @Autowired
    private ContentService contentService;

    //视频页面包括评论的获取
    @GetMapping("/Vdetail")
    public String Vdetail(int contentId, HttpSession session){
        session.removeAttribute("Vdetail");
        ContentVo vdetail = contentService.Vdetail(contentId);

        User user = (User) session.getAttribute("user");
        CourseVo detail = (CourseVo) session.getAttribute("detail");

        HistoryVo historyVo = new HistoryVo();
        historyVo.setUserId(user.getId());
        historyVo.setCourseId(detail.getCourse().getId());
        historyVo.setContentId(contentId);
        historyVo.setDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        contentService.setHistory(historyVo);

        session.setAttribute("Vdetail",vdetail);
        return "course/watch";
    }
}
