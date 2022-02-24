package com.cm.dao.impl;

import com.cm.dao.EmployeeDao;
import com.cm.entity.Employee;
import com.cm.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import java.sql.Connection;
import java.sql.SQLException;
public class EmployeeDaoImpl implements EmployeeDao {
    //添加员工
    @Override
    public void addemployee(Employee employee) throws  SQLException {
        QueryRunner queryRunner = new QueryRunner();
        //获取连接
        Connection conn = JDBCUtil.getConnection();
        //SQL语句
        System.out.println(employee);
        String sql = "INSERT INTO employee_inf(NAME,CARD_ID,SEX,JOB_ID,EDUCATION,EMAIL,PHONE,TEL,PARTY,QQ_NUM,ADDRESS,POST_CODE,BIRTHDAY,RACE,SPECIALITY,HOBBY,DEPT_ID,REMARK) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
       // int i = queryRunner.update(conn, sql,name,card_id,sex,job_id,education,email,phone,tel,party,qq_num,address,post_code,birthday,race,speciality,hobby,dept_id,remark);
        int i = queryRunner.update(conn, sql,employee.getName(),employee.getCard_id(),employee.getSex(),employee.getJob_id(),employee.getEducation(),employee.getEmail(),employee.getPhone(),employee.getTel(),employee.getParty(),employee.getQq_num(),employee.getAddress(),employee.getPost_code(),employee.getBirthday(),employee.getRace(),employee.getSpeciality(),employee.getHobby(),employee.getDept_id(),employee.getRemark());
        System.out.println("添加成功"+i);
    }
}
