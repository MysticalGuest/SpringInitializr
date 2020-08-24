package com.initializr.controller;

import com.initializr.bean.Department;
import com.initializr.bean.Employee;
import com.initializr.mapper.DepartmentMapper;
import com.initializr.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDepartment(Department department){
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping("/mybatis/employee/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id){
        return employeeMapper.getEmployeeById(id);
    }
}
