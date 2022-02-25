package com.cm.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Usercon", value = "/useradd.action")
public class Usercon extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //转发到添加页面
        request.setCharacterEncoding("utf-8");
        String prefix = "/WEB-INF/jsp/user/";
        String suffix = ".jsp";
        request.getRequestDispatcher(prefix+"useradd"+suffix).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }
}
