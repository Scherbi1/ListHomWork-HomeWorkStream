package pro.sry.ListHomWork;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sry.ListHomWork.exceptions.EmployeeAlreadyAddedException;
import pro.sry.ListHomWork.exceptions.EmployeeNotFoundException;
import pro.sry.ListHomWork.servise.Employee;
import pro.sry.ListHomWork.servise.EmployeeService;
import pro.sry.ListHomWork.servise.EmployeeServiceImpl;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceItmlTest {
    Employee employee1 = new Employee("Илья", "Щербаков", 100_000, 1);
    @Mock
    private EmployeeService employeeMock;

    @InjectMocks
    private EmployeeServiceImpl out;
    private int departmentNumber;

    @Test
   public void methodWhenAddRemoveAndFind() {
       when(employeeMock.add("Илья", "Щербаков", 10000, 1))
               .thenReturn(employee1);
       when(employeeMock.find("Илья", "Щербаков", 10000, 1))
               .thenReturn(employee1);
       when(employeeMock.remove("Илья", "Щербаков", 10000, 1))
               .thenReturn(employee1);

       assertEquals(employee1, out.add("Илья", "Щербаков", 10000, 1));
       assertEquals(employee1, out.find("Илья", "Щербаков", 10000, 1));
       assertEquals(employee1, out.remove("Илья", "Щербаков", 10000, 1));

       Mockito.verify(employeeMock, times(1)).add("Илья", "Щербаков", 10000, 1);
       Mockito.verify(employeeMock, times(1)).find("Илья", "Щербаков", 10000, 1);
       Mockito.verify(employeeMock, times(1)).remove("Илья", "Щербаков", 10000, 1);
   }


    @Test
    public void shouldReturnEmptyListWhenTeamsDontExist() {
        assertTrue(out.findAllDepartment(departmentNumber).isEmpty());
    }
}

