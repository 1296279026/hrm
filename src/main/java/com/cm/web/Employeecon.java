package com.cm.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "Employeecon", value = "/employeeadd.action")
public class Employeecon extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String prefix = "/WEB-INF/jsp/employee/";
        String suffix = ".jsp";
        req.getRequestDispatcher(prefix + "employeeadd" + suffix).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
