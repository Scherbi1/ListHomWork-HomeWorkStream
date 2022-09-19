package pro.sry.ListHomWork.servise;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class DeparnmentServiceImpl implements DepartmentService {
    private final List<Employee> employeeList;

    public DeparnmentServiceImpl(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    @Override
    public List<Employee> findAllDepartment(int departmentNumber) {
        List<Employee> department = employeeList.stream()
                .filter((d)->d.getDepartmentNumber()==departmentNumber)
                .collect(Collectors.toList());
        return department;
    }
    @Override
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
    @Override
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
