package com.bjpowernode.crm.setting.web.controller;

import com.bjpowernode.crm.setting.domain.User;
import com.bjpowernode.crm.setting.service.UserService;
import com.bjpowernode.crm.setting.service.impl.UserServiceImpl;
import com.bjpowernode.crm.utils.MD5Util;
import com.bjpowernode.crm.utils.PrintJson;
import com.bjpowernode.crm.utils.ServiceFactory;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到用户控制器");
        String path = request.getServletPath();
        if("/setting/user/login.do".equals(path)){
            login(request,response);
        }else if("/settings/user/xxx.do".equals(path)){

        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入到登录验证操作");
        String  loginAct = request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");
        String ip = request.getRemoteAddr();
        System.out.println("------------ip:"+ip);
        UserService us = (UserService)ServiceFactory.getService(new UserServiceImpl());

        User user = null;
        try {
            user = us.login(loginAct,loginPwd,ip);
            request.getSession().setAttribute("user",user);
            PrintJson.printJsonFlag(response,true);
        } catch (LoginException e) {
            e.printStackTrace();
            String msg = e.getMessage();
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("success",false);
            map.put("msg",msg);
            PrintJson.printJsonObj(response,map);
        }

    }
}
