package com.cm.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

public interface EmployeeDao {
    //添加
    void addemployee(Map<String, String[]> map) throws InvocationTargetException, IllegalAccessException, SQLException, NoSuchMethodException;

}
