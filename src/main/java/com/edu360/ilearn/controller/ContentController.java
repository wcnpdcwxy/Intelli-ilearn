package com.edu360.ilearn.controller;

import com.edu360.ilearn.Vo.ContentVo;
import com.edu360.ilearn.Vo.CourseVo;
import com.edu360.ilearn.Vo.HistoryVo;
import com.edu360.ilearn.Vo.InsContentVo;
import com.edu360.ilearn.entity.Content;
import com.edu360.ilearn.entity.User;
import com.edu360.ilearn.service.ContentService;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
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

    @GetMapping("/lockContent")
    public String lockContent(int contentId,HttpSession session){
        Content content = new Content();
        content.setId(contentId);
        content.setState(1);

        contentService.updateContent(content);
        return "redirect:toContentManager";
    }

    @GetMapping("/unlockContent")
    public String unlockContent(int contentId,HttpSession session){
        Content content = new Content();
        content.setId(contentId);
        content.setState(0);

        contentService.updateContent(content);
        return "redirect:toContentManager";
    }

    @RequestMapping("/updateContent")
    public String updateContent(String courseId, MultipartFile file,Content content,HttpSession session){

        String suffix=file.getOriginalFilename();
        String priffix=courseId;

        if(suffix!=""&&suffix!=null&&!suffix.isEmpty()){
            String newName=priffix+"/"+suffix;
            String realPath="E:\\JetBrains\\workspace\\edu\\ilearn\\src\\main\\webapp\\vedio\\"+priffix+"\\"+suffix;
            try {
                file.transferTo(new File(realPath));
                String path="../../../vedio/"+newName;
                content.setVdAddr(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        contentService.updateContent2(content);
        return "redirect:toCourseManager";
    }

    @RequestMapping("/insertContent")
    public String insertContent(String courseId, MultipartFile file, Content content, HttpSession session){
        String suffix=file.getOriginalFilename();
        String priffix=courseId;

        if(suffix!=""&&suffix!=null&&!suffix.isEmpty()){
            String newName=priffix+"/"+suffix;
            String realPath="E:\\JetBrains\\workspace\\edu\\ilearn\\src\\main\\webapp\\vedio\\"+priffix+"\\"+suffix;
            try {
                file.transferTo(new File(realPath));
                String path="../../../vedio/"+newName;
                content.setVdAddr(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            content.setVdAddr(".");
        }

        contentService.insertContent(courseId,content);
        return "redirect:toCourseManager";
    }
}
