package com.cm.dao;

import com.cm.entity.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //登录
    User login(String loginname, String password) throws Exception;
    //添加
    int adduser(User user) throws SQLException, InvocationTargetException, IllegalAccessException, NoSuchMethodException;
    //数据展示
    List<User> show() throws SQLException;
    //查询
    List<User>  query(String loginname,String username) throws SQLException;
}
