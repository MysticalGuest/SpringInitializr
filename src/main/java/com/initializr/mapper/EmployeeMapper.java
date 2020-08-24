package com.initializr.mapper;

import com.initializr.bean.Employee;

// @Mapper或者@MapperScan将接口扫描装配到容器中
public interface EmployeeMapper {

    public Employee getEmployeeById(Integer id);

    public void insertEmployee(Employee employee);
}
