package com.cm.web;

import com.cm.dao.UserDao;
import com.cm.dao.impl.UserDaoImpl;
import com.cm.entity.Dept;
import com.cm.entity.Job;
import com.cm.entity.User;
import com.cm.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


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
                    //把工作职位存到session域中
                    {
                        QueryRunner queryRunner = new QueryRunner();
                        //获取连接
                        Connection conn = null;
                        try {
                            conn = JDBCUtil.getConnection();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        //SQL语句
                        String sql = "SELECT * FROM job_inf";
                        List<Job> jobList = null;
                        try {
                            jobList = queryRunner.query(conn, sql, new BeanListHandler<Job>(Job.class));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        System.out.println(jobList);
                        HttpSession session = req.getSession();
                        session.setAttribute("jobList", jobList);}
                    //把部门存到session域中
                    {
                        QueryRunner queryRunner2 = new QueryRunner();
                        //获取连接
                        Connection conn2 = null;
                        try {
                            conn2 = JDBCUtil.getConnection();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        //SQL语句
                        String sql2 = "SELECT * FROM dept_inf";
                        List<Dept> deptList = null;
                        try {
                            deptList = queryRunner2.query(conn2, sql2, new BeanListHandler<Dept>(Dept.class));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        System.out.println(deptList);
                        HttpSession session = req.getSession();
                       session.setAttribute("deptList", deptList);
                    }
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
