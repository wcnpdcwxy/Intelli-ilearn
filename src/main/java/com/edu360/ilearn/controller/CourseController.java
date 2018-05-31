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

    @GetMapping("/detail")
    public String detail(int courseId,HttpSession session){
        session.removeAttribute("detail");
        CourseVo detail = courseService.detail(courseId);
        session.setAttribute("detail",detail);
        return "content/detail";
    }
//    , HttpServletRequest request

    @GetMapping("/doSearch")
    public String doSearch(String searchContent, HttpSession session){
        session.removeAttribute("pVo");
        session.removeAttribute("searchContent");
        session.setAttribute("searchContent",searchContent);

        System.out.println("searchContent"+searchContent);
        List<Course> list = courseService.doSearch(searchContent);
        PageVo pVo = new PageVo();
        if(list!=null){
            pVo.setTotalList(list);
            pVo.setTotal_data_num(list.size());
        }
        session.setAttribute("pVo",pVo);
        return "redirect:toSearch";
    }

    @GetMapping("/doOrder")
    public String doOrder(String order, HttpSession session){
        System.out.println("order:"+order);

        PageVo pVo = (PageVo) session.getAttribute("pVo");
        pVo.setPage_data_time_order(order);

        session.setAttribute("pVo",pVo);

        return "redirect:toSearch";
    }

    @GetMapping("/doType")
    public String doType(String type, HttpSession session){
        session.removeAttribute("pVo");
        session.removeAttribute("type");
        session.setAttribute("type",type);

        System.out.println("type"+type);
        List<Course> list = courseService.doType(type);
        PageVo pVo = new PageVo();
        if(list!=null){
            pVo.setTotalList(list);
            pVo.setTotal_data_num(list.size());
            pVo.setOldTotalList();
        }
        session.setAttribute("pVo",pVo);
        return "redirect:toType";
    }

    @GetMapping("/doFilter")
    public String doFilter(int filter, HttpSession session){
        System.out.println("filter:"+filter);

        PageVo pVo = (PageVo) session.getAttribute("pVo");
        pVo.setPage_data_time_filter(filter);

        session.setAttribute("pVo",pVo);
        return "redirect:toType";
    }
}
