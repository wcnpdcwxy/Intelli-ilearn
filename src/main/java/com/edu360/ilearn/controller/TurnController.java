package com.edu360.ilearn.controller;

import com.edu360.ilearn.Tool.CreateLog;
import com.edu360.ilearn.Tool.HttpPostUtil;
import com.edu360.ilearn.Vo.CourseVo;
import com.edu360.ilearn.Vo.PageVo;
import com.edu360.ilearn.entity.pathTable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class TurnController {
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


//    @GetMapping("/toTest")
//    @ResponseBody
//    public String toTest(String date){
//        System.out.println(123);
////        CreateLog.createUserLog(date);
//        return "success";
//    }

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
}
