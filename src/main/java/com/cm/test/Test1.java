package com.cm.test;

import com.cm.entity.User;
import com.cm.utils.JDBCUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class Test1 {
    public static void main(String[] args) {
        try {
            System.out.println(JDBCUtil.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void fun1() throws SQLException {

        QueryRunner queryRunner=new QueryRunner();

        Connection conn = JDBCUtil.getConnection();

        String sql="insert into user_inf (loginname,password,status,username) values(?,?,?,?)";

        queryRunner.update(conn,sql,"ccccmm","123456","2","BOSS");


    }
    @Test
    public void fun2() throws SQLException {

        QueryRunner queryRunner=new QueryRunner();
        //获取连接
        Connection conn = JDBCUtil.getConnection();
        //SQL语句
        String sql="SELECT * FROM user_inf WHERE loginname=? AND password=?";
        User query = queryRunner.query(conn, sql, new BeanHandler<User>(User.class), "chenming","123");

        if (query==null){

        }else {
            System.out.println(query);
            System.out.println("登录成功");
        }


    }

    @Test
    public void fun3(){
        User user=new User();
        //BeanUtils.populate();

    }
}
