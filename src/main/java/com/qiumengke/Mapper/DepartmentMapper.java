package com.qiumengke.Mapper;

import com.qiumengke.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDepartment(int id);

    @Select("select id, departmentName from department")
    public Collection<Department> getAllDepartments();

    public void updateDepartment(Department department);

    public void insert(Department department);

}
