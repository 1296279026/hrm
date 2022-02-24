package com.cm.query;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "queryUser.action", urlPatterns ={ "/userlist.action"})
public class QueryUseraction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String prefix = "/WEB-INF/jsp/user/";
        String suffix = ".jsp";
        request.getRequestDispatcher(prefix + "userlist" + suffix).forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }
}
