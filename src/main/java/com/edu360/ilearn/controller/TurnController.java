package com.edu360.ilearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TurnController {
    @RequestMapping("/toLogin")
    public String toLogin() {
        System.out.println(123);
        return "common/login";
    }

    @RequestMapping("/toRegister")
    public String toRegister() {
        System.out.println(123);
        return "common/register";
    }


    //    @RequestMapping("/toTest")
//    public String toTest(){
//        System.out.println(123);
//        return "test";
//    }

    @RequestMapping("/toIndex")
    public String toIndex() {
        System.out.println(123);
        return "common/index";
    }

    @RequestMapping("/toTop")
    public String toTop() {
        return "common/top";
    }

    @RequestMapping("/toHome")
    public String toHome() {
        return "common/home";
    }

    @RequestMapping("/toBottom")
    public String toBottom() {
        return "common/bottom";
    }



    @RequestMapping("/toSearch")
    public String toSearch() {
        return "search";
    }
}
