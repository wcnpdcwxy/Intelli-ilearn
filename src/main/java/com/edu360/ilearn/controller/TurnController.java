package com.edu360.ilearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TurnController {
    @RequestMapping("/toLogin")
    public String toLogin(){
        System.out.println(123);
        return "login";
    }

    @RequestMapping("/toIndex")
    public String toIndex(){
        System.out.println(123);
        return "index";
    }

    @RequestMapping("/toTest")
    public String toTest(){
        System.out.println(123);
        return "test";
    }


    @RequestMapping("/toTop")
    public String toTop(){
        return "top";
    }

    @RequestMapping("/toNavigation")
    public String toNavigation(){
        return "navigation";
    }

    @RequestMapping("/toDynmsn")
    public String toDynmsn(){
        return "dynmsn";
    }
}
