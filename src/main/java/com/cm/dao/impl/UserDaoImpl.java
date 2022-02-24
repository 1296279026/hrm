package com.cm.dao.impl;

import com.cm.dao.UserDao;
import com.cm.entity.User;
import com.cm.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;


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
    public void adduser(User user) throws SQLException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        QueryRunner queryRunner = new QueryRunner();
        //获取连接
        Connection conn = JDBCUtil.getConnection();
        String sql = "INSERT INTO user_inf(username,status,loginname,password) VALUES(?,?,?,?)";
        int i = queryRunner.update(conn, sql, user.getUsername(), user.getStatus(), user.getLoginname(), user.getPassword());
        System.out.println(i);

    }
}
