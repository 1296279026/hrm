package com.cm.web;

import com.cm.dao.UserDao;
import com.cm.dao.impl.UserDaoImpl;
import com.cm.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao user = new UserDaoImpl();
        //接收请求路径
        String servletPath = req.getServletPath();
        //接收账号密码
        String loginname = req.getParameter("loginname");
        String password = req.getParameter("password");

        try {
            User user1 = user.login(loginname, password);
            if (servletPath.equals("/login")) {
                if (user1 != null) {
                    // System.out.println("成功");
                    req.getSession().setAttribute("user_sess", user1);
                    resp.sendRedirect("main.action");

                } else {
                    // System.out.println("失败");
                    req.setAttribute("message", "用户名或密码不正确");
                    req.getRequestDispatcher("loginForm.jsp").forward(req, resp);
                }
            } else {
                //注销
                req.getSession().invalidate();
                resp.sendRedirect(req.getContextPath() + "/loginForm.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
