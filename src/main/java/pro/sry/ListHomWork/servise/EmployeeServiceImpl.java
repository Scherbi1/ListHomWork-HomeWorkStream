package pro.sry.ListHomWork.servise;

import org.springframework.stereotype.Service;
import pro.sry.ListHomWork.exceptions.EmployeeNotFoundException;
import pro.sry.ListHomWork.exceptions.EmployeeAlreadyAddedException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class  EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employeeList;

    public EmployeeServiceImpl(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }



    @Override
    public Employee add(String name, String surName, double salaryStaff, int departmentNumber) {

        Employee employee = new Employee(name, surName,salaryStaff,departmentNumber);

        if (!employeeList.add(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник есть уже в базе");
        } else {
            System.out.println("Сотрудник успешно добавлен");
            return employee;
        }
    }

    @Override
    public Employee remove(String name, String surName, double salaryStaff, int departmentNumber) {
        Employee employee = new Employee(name,surName, salaryStaff, departmentNumber);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            System.out.print("Сотрудник успешно удален из базы данных");
            return employee;
        }
          throw new EmployeeNotFoundException("Сотрудник успешно удален из базы");

    }

    @Override
    public  Employee find(String name, String surName, double salaryStaff, int departmentNumber)  {
        Employee employee = new Employee(name,surName, salaryStaff, departmentNumber);
        if (employeeList.contains(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("Сотрудник в базе не найдет");
        }
    }

    @Override
    public  List<Employee> findAll() {
        return employeeList;
    }

    public  List<Employee> findAllDepartment(int departmentNumber) {
        List<Employee> department = employeeList.stream()
                .filter((d)->d.getDepartmentNumber()==departmentNumber)
                .collect(Collectors.toList());
        return department;
    }

    public List<Employee> FindDepartmentMax(int departmentNumber) {
        employeeList.stream().
                filter(employee -> employee.getDepartmentNumber()!=departmentNumber)
                .findFirst()
                .orElseThrow(RuntimeException::new);
        List<Employee> e= employeeList.stream()
                .filter((d)->d.getDepartmentNumber()==departmentNumber)
                .max(Comparator.comparing(employee->employee.getSalaryStaff()))
                .stream().collect(Collectors.toList());
        return e;
    }
    public List<Employee> FindDepartmentMin(int departmentNumber) {
       employeeList.stream().
               filter(employee -> employee.getDepartmentNumber()!=departmentNumber)
               .findFirst()
               .orElseThrow(RuntimeException::new);
        List<Employee> e= employeeList.stream()
                .filter((d)->d.getDepartmentNumber()==departmentNumber)
                .min(Comparator.comparing(employee->employee.getSalaryStaff()))
                .stream().collect(Collectors.toList());
        return e;
    }
}
