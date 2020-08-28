package com.initializr.service;

import com.initializr.bean.Department;
import com.initializr.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

//    @Cacheable(cacheNames = "dept", key = "#id")
//    @Cacheable(cacheNames = {"dept", "tdept"}, key = "#id") 多缓存名
//    @Cacheable(cacheNames = "dept", key = "#root.args[0]", condition = "#id>0")
//    @Cacheable(cacheNames = "dept", key = "#root.args[0]", unless = "#result == null")
    @Cacheable(cacheNames = "dept", key = "#root.args[0]")
    public Department getDepartment(Integer id){
        System.out.println("查询"+id+"号部门");
        Department dept = departmentMapper.getDeptById(id);
        return dept;
    }
}
