package com.bee.manage.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bee.manage.entity.BeRoleSys;
import com.bee.manage.service.IBeRoleSysService;
import com.bee.manage.service.impl.BeRoleSysServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author yan
 */
@Controller
public class BebeeController {
    @Resource
    IBeRoleSysService iBeRoleSysService=new BeRoleSysServiceImpl();
    @RequestMapping("/login")
    public String login(HttpServletRequest httpServletRequest){
        return "/login";
    }
    @RequestMapping("/index")
    public String index(){
        return "/index";
    }
    @RequestMapping(value = "/admin-list")
    public String adminList(Model model, Page<BeRoleSys>page, HttpServletRequest request){
        Long curr=1L;
        if (!StringUtils.isEmpty(request.getParameter("curr"))){
            curr = Long.valueOf(request.getParameter("curr"));
        }

        list(model,page,request,curr);
        return "/admin-list";
    }

    @ResponseBody
    private void list(Model model, Page<BeRoleSys>page,HttpServletRequest request,Long curr) {
        if (StringUtils.isEmpty(curr)){
            page.setCurrent(curr);
        }
        try {   //当前页
            IPage roleList = iBeRoleSysService.findRoleList(page);

            model.addAttribute("roleList",roleList.getRecords());
            model.addAttribute("total",roleList.getTotal());
            model.addAttribute("pages",roleList.getPages());
            model.addAttribute("size",roleList.getSize());
            model.addAttribute("current",roleList.getCurrent());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/admin-edit")
    public String adminEdit(HttpServletRequest request){
        return "/admin-edit";
    }
    @RequestMapping("/admin-add")
    public String adminAdd(HttpServletRequest request){
        return "/admin-add";
    }

}
