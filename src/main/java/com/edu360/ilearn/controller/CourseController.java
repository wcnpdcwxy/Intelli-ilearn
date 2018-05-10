package com.edu360.ilearn.controller;

import com.edu360.ilearn.Vo.CourseVo;
import com.edu360.ilearn.Vo.PageVo;
import com.edu360.ilearn.entity.Course;
import com.edu360.ilearn.entity.Content;
import com.edu360.ilearn.entity.Discuss;
import com.edu360.ilearn.service.CourseService;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/detail")
    public CourseVo detail(int courseId){
        return courseService.detail(courseId);
    }
//    , HttpServletRequest request

    @GetMapping("/doSearch")
    public String doSearch(String searchContent, HttpSession session, HttpServletRequest request){
        session.removeAttribute("pVo");
        session.removeAttribute("searchContent");
        session.setAttribute("searchContent",searchContent);


        List<Course> list = courseService.doSearch(searchContent);
        if(list!=null){
            PageVo pVo = new PageVo();
            pVo.setTotalList(list);
            pVo.setTotal_data_num(list.size());
            session.setAttribute("pVo",pVo);
        }
        return "redirect:toSearch";
    }
}
