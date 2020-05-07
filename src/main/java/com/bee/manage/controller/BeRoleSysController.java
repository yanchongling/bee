package com.bee.manage.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bee.manage.entity.BeRoleSys;
import com.bee.manage.service.IBeRoleSysService;
import com.bee.manage.service.impl.BeRoleSysServiceImpl;
import com.bee.manage.vo.JsonReturn;
import com.sun.xml.internal.ws.api.pipe.TubelineAssembler;
import javafx.scene.input.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 管理员信息 前端控制器
 * </p>
 *
 * @author be
 * @since 2020-04-16
 */
@RestController
@RequestMapping("/manage/be-role-sys")
public class BeRoleSysController {
    @Resource
    IBeRoleSysService iBeRoleSysService=new BeRoleSysServiceImpl();

    @RequestMapping("/form")
    @ResponseBody
    public JsonReturn checkRole(HttpServletRequest Request, HttpServletResponse response){
        JsonReturn jsonReturn=new JsonReturn();
        try {
            String username = Request.getParameter("username");
            String password = Request.getParameter("password");
            BeRoleSys role=new BeRoleSys();
            role.setUsername(username);
            role.setPassword(password);
            boolean result = iBeRoleSysService.isRole(role);
            if (result){
                jsonReturn.setSuccess(true);
                response.sendRedirect("http://localhost:8080/index");
            }else {
                response.sendError(404);
                jsonReturn.setSuccess(false);
                jsonReturn.setError("登入异常");
            }

        } catch (IOException e) {
            e.printStackTrace();
            jsonReturn.setSuccess(false);

            jsonReturn.setError("登入异常");
        }
        return jsonReturn;
    }
    //{pageIndex},@PathVariable int pageIndex
    @RequestMapping(value = "/findRole",method = RequestMethod.POST)
    @ResponseBody
    public IPage findRoleList(HttpServletResponse response ,HttpServletRequest request){
        IPage iPage = null;
        Page<BeRoleSys> page=new Page();
        Long curr = Long.valueOf(request.getParameter("curr"));
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        if (!StringUtils.isEmpty(curr)){
            page.setCurrent(curr);
        }
        try {
            if (StringUtils.isEmpty(end)&&!StringUtils.isEmpty(start)){
                iPage = findRoleStart(request, response);
            }else if (StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
                iPage = findRoleEnd(request, response);
            }else if (!StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
                
            }else {
                iPage = iBeRoleSysService.findRoleList(page);
            }
          
            if (!StringUtils.isEmpty(iPage)){
                return iPage;
            }else {
                response.sendError(404);
                return null;
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value = "/start",method = RequestMethod.POST)
    @ResponseBody
    public IPage findRoleStart(HttpServletRequest request,HttpServletResponse response){
        String start = request.getParameter("start");
        Page<BeRoleSys> page=new Page();
        try {
            if (StringUtils.isEmpty(start)){
                response.sendError(404);
                return null;
            }else {
                IPage roleStart = iBeRoleSysService.findRoleStart(page, start);
                return roleStart;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value = "/valueEnd", method = RequestMethod.POST)
    @ResponseBody
    public IPage findRoleEnd(HttpServletRequest request,HttpServletResponse response){
        String end = request.getParameter("end");
        Page<BeRoleSys> page=new Page();
        try {
            if (StringUtils.isEmpty(end)){
                response.sendError(404);
                return null;
            }else {
                IPage roleStart = iBeRoleSysService.findRoleEnd(page, end);
                return roleStart;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/username", method = RequestMethod.POST)
    @ResponseBody
    public List findRoleName(HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("username");
        Page<BeRoleSys> page=new Page();
        try {
            if (StringUtils.isEmpty(username)){
                response.sendError(404);
                return null;
            }else {
                List roleStart = iBeRoleSysService.findRoleName(page, username);
                return roleStart;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value = "/insertRole", method = RequestMethod.POST)
    @ResponseBody
    public Boolean insertRole(HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Page<BeRoleSys> page=new Page();
             iBeRoleSysService.insertRole(username,password,email);
             response.setStatus(200);
           return true;
    }
}
