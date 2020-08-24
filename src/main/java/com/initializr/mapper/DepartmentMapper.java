package com.initializr.mapper;

import com.initializr.bean.Department;
import org.apache.ibatis.annotations.*;

// 指定这是一个操作数据库的mapper
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    /*
    useGeneratedKeys = true: 使用自动生成的主键
    keyProperty = "id": 指明主键字段, id属性式用来封装主键的
    插入的department后, 主键会重新封装进来, 才会有值
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    public int updateDept(Department department);

}
