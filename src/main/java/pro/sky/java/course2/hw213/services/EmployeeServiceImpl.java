package pro.sky.java.course2.hw213.services;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.hw213.data.Employee;
import pro.sky.java.course2.hw213.exeptions.EmployeeAlreadyAddedException;
import pro.sky.java.course2.hw213.exeptions.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String lastName, String firstName, int salary, int department) {
        if (employees.containsKey(createKey(lastName, firstName))) {
            throw new EmployeeAlreadyAddedException();
        }
        Employee employee = new Employee(lastName, firstName, salary, department);
        employees.put(createKey(lastName, firstName), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String lastName, String firstName) {
        if (!employees.containsKey(createKey(lastName, firstName))) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(createKey(lastName, firstName));
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) {
        if (!employees.containsKey(createKey(lastName, firstName))) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(createKey(lastName, firstName));
    }

    @Override
    public Map<String, Employee> printEmployees() {
        return employees;
    }

    private String createKey(String lastName, String firstName) {
        return lastName + " " + firstName;
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }
}


