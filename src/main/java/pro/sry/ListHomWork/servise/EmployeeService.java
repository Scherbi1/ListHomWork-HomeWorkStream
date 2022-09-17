package pro.sry.ListHomWork.servise;

import java.util.List;

public interface EmployeeService {


    Employee add(String name, String surName, double salaryStaff, int departmentNumber);
    Employee remove(String name, String surName,double salaryStaff, int departmentNumber);
    Employee find(String name, String surName,double salaryStaff, int departmentNumber);

   List<Employee> findAll();

    List<Employee> findAllDepartment(int departmentNumber);

    List<Employee> FindDepartmentMax(int departmentNumber);

    List<Employee> FindDepartmentMin(int departmentNumber);
}
