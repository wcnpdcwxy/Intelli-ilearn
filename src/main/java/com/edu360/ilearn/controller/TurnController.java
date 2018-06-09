package com.edu360.ilearn.controller;

import com.edu360.ilearn.Tool.CreateLog;
import com.edu360.ilearn.Tool.HttpPostUtil;
import com.edu360.ilearn.Vo.CourseVo;
import com.edu360.ilearn.Vo.HistoryVo;
import com.edu360.ilearn.Vo.PageVo;
import com.edu360.ilearn.entity.Content;
import com.edu360.ilearn.entity.Course;
import com.edu360.ilearn.entity.User;
import com.edu360.ilearn.entity.pathTable;
import com.edu360.ilearn.service.ContentService;
import com.edu360.ilearn.service.CourseService;
import com.edu360.ilearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class TurnController {
    @Autowired
    private ContentService contentService;
    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;

    @RequestMapping("/toLogin")
    public String toLogin(HttpServletRequest request) {
        System.out.println(123);
//        HttpPostUtil.pathLog(request,null,"/login",null);
        return "common/login";
    }

    @RequestMapping("/toRegister")
    public String toRegister(HttpServletRequest request) {
        System.out.println(123);
//        HttpPostUtil.pathLog(request,null,"/register",null);
        return "common/register";
    }


    @RequestMapping("/toIndex")
    public String toIndex(HttpServletRequest request) {
        System.out.println(123);
//        HttpPostUtil.pathLog(request,null,"/index",null);
        return "common/index";
    }

    @RequestMapping("/toTop")
    public String toTop() {
        return "common/top";
    }

    @RequestMapping("/toHome")
    public String toHome(HttpServletRequest request) {
//        HttpPostUtil.pathLog(request,null,"/home",null);
        return "common/home";
    }

    @RequestMapping("/toBottom")
    public String toBottom() {
        return "common/bottom";
    }


    @RequestMapping("/toEcharts")
    public String toEcharts() {
        return "common/echarts";
    }


    @RequestMapping("/toSearch")
    public String toSearch(Integer pageNum, HttpSession session,HttpServletRequest request) {
        System.out.println("pageNum"+pageNum);
//        HttpPostUtil.pathLog(request,null,"/search",null);
//        测试
//        PageVo pVo_t = (PageVo) session.getAttribute("pVo");
//        System.out.println(pVo_t);

        if(pageNum!=null){
            PageVo pVo = (PageVo) session.getAttribute("pVo");
            pVo.setNow_page(pageNum);
            session.setAttribute("pVo",pVo);
        }
        return "search";
    }


    //跳转table页
    @RequestMapping("/toTable")
    public String toTable(Integer pageNum, HttpSession session){

        if(pageNum!=null){
            PageVo pVo = (PageVo) session.getAttribute("pVo");
            pVo.setNow_page(pageNum);
            session.setAttribute("pVo",pVo);
        }

        return "common/table";
    }

    @RequestMapping("/toCluster")
    public String toCluster(Integer pageNum, HttpSession session){

        if(pageNum!=null){
            PageVo pVo = (PageVo) session.getAttribute("ClusterpVo");
            pVo.setNow_page(pageNum);
            session.setAttribute("ClusterpVo",pVo);
        }

        return "common/cluster";
    }

    @RequestMapping("/toIntro")
    public String toIntro() {
        return "content/intro";
    }

    @RequestMapping("/toVedioMenu")
    public String toVedioMenu() {
        return "content/vedioMenu";
    }

    @RequestMapping("/toWatch")
    public String toWatch() {
        return "course/watch";
    }

    @RequestMapping("/toType")
    public String toType(Integer pageNum, HttpSession session) {
        System.out.println("pageNum"+pageNum);

        if(pageNum!=null){
            PageVo pVo = (PageVo) session.getAttribute("pVo");
            pVo.setNow_page(pageNum);
            session.setAttribute("pVo",pVo);
        }
        return "type";
    }


    @RequestMapping("/toDetail")
    public String toDetail() {
        return "content/detail";
    }

    @RequestMapping("/toMyInfo")
    public String toMyInfo(HttpSession session) {

        User user = (User) session.getAttribute("user");
        ArrayList<HistoryVo> historylist = contentService.getHistoryById(user.getId());

        session.setAttribute("historylist", historylist);

        return "myInfo/MyInfo";
    }

    @RequestMapping("/toFavinfo")
    public String toFavinfo(Integer pageNum,HttpSession session) {
        if(pageNum!=null){
            PageVo pVo = (PageVo) session.getAttribute("FavpVo");
            System.out.println("pagenum:"+pageNum);
            pVo.setNow_page(pageNum);
            session.setAttribute("FavpVo",pVo);
        }else {
            ArrayList<Course> favouritelist = (ArrayList<Course>) session.getAttribute("favouritelist");
            PageVo pVo = new PageVo();
            if (favouritelist != null) {
                pVo.setTotalList(favouritelist);
                pVo.setTotal_data_num(favouritelist.size());
                pVo.setPage_data_num(10);
            }
            session.setAttribute("FavpVo", pVo);
        }
        return "myInfo/favinfo";
    }

    @RequestMapping("/toOrderinfo")
    public String toOrderinfo(Integer pageNum,HttpSession session) {
        if(pageNum!=null){
            PageVo pVo = (PageVo) session.getAttribute("OrdpVo");
            System.out.println("pagenum:"+pageNum);
            pVo.setNow_page(pageNum);
            session.setAttribute("OrdpVo",pVo);
        }else {
            ArrayList<Course> orderlist = (ArrayList<Course>) session.getAttribute("orderlist");
            PageVo pVo = new PageVo();
            if (orderlist != null) {
                pVo.setTotalList(orderlist);
                pVo.setTotal_data_num(orderlist.size());
                pVo.setPage_data_num(8);
            }
            session.setAttribute("OrdpVo", pVo);
        }
        return "myInfo/ordinfo";
    }

    @RequestMapping("/toUserManager")
    public String toUserManager(String search,Integer pageNum,HttpSession session) {
        if(pageNum!=null){
            PageVo pVo = (PageVo) session.getAttribute("UserpVo");
            System.out.println("pagenum:"+pageNum);
            pVo.setNow_page(pageNum);
            session.setAttribute("UserpVo",pVo);
        }else {
            if(search==null){
                search = "";
            }
            ArrayList<User> userlist = userService.findAll(search);
            PageVo pVo = new PageVo();
            if (userlist != null) {
                pVo.setTotalList(userlist);
                pVo.setTotal_data_num(userlist.size());
                pVo.setPage_data_num(8);
            }
            session.setAttribute("UserpVo", pVo);
        }
        return "myInfo/userManager";
    }

    @RequestMapping("/toCourseManager")
    public String toCourseManager(String search,Integer pageNum,HttpSession session) {
        if(pageNum!=null){
            PageVo pVo = (PageVo) session.getAttribute("CoursepVo");
            System.out.println("pagenum:"+pageNum);
            pVo.setNow_page(pageNum);
            session.setAttribute("CoursepVo",pVo);
        }else {
            if(search==null){
                search = "";
            }
            ArrayList<Course> courselist = courseService.findAll(search);
            PageVo pVo = new PageVo();
            if (courselist != null) {
                pVo.setTotalList(courselist);
                pVo.setTotal_data_num(courselist.size());
                pVo.setPage_data_num(8);
            }
            session.setAttribute("CoursepVo", pVo);
        }
        return "myInfo/courseManager";
    }

    @RequestMapping("/toUpdate")
    @ResponseBody
    public Course toUpdate(Integer count,HttpSession session) {
        PageVo coursepVo = (PageVo) session.getAttribute("CoursepVo");
        Course course = (Course) coursepVo.getPageList().get(count - 1);

        return course;
    }

    @RequestMapping("/toContentManager")
    public String toContentManager(int courseId,Integer pageNum,HttpSession session) {
        if(pageNum!=null){
            PageVo pVo = (PageVo) session.getAttribute("ContentpVo");
            System.out.println("pagenum:"+pageNum);
            pVo.setNow_page(pageNum);
            session.setAttribute("ContentpVo",pVo);
        }else {
            ArrayList<Content> contentlist = contentService.findAllByCourseId(courseId);
            PageVo pVo = new PageVo();
            if (contentlist != null) {
                pVo.setTotalList(contentlist);
                pVo.setTotal_data_num(contentlist.size());
                pVo.setPage_data_num(8);
            }
            session.setAttribute("ContentpVo", pVo);
        }
        return "myInfo/contentManager";
    }

    @RequestMapping("/toUpdate2")
    @ResponseBody
    public Content toUpdate2(Integer count,HttpSession session) {
        PageVo contentpVo = (PageVo) session.getAttribute("ContentpVo");
        Content content = (Content) contentpVo.getPageList().get(count - 1);

        return content;
    }
}
