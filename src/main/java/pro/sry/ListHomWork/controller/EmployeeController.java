package pro.sry.ListHomWork.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sry.ListHomWork.servise.Employee;
import pro.sry.ListHomWork.servise.EmployeeService;

import java.util.List;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String name, @RequestParam String surName,@RequestParam double salaryStaff,@RequestParam int departmentNumber) {
        System.out.println( );
        return service.add(name, surName,salaryStaff,departmentNumber);
    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String name, @RequestParam String surName,@RequestParam double salaryStaff,@RequestParam int departmentNumber) {
        return service.remove(name, surName,salaryStaff,  departmentNumber);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String name, @RequestParam String surName,@RequestParam double salaryStaff,@RequestParam int departmentNumber) {
        return service.find(name, surName, salaryStaff,  departmentNumber);
    }
    @GetMapping("/findAll")
    public List<Employee> findAll() {
        return service.findAll();
    }
    @GetMapping("/findAll/department")
    public List<Employee>findAllDepartment(@RequestParam  int departmentNumber){
        return service.findAllDepartment(departmentNumber);
    }
    @GetMapping("/findAll/department/Max-salary")
    public List<Employee>FindDepartmentMax(@RequestParam int departmentNumber) {
        return service.FindDepartmentMax(departmentNumber);
    }
    @GetMapping("/findAll/department/Min-salary")
    public List<Employee>FindDepartmentMin(@RequestParam int departmentNumber) {
        return service.FindDepartmentMin(departmentNumber);
    }
}
