package com.cm.dao.impl;

import com.cm.dao.EmployeeDao;
import com.cm.entity.Employee;
import com.cm.utils.JDBCUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.dbutils.QueryRunner;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;

public class EmployeeDaoImpl implements EmployeeDao {
    //添加员工
    @Override
    public void addemployee(Map<String, String[]> map) throws InvocationTargetException, IllegalAccessException, SQLException, NoSuchMethodException {

        QueryRunner queryRunner = new QueryRunner();
        //获取连接
        Connection conn = JDBCUtil.getConnection();
        //传进来的map
        Employee employee=new Employee();
        BeanUtils.populate(employee, map);


        String name = BeanUtils.getProperty(employee, "name");
        String card_id = BeanUtils.getProperty(employee, "card_id");
        String sex = BeanUtils.getProperty(employee, "sex");
        String address = BeanUtils.getProperty(employee, "address");
        int job_id = Integer.parseInt(BeanUtils.getProperty(employee, "job_id"));
        int dept_id = Integer.parseInt(BeanUtils.getProperty(employee, "dept_id"));
        int id = Integer.parseInt(BeanUtils.getProperty(employee, "id"));
        String post_code = BeanUtils.getProperty(employee, "post_code");
        String tel = BeanUtils.getProperty(employee, "tel");
        String phone = BeanUtils.getProperty(employee, "phone");
        String qq_num = BeanUtils.getProperty(employee, "qq_num");
        String email = BeanUtils.getProperty(employee, "email");
        String party = BeanUtils.getProperty(employee, "party");
        String birthday = BeanUtils.getProperty(employee, "birthday");
        String race = BeanUtils.getProperty(employee, "race");
        String education = BeanUtils.getProperty(employee, "education");
        String speciality = BeanUtils.getProperty(employee, "speciality");
        String hobby = BeanUtils.getProperty(employee, "hobby");
        String remark = BeanUtils.getProperty(employee, "remark");





    }
}
