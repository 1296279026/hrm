package com.cm.dao;

import com.cm.entity.Employee;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface EmployeeDao {
    //添加
    int addemployee(Employee employee) throws InvocationTargetException, IllegalAccessException, SQLException, NoSuchMethodException;

}
