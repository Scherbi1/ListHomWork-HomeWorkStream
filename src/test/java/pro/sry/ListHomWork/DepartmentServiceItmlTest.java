package pro.sry.ListHomWork;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import pro.sry.ListHomWork.exceptions.EmployeeNotFoundException;
import pro.sry.ListHomWork.servise.DeparnmentServiceImpl;
import pro.sry.ListHomWork.servise.Employee;
import pro.sry.ListHomWork.servise.EmployeeService;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceItmlTest {
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DeparnmentServiceImpl out;
    Employee employee1 = new Employee("Илья", "Щербаков", 200_000, 1);
    Employee employee2 = new Employee("Виталий", "Малахов", 150_000, 2);
    Employee employee3 = new Employee("Дмитрий", "Комаров", 100_000, 1);
    Set<Employee> employees = Set.of(employee1,employee3);


    @Test
    public void shouldFindEmployeeMaxSalaryDepartment(){
        when(employeeService.findAll()).thenReturn((List<Employee>) employees);
        assertEquals(employee1, out.FindDepartmentMax(1 ));
    }

    @Test
    public void shouldFindEmployeeMinSalaryDepartment(){
        when(employeeService.findAll()).thenReturn((List<Employee>) employees);
        assertEquals(employee3, out.FindDepartmentMin(1 ));
    }
   @Test
    public void shouldThrowEmployeeMaxSalary() {
      when(employeeService.findAll()).thenReturn((List<Employee>) employees);
      assertThrows(EmployeeNotFoundException.class,()->out.FindDepartmentMax(1 ));

   }
    @Test
    public void shouldThrowEmployeeMinSalary() {
        when(employeeService.findAll()).thenReturn((List<Employee>) employees);
        assertThrows(EmployeeNotFoundException.class,()->out.FindDepartmentMin(1 ));

    }
}
