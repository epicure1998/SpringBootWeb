package com.qiumengke.Dao;

import com.qiumengke.pojo.Department;
import com.qiumengke.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees=null;

    static{
        employees=new HashMap<Integer, Employee>();
        employees.put(001,new Employee(001,"张三","2dadasd@qq.com",1,new Department(101,"开发部")));
        employees.put(002,new Employee(002,"李四","2ddasdasd@qq.com",0,new Department(101,"开发部")));
        employees.put(003,new Employee(003,"王五","2daddsadasd@qq.com",1,new Department(101,"开发部")));
        employees.put(004,new Employee(004,"赵六","2dadsdasd@qq.com",1,new Department(101,"开发部")));
        employees.put(005,new Employee(005,"孙七","2dadsdasd@qq.com",0,new Department(101,"开发部")));
        employees.put(006,new Employee(006,"临八","2dadadssd@qq.com",1,new Department(101,"开发部")));
    }

    public Employee getEmployeeById(int i){
       return employees.get(i);
    }

    public Collection<Employee> getAllEmployees(){
        return employees.values();
    }

    public void updateEmployee(Employee employee){
        employees.replace(employee.getId(),employee);
    }

    public void delete(Integer i){
        employees.remove(i);
    }

    public void insert(Employee employee){
        employees.put(employee.getId(),employee);

    }
}
