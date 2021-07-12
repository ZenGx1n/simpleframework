package com.imooc.controller;

import com.imooc.controller.frontend.MainPageController;
import com.imooc.controller.superadmin.HeadLineOperationController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        String servletPath = req.getServletPath();
        String method = req.getMethod();

        if ("/frontend/getmainpageinfo".equals(servletPath) && "GET".equals(method)) {
            new MainPageController().getMainPageInfo(req, resp);
        } else if ("/superadmin/addheadline".equals(servletPath) && "POST".equals(method)) {
            new HeadLineOperationController().addHeadLine(req, resp);
        }
    }

}