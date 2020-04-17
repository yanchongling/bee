package com.bee.manage.controller;


import com.bee.manage.entity.BeRoleSys;
import com.bee.manage.service.IBeRoleSysService;
import com.bee.manage.service.impl.BeRoleSysServiceImpl;
import com.bee.manage.vo.JsonReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
}
