package com.cm.dao;

import com.cm.entity.Employee;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

public interface EmployeeDao {
    //添加
    void addemployee(Employee employee) throws InvocationTargetException, IllegalAccessException, SQLException, NoSuchMethodException;

}
