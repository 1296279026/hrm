package com.cm.query;

import com.cm.dao.UserDao;
import com.cm.dao.impl.UserDaoImpl;
import com.cm.entity.User;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "QueryUser", value = "/queryUser.action")
public class QueryUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        UserDao userDao=new UserDaoImpl();

        String loginname = request.getParameter("loginname");
        String username = request.getParameter("username");
        System.out.println(loginname);
        System.out.println(username);
        try {
            List<User> users = userDao.query(loginname, username);
            request.setAttribute("userlist",users);
            //转发回去
            String prefix = "/WEB-INF/jsp/user/";
            String suffix = ".jsp";
            request.getRequestDispatcher(prefix + "userlist" + suffix).forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
