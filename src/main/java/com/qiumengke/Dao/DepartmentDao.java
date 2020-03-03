package com.qiumengke.Dao;

import com.qiumengke.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
@Repository
public class DepartmentDao {
    //模拟数据库的数据
    private static Map<Integer, Department> departments=null;

    static {
    departments=new HashMap<>();
    departments.put(1001,new Department(1001,"软件开发部"));
    departments.put(1002,new Department(1002,"人力资源部"));
    departments.put(1003,new Department(1003,"财务部"));
    departments.put(1004,new Department(1004,"董事办"));
    departments.put(1005,new Department(1005,"采办部"));
    }

    public Department getDepartment(int i){
        return departments.get(i);
    }

    public void deleteDepartment(int i){
        departments.remove(i);
        System.out.println(departments.toString());
    }

    public Collection<Department> getAllDepartments(){
        return departments.values();
    }

    public void updateDepartment(Department department){
        departments.replace(department.getId(),department);
    }
    public void insert(Department department){
        departments.put(department.getId(),department);
    }


}
