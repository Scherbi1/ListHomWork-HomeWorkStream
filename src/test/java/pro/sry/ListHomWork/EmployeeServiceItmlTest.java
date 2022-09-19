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


import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceItmlTest {

   /* Employee employee1 = new Employee("Илья", "Щербаков", 200_000, 1);
    Employee employee2 = new Employee("Виталий", "Малахов", 150_000, 2);*/


    private final EmployeeServiceImpl out=new EmployeeServiceImpl();

    @Test
    public void shouldAddEmployee() {
        Employee expected = out.add("Илья", "Щербаков", 200_000, 1);
        assertEquals(1,out.findAll().size());
        assertTrue(out.findAll().contains(expected));
        Employee actual = out.add("Илья", "Щербаков", 200_000, 1);
        assertEquals(expected,actual);
        assertEquals(2,out.findAll().size());
        assertTrue(out.findAll().contains((expected)));
    }

    @Test
    public void shouldThrowEmployee(){
        Employee existed = out.add("Илья", "Щербаков", 200_000, 1);
        assertTrue(out.findAll().contains(existed));
        assertThrows(EmployeeNotFoundException.class,
                () -> out.add("Илья", "Щербаков", 200_000, 1));
    }

    @Test
    public void shouldFindEmployee() {
        Employee existed = out.add("Илья", "Щербаков", 200_000, 1);
        assertEquals(existed, out.find("Илья", "Щербаков", 200_000, 1));
    }
    @Test
    public void shouldFindEmployeeThrowDontFind() {
        assertEquals(0, out.findAll().size());
        assertThrows(EmployeeNotFoundException.class,
                () -> out.find("Илья", "Щербаков", 200_000, 1));
    }

    @Test
    public void shouldRemoveEmployee(){
        Employee expected = out.add("Илья", "Щербаков", 200_000, 1);
        assertEquals(1, out.findAll().size());
        assertTrue(out.findAll().isEmpty());
        assertFalse(out.findAll().contains(expected));
    }
    @Test
    public void shouldReturnListOfEmployee() {
        Employee employee1 = out.add("Илья", "Щербаков", 200_000, 1);
        Employee employee2 = out.add("Виталий", "Малахов", 150_000, 2);
        Collections expected = (Collections) List.of(employee1,employee2);
        Collections actual = (Collections) out.findAll();
        assertIterableEquals((Iterable<?>) expected, (Iterable<?>) actual);
    }
}

