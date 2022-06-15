package pro.sky.java.course2.hw213.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.hw213.data.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.java.course2.hw213.Constants.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {


    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;

    Employee employee1 = new Employee("Denisov", "Denis", 40_000, 1);
    Employee employee2 = new Employee("Denissov", "Deniss", 50_000, 1);
    Employee employee3 = new Employee("Vanin", "Ivan", 80_000, 5);
    Employee employee4 = new Employee("Pertov", "Ford", 56_000, 3);

    List<Employee> employees = List.of(employee1, employee2, employee3, employee4);


    @Test
    void getEmployeeInDepartmentMinSalary() {
        when(employeeService.findAll()).thenReturn(employees);
        assertEquals(out.getEmployeeInDepartmentMinSalary(one), employee1);
    }

    @Test
    void getEmployeeInDepartmentMaxSalary() {
        when(employeeService.findAll()).thenReturn(employees);
        assertEquals(out.getEmployeeInDepartmentMaxSalary(one), employee2);
    }

    @Test
    void printEmployeesInDepartment() {
        when(employeeService.findAll()).thenReturn(employees);
        assertEquals(out.printEmployeesInDepartment(three), List.of(employee4));
    }

    @Test
    void printEmployeesDepartment() {
        when(employeeService.findAll()).thenReturn(employees);

        ArrayList<Employee> sortEmployees = new ArrayList<>(employees);
        sortEmployees.sort(Comparator.comparing(Employee::getDepartment));

        assertEquals(out.printEmployeesDepartment(), sortEmployees);
    }

    @Test
    void getEmployeeInDepartmentMinSalaryInAbsentDepartment() {
        when(employeeService.findAll()).thenReturn(employees);

        assertThrows(RuntimeException.class,()->out.getEmployeeInDepartmentMinSalary(two));
    }

    @Test
    void getEmployeeInDepartmentMaxSalaryInAbsentDepartment() {
        when(employeeService.findAll()).thenReturn(employees);

        assertThrows(RuntimeException.class,()->out.getEmployeeInDepartmentMaxSalary(two));
    }

    @Test
    void printEmployeesInDepartmentTestInAbsentDepartment() {
        when(employeeService.findAll()).thenReturn(employees);

        assertEquals(out.printEmployeesInDepartment(two), List.of());
    }

}