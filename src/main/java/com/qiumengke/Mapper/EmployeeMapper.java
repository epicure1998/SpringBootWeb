package com.qiumengke.Mapper;

import com.qiumengke.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Mapper
@Repository
public interface EmployeeMapper {


     Employee getEmployeeById(int id);

    Collection<Employee> getAllEmployees();

     void updateEmployee(Employee employee);

     void delete(Integer i);

     void insert(Employee employee);
}
