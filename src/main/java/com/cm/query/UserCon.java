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

@WebServlet(name = "usercon", urlPatterns = {"/userlist.action"})
public class UserCon extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDaoImpl();
        //把直接展示数据存到session
        {
            try {
                List<User> users = userDao.show();
                req.setAttribute("userlist", users);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        req.setCharacterEncoding("utf-8");
        String prefix = "/WEB-INF/jsp/user/";
        String suffix = ".jsp";
        req.getRequestDispatcher(prefix + "userlist" + suffix).forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
