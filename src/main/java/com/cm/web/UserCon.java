package com.cm.web;

import com.cm.dao.UserDao;
import com.cm.dao.impl.UserDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserCon", urlPatterns = {"/useradd.action"})
public class UserCon extends HttpServlet {
    UserDao userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int i = 0;
        //添加用户
        String prefix = "/WEB-INF/jsp/user/";
        String suffix = ".jsp";
        request.getRequestDispatcher(prefix + "useradd" + suffix).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
