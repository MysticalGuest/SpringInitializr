package com.initializr.controller;

import com.initializr.dao.DepartmentDao;
import com.initializr.dao.EmployeeDao;
import com.initializr.entities.Department;
import com.initializr.entities.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    // 查询所有员工返回列表页面
    @GetMapping("/list")
    public String list(Model model){
        LOG.info("/list...");
        Collection<Employee> employees = employeeDao.getAll();
        // 放在请求域中
        model.addAttribute("employees", employees);
        // thymeleaf默认就会拼串
        // classpath::/templates/*.html
        return "list";
    }

    // 来到员工添加页面
    @GetMapping("/addEmployeePage")
    public String addEmployeePage(Model model){
        LOG.info("/addEmployeePage...");
        // 查出所有的部门在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "editEmployeePage";
    }

    // 员工添加
    /** SpringMVC自动将请求参数和入参对象的属性一一绑定
     * 要求了请求参数的名字和javaBean入参的对象里面的额属性名是一样的
     * @param employee
     * @return
     */
    @PostMapping("/addEmployee")
    public String addEmployee(Employee employee){
        LOG.info("/addEmployee...");
        // 查出所有的部门在页面显示
        LOG.info(employee.toString());
        // 保存员工
        employeeDao.save(employee);
        // 来到员工列表页面
        // redirect: 重定向到一个地址
        // forward: 转发到一个地址
        return "redirect:/list";
    }

    // 来到修改页面，查出当前员工信息，在页面回显
    @GetMapping("/employee/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        LOG.info("/employee/{id}...");
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);

        return "editEmployeePage";
    }

    // 员工修改，需要提交原id
    @PutMapping("/employee/updateEmployee")
    public String updateEmployee(Employee employee){
        LOG.info("updateEmployee...");
        LOG.info(employee.toString());
        employeeDao.save(employee);
        return "redirect:/list";
    }

    // 员工删除
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/list";
    }
}
