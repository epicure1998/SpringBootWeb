package com.qiumengke.Controller;


import com.qiumengke.Dao.DepartmentDao;
import com.qiumengke.Dao.EmployeeDao;
import com.qiumengke.Mapper.DepartmentMapper;
import com.qiumengke.Mapper.EmployeeMapper;
import com.qiumengke.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class EmployeeController {
    @Autowired
    EmployeeMapper employeeMapper;
//    @Autowired
//    EmployeeDao employeeDao;
//    @Autowired
//    DepartmentDao departmentDao;
    @Autowired
    DepartmentMapper departmentMapper;


    @RequestMapping("/emps")
    public String employee(Model model) {
         //model.addAttribute("employees", employeeDao.getAllEmployees());
        model.addAttribute("employees",  employeeMapper.getAllEmployees());
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        model.addAttribute("departments",departmentMapper.getAllDepartments());
        System.out.println("dasdasfsdfasdf");
        return "emp/addEmp";
    }

    @PostMapping("/emp")
    public String doAddEmp(Employee employee) {
        //System.out.println(employee);
        employee.setDepartment(departmentMapper.getDepartment(employee.getDepartment().getId()));
        System.out.println(employee);
        employeeMapper.insert(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toUpdatePage(@PathVariable("id")Integer id, Model model){
        model.addAttribute("employee",employeeMapper.getEmployeeById(id));
        model.addAttribute("departments",departmentMapper.getAllDepartments());
        System.out.println("as");
        return "emp/update";
    }

    @PostMapping("/emp/{id}")
    public String doUpdatePage(@PathVariable("id")Integer id,Employee employee){

        employee.setDepartment(departmentMapper.getDepartment(employee.getDepartment().getId()));
        employeeMapper.updateEmployee(employee);
        System.out.println(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/delete/{id}")
    public String deleteEmployee(@PathVariable("id")Integer id){
        System.out.println("aaaaa");
        employeeMapper.delete(id);
        return "redirect:/emps";
    }
}
