package pro.sry.ListHomWork.servise;

import java.util.List;

public interface DepartmentService {
    List<Employee> findAllDepartment(int departmentNumber);

    List<Employee> FindDepartmentMax(int departmentNumber);

    List<Employee> FindDepartmentMin(int departmentNumber);
}
