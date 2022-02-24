package com.cm.web;

import com.cm.dao.EmployeeDao;
import com.cm.dao.impl.EmployeeDaoImpl;
import com.cm.entity.Dept;
import com.cm.entity.Employee;
import com.cm.entity.Job;
import com.cm.utils.JDBCUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AddEmployee", value = {"/employee/addEmployee"})
public class AddEmployee extends HttpServlet {
    EmployeeDao employeeDao = new EmployeeDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String, String[]> map = req.getParameterMap();
        Employee employee = new Employee();
        try {
            BeanUtils.populate(employee, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        try {
            employeeDao.addemployee(employee);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        String prefix = "/WEB-INF/jsp/employee/";
        String suffix = ".jsp";
        req.getRequestDispatcher(prefix + "employeeadd" + suffix).forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
