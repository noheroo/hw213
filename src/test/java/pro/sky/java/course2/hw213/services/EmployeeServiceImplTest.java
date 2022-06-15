package pro.sky.java.course2.hw213.services;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.hw213.data.Employee;
import pro.sky.java.course2.hw213.exeptions.EmployeeAlreadyAddedException;
import pro.sky.java.course2.hw213.exeptions.EmployeeNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.hw213.Constants.*;

class EmployeeServiceImplTest {

    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    @Test
    void addEmployeeTest() {
        Employee employeeExtend = out.addEmployee(lastName, firstName, salary, department);
        Employee employeeActual = new Employee(lastName, firstName, salary, department);

        assertEquals(employeeExtend, employeeActual);
    }

    @Test
    void removeEmployeeTest() {
        out.addEmployee(lastName, firstName, salary, department);

        Employee employeeExtend = out.removeEmployee(lastName, firstName);
        Employee employeeActual = new Employee(lastName, firstName, salary, department);

        assertEquals(employeeExtend, employeeActual);
    }

    @Test
    void findEmployeeTest() {
        out.addEmployee(lastName, firstName, salary, department);

        Employee employeeExtend = out.findEmployee(lastName, firstName);
        Employee employeeActual = new Employee(lastName, firstName, salary, department);

        assertEquals(employeeExtend, employeeActual);
    }

    @Test
    void addExistingEmployee() {
        out.addEmployee(lastName, firstName, salary, department);
        assertThrows(EmployeeAlreadyAddedException.class, () -> out.addEmployee(lastName, firstName, salary, department));
    }

    @Test
    void removeEmployeeWhoAbsent() {
        assertThrows(EmployeeNotFoundException.class, () -> out.removeEmployee(lastName, firstName));
    }

    @Test
    void findEmployeeWhoAbsent() {
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployee(lastName, firstName));
    }
}