package com.cm.dao.impl;

import com.cm.dao.UserDao;
import com.cm.entity.User;
import com.cm.utils.JDBCUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    //登录
    @Override
    public User login(String loginname, String password) throws Exception {

        QueryRunner queryRunner = new QueryRunner();
        //获取连接
        Connection conn = JDBCUtil.getConnection();
        //SQL语句
        String sql = "SELECT * FROM user_inf WHERE loginname=? AND password=?";
        User user = queryRunner.query(conn, sql, new BeanHandler<User>(User.class), loginname, password);

        if (user == null) {

            return null;

        } else {
            return user;
        }
    }


    //添加
    @Override
    public void adduser(Map<String, String[]> map) throws SQLException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        QueryRunner queryRunner = new QueryRunner();
        //获取连接
        Connection conn = JDBCUtil.getConnection();
        //把传进来的map
        User user = new User();
        BeanUtils.populate(user, map);

        String username = BeanUtils.getProperty(user, "username");
        int status = Integer.parseInt(BeanUtils.getProperty(user, "status"));
        String loginname = BeanUtils.getProperty(user, "loginname");
        String password = BeanUtils.getProperty(user, "password");
        System.out.println(user);
        System.out.println(username + status + loginname + password);

        //SQL语句
        // INSERT INTO user_inf(username,status,loginname,password) VALUES('kdiojk',2,'chenmmm','jihuji');
        String sql = "INSERT INTO user_inf(username,status,loginname,password) VALUES(?,?,?,?)";
        int i = queryRunner.update(conn, sql, username, status, loginname, password);
        System.out.println(i);

    }
}
