package com.qiumengke;


import com.qiumengke.Mapper.DepartmentMapper;
import com.qiumengke.Mapper.EmployeeMapper;
import com.qiumengke.pojo.Department;
import com.qiumengke.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    JavaMailSenderImpl mailSender;
//    @Autowired
//    DepartmentMapper departmentMapper;
    @Test
    void contextLoads() throws SQLException {
      //  System.out.println(dataSource.getConnection());

        //System.out.println(employeeMapper.getAllEmployees());
        for(Employee employee : employeeMapper.getAllEmployees()){
            System.out.println(employee);
        }
        //System.out.println(employeeMapper.getEmployeeById(1).toString());
//        System.out.println(departmentMapper.getDepartment(1001));
//        for(Department department: departmentMapper.getAllDepartments())
//            System.out.println(department);
    }

//    @Test
//    void test01(){
//        System.out.println(departmentMapper.getAllDepartments());
//        //System.out.println(employeeMapper.getAllEmployees());
//    }

    @Test
    void insertTest(){
        Employee employee=new Employee(10,"xiaotiant","xiaotian@qq.com",1,departmentMapper.getDepartment(1001));
        employeeMapper.insert(employee);
    }

    @Test
    void updateTest(){
        Employee employee=new Employee(10,"毕竟我是最菜的","xiaotian@qq.com",1,departmentMapper.getDepartment(1003));
        employeeMapper.updateEmployee(employee);
    }

    @Test
    void deleteTest(){
        employeeMapper.delete(10);
    }

    @Test
    void selectByIdTest(){
        System.out.println(employeeMapper.getEmployeeById(1));
    }

    @Test
    public void mailTest(){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setSubject("malicious attack!");
        simpleMailMessage.setText("This is an attack mail");
        simpleMailMessage.setTo("304858505@qq.com");
        simpleMailMessage.setFrom("dasdasda@qq.com");
            mailSender.send(simpleMailMessage);
    }


}
