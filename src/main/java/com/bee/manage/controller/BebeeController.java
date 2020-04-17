package com.bee.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yan
 */
@Controller
public class BebeeController {

    @RequestMapping("/login")
    public String login(HttpServletRequest httpServletRequest){
        String s = "/views/login";
        return s;
    }
    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        return "/views/index";
    }
    @RequestMapping("/admin-list")
    public String adminList(HttpServletRequest request){
        return "/views/admin-list";
    }
    @RequestMapping("/admin-edit")
    public String adminEdit(HttpServletRequest request){
        return "/views/admin-edit";
    }
    @RequestMapping("/admin-add")
    public String adminAdd(HttpServletRequest request){
        return "/views/admin-add";
    }

}
