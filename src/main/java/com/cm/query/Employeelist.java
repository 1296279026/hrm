package com.cm.query;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Employeelist", value = "/employeelist.action")
public class Employeelist extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String prefix = "/WEB-INF/jsp/employee/";
        String suffix = ".jsp";
        request.getRequestDispatcher(prefix + "employeelist" + suffix).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }
}
