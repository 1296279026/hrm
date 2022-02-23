package com.cm.dao;

import com.cm.entity.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

public interface UserDao {
    //登录
    User login(String loginname, String password) throws Exception;
    //添加
    void adduser(Map<String, String[]> map) throws SQLException, InvocationTargetException, IllegalAccessException, NoSuchMethodException;

}
